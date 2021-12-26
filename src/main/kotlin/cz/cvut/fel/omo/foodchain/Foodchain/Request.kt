package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.*
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Request {
    companion object requestService {

        // TODO kam ukladat faktury

        fun requestTransportToProcessor(grower: Grower, processor: Processor, crops: ArrayList<Crop>) {
            println("Proces transportace (from farmer " + grower.getIdentifier() + " to processor) " + processor.getIdentifier())
            // Faktury
            var money: Double = 0.0
            for (crop in crops) {
                money += crop.getAmount() * crop.getShopPrice()
            }
            var invoice: Invoice = Invoice(processor, grower, money, InvoiceType.CROP)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            println("Vznik faktury " + invoice.getCode())

            grower.transportSupplies()
            Transport.cargoDeduction()
            grower.raiseField()

            // TODO new Invoice
            var transportInvoice : Invoice = Invoice(processor, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            processor.payForInvoice(transportInvoice)

            processor.takeCropSupplies(Transport.transportCropSuplies())
            processor.payForInvoice(invoice)
            println()
        }

        fun requestTransportToMeatFactory(farmer: Farmer, meatFactory: MeatFactory) {
            println("Proces transportace (from farmer " + farmer.getIdentifier() + " to processor) " + meatFactory.getIdentifier())

            // Poslani zvirat na jatka
            var processedAnimals: ArrayList<Meat> = farmer.callButcher()
            println("Na jatka poslano : " + processedAnimals.size)

            // Faktura
            var money: Double = 0.0
            for (animal in processedAnimals) {
                money += animal.getAmount() * animal.getShopPrice()
            }
            var invoice: Invoice = Invoice(meatFactory, farmer, money, InvoiceType.MEAT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            println("Vznik faktury " + invoice.getCode())

            Transport.takeMeat(processedAnimals)
            Transport.cargoDeduction()
            meatFactory.takeMeat(Transport.transportMeats())

            // TODO new Invoice
            var transportInvoice : Invoice = Invoice(meatFactory, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            meatFactory.payForInvoice(transportInvoice)

            meatFactory.payForInvoice(invoice)

            println()
        }

        fun requestTransportToWarehouse(processor: Processor, retailer: Retailer) {
            println("Proces transportace (from processor " + processor.getIdentifier() + " to retailer " + retailer.getIdentifier())

            processor.transportProducts()
            Transport.cargoDeduction()
            var transportedProducts : ArrayList<Product> = Transport.transportProducts()

            // Faktura
            var money: Double = 0.0

            for (product in transportedProducts) {
                money += product.getAmount() * product.getShopPrice()
            }
            var invoice: Invoice = Invoice(retailer, processor, money, InvoiceType.PRODUCT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            println("Vznik faktury " + invoice.getCode())

            // TODO new Invoice
            var transportInvoice : Invoice = Invoice(retailer, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            retailer.payForInvoice(transportInvoice)

            retailer.buyProducts(transportedProducts) // todo invoice retailer a transport
            retailer.payForInvoice(invoice)
        }

        fun requestTransportToWarehouse(meatFactory: MeatFactory, retailer: Retailer) {
            println("Proces transportace (from Vodnany  to retailer " + retailer.getIdentifier())

            meatFactory.transportProducts()
            Transport.cargoDeduction()
            val transportedProducts : ArrayList<Product> = Transport.transportProducts()

            // Faktura
            var money : Double = 0.0
            for (product in transportedProducts){
                money += product.getAmount() * product.getShopPrice()
            }
            val invoice: Invoice = Invoice(retailer, meatFactory, money, InvoiceType.PRODUCT)
            Invoices.invoices.add(invoice)
            invoice.attach(Report)
            invoice.notifyUpdate()
            println("Vznik faktury " + invoice.getCode())

            // TODO new Invoice
            var transportInvoice : Invoice = Invoice(retailer, Transport.transport, money * Config.TRANSPORT_TAX, InvoiceType.TRANSPORT)
            retailer.payForInvoice(transportInvoice)

            retailer.buyProducts(transportedProducts) // todo invoice retailer a transport
            retailer.payForInvoice(invoice)
        }

        fun requestFarmerBuyCrops(farmer: Farmer, grower: Grower){
            println("Farmer: " + farmer.getIdentifier() + " nakupuje zasoby od " + grower.getIdentifier())

            var money: Double = 0.0

            for(crop in grower.getSupplies()){
                if(crop.getType() == CropType.CEREAL){
                    money += crop.getAmount() * crop.getShopPrice()
                    farmer.takeResources(crop)
                    grower.getSupplies().remove(crop)
                    break
                }
            }

            var invoice: Invoice = Invoice(farmer, grower, money, InvoiceType.PRODUCT)
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
            var money : Double = customer.buyProducts(retailer.getAvailableProducts())
            var invoice : Invoice = Invoice(customer, retailer, money, InvoiceType.SHOPPING)
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