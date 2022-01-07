package cz.cvut.fel.omo.foodchain.Foodchain.statics

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.*
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product
import cz.cvut.fel.omo.foodchain.Foodchain.strategies.product_strategy.MeatStrategy
import org.slf4j.LoggerFactory

/**
 * Request
 *
 * @constructor Create empty Request
 */
class Request {
    companion object RequestService {

        private val logger = LoggerFactory.getLogger(javaClass)

        fun requestTransportToProcessor(grower: Grower, processor: Processor, crops: ArrayList<Crop>) {
            logger.info("Proces transportace (from farmer " + grower.getIdentifier() + " to processor) " + processor.getIdentifier())
            var money = 0.0
            for (crop in crops) {
                money += crop.getAmount() * crop.getShopPrice()
            }
            val invoice = Invoice(processor, grower, money, InvoiceType.CROP)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            logger.info("Vznik faktury " + invoice.getCode())

            grower.transportSupplies()
            Transport.cargoDeduction()
            grower.raiseField()

            val transportInvoice = Invoice(processor, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            Invoices.invoices.add(transportInvoice)
            transportInvoice.attach(Report)
            transportInvoice.notifyUpdate()
            processor.payForInvoice(transportInvoice)

            processor.takeCropSupplies(Transport.transportCropSuplies())
            processor.payForInvoice(invoice)
        }

        fun requestTransportToMeatFactory(farmer: Farmer, meatFactory: MeatFactory) {
            logger.info("Proces transportace (from farmer " + farmer.getIdentifier() + " to processor) " + meatFactory.getIdentifier())

            // Poslani zvirat na jatka
            val processedAnimals: ArrayList<Meat> = farmer.callButcher() // pouze zabyte, musi se rozdelit na jednotlive casti jeste
            logger.info("Na jatka poslano : " + processedAnimals.size)

            // Faktura
            var money = 0.0
            for (animal in processedAnimals) {
                money += animal.getAmount() * animal.getShopPrice()
            }
            val invoice = Invoice(meatFactory, farmer, money, InvoiceType.MEAT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            logger.info("Vznik faktury " + invoice.getCode())


            val processedMeat =  ArrayList<MeatProduct>()

            val meatStrategy = MeatStrategy();

            for(meat in processedAnimals){
                processedMeat.addAll(meatStrategy.execute(meat));
            }


            Transport.takeMeat(processedMeat)
            Transport.cargoDeduction()
            meatFactory.takeMeat(Transport.transportMeats())

            val transportInvoice = Invoice(meatFactory, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            Invoices.invoices.add(transportInvoice)
            transportInvoice.attach(Report)
            transportInvoice.notifyUpdate()
            meatFactory.payForInvoice(transportInvoice)
            meatFactory.payForInvoice(invoice)
        }

        fun requestTransportToWarehouse(processor: Processor, retailer: Retailer) {
            logger.info("Proces transportace (from processor " + processor.getIdentifier() + " to retailer " + retailer.getIdentifier())

            processor.transportProducts()
            Transport.cargoDeduction()
            val transportedProducts : ArrayList<Product> = Transport.transportProducts()

            // Faktura
            var money = 0.0

            for (product in transportedProducts) {
                money += product.getAmount() * product.getShopPrice()
            }
            val invoice = Invoice(retailer, processor, money, InvoiceType.PRODUCT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            logger.info("Vznik faktury " + invoice.getCode())

            val transportInvoice = Invoice(retailer, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            Invoices.invoices.add(transportInvoice)
            transportInvoice.attach(Report)
            transportInvoice.notifyUpdate()
            retailer.payForInvoice(transportInvoice)

            retailer.buyProducts(transportedProducts)
            retailer.payForInvoice(invoice)
        }

        fun requestTransportToWarehouse(meatFactory: MeatFactory, retailer: Retailer) {
            logger.info("Proces transportace (from Vodnany  to retailer " + retailer.getIdentifier())

            meatFactory.transportProducts()
            Transport.cargoDeduction()
            val transportedProducts : ArrayList<Product> = Transport.transportProducts()

            // Faktura
            var money = 0.0
            for (product in transportedProducts){
                money += product.getAmount() * product.getShopPrice()
            }
            val invoice = Invoice(retailer, meatFactory, money, InvoiceType.PRODUCT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            logger.info("Vznik faktury " + invoice.getCode())

            val transportInvoice = Invoice(retailer, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            Invoices.invoices.add(transportInvoice)
            transportInvoice.attach(Report);
            transportInvoice.notifyUpdate();
            retailer.payForInvoice(transportInvoice)

            retailer.buyProducts(transportedProducts)
            retailer.payForInvoice(invoice)
        }

        fun requestFarmerBuyCrops(farmer: Farmer, grower: Grower){
            logger.info("Farmer: " + farmer.getIdentifier() + " nakupuje zasoby od " + grower.getIdentifier())

            var money = 0.0

            for(crop in grower.getSupplies()){
                if(crop.getType() == CropType.CEREAL){
                    money += crop.getAmount() * crop.getShopPrice()
                    farmer.takeResources(crop)
                    grower.getSupplies().remove(crop)
                    break
                }
            }

            val invoice = Invoice(farmer, grower, money, InvoiceType.PRODUCT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            logger.info("Vznik faktury " + invoice.getCode())
            farmer.payForInvoice(invoice)
        }

        fun requestProccessMeat(meatFactory: MeatFactory){
            meatFactory.packageProduct()
        }

        fun requestGoShopping(retailer : Retailer, customer: Customer){
            val pair : Pair<Double, ArrayList<Product>> = customer.buyProducts(retailer.getAvailableProducts())
            val money : Double = pair.first
            val products : ArrayList<Product> = pair.second

            retailer.refreshAvailableProducts(products)

            val invoice = Invoice(customer, retailer, money, InvoiceType.SHOPPING)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            logger.info("Customer: " + customer.getIdentifier() + " utratil: " + money + " za nakupy a ma: " + customer.getAmountOfMoney())
            customer.payForShopping(invoice)
        }

        fun requestTakeOutToShop(retailer: Retailer){
            retailer.fillIn()
        }
    }
}