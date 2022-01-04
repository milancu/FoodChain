package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.*
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Request
 *
 * @constructor Create empty Request
 */
class Request {
    companion object RequestService {


        fun requestTransportToProcessor(grower: Grower, processor: Processor, crops: ArrayList<Crop>) {
            println("Proces transportace (from farmer " + grower.getIdentifier() + " to processor) " + processor.getIdentifier())
            // Faktury
            var money = 0.0
            for (crop in crops) {
                money += crop.getAmount() * crop.getShopPrice()
            }
            val invoice = Invoice(processor, grower, money, InvoiceType.CROP)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            println("Vznik faktury " + invoice.getCode())

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
            println()
        }

        fun requestTransportToMeatFactory(farmer: Farmer, meatFactory: MeatFactory) {
            println("Proces transportace (from farmer " + farmer.getIdentifier() + " to processor) " + meatFactory.getIdentifier())

            // Poslani zvirat na jatka
            val processedAnimals: ArrayList<Meat> = farmer.callButcher()
            println("Na jatka poslano : " + processedAnimals.size)

            // Faktura
            var money = 0.0
            for (animal in processedAnimals) {
                money += animal.getAmount() * animal.getShopPrice()
            }
            val invoice = Invoice(meatFactory, farmer, money, InvoiceType.MEAT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            println("Vznik faktury " + invoice.getCode())

            Transport.takeMeat(processedAnimals)
            Transport.cargoDeduction()
            meatFactory.takeMeat(Transport.transportMeats())

            val transportInvoice = Invoice(meatFactory, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            Invoices.invoices.add(transportInvoice)
            transportInvoice.attach(Report)
            transportInvoice.notifyUpdate()
            meatFactory.payForInvoice(transportInvoice)
            meatFactory.payForInvoice(invoice)

            println()
        }

        fun requestTransportToWarehouse(processor: Processor, retailer: Retailer) {
            println("Proces transportace (from processor " + processor.getIdentifier() + " to retailer " + retailer.getIdentifier())

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
            println("Vznik faktury " + invoice.getCode())

            val transportInvoice = Invoice(retailer, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            Invoices.invoices.add(transportInvoice)
            transportInvoice.attach(Report)
            transportInvoice.notifyUpdate()
            retailer.payForInvoice(transportInvoice)

            retailer.buyProducts(transportedProducts)
            retailer.payForInvoice(invoice)
        }

        fun requestTransportToWarehouse(meatFactory: MeatFactory, retailer: Retailer) {
            println("Proces transportace (from Vodnany  to retailer " + retailer.getIdentifier())

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
            println("Vznik faktury " + invoice.getCode())

            val transportInvoice = Invoice(retailer, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            Invoices.invoices.add(transportInvoice)
            transportInvoice.attach(Report);
            transportInvoice.notifyUpdate();
            retailer.payForInvoice(transportInvoice)

            retailer.buyProducts(transportedProducts)
            retailer.payForInvoice(invoice)
        }

        fun requestFarmerBuyCrops(farmer: Farmer, grower: Grower){
            println("Farmer: " + farmer.getIdentifier() + " nakupuje zasoby od " + grower.getIdentifier())

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
            println("Vznik faktury " + invoice.getCode())
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
            println("Customer: " + customer.getIdentifier() + " utratil: " + money + " za nakupy a ma: " + customer.getAmountOfMoney())
            customer.payForShopping(invoice)
        }

        fun requestTakeOutToShop(retailer: Retailer){
            retailer.fillIn()
        }
    }
}