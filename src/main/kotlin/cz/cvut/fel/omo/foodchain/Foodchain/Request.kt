package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.*
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Request {
    companion object requestService {

        // TODO kam ukladat faktury

        fun requestTransportToProcessor(grower: Grower, processor: Processor, crops: ArrayList<Crop>, time: Int) {
            println("Proces transportace (from farmer " + grower.getIdentifier() + " to processor) " + processor.getIdentifier())
            // Faktury
            var money: Double = 0.0
            for (crop in crops) {
                money += crop.getAmount() * crop.getShopPrice()
            }
            var invoice: Invoice = Invoice(processor, grower, money, InvoiceType.CROP, time)
            invoice.attach(Report)
            println("Vznik faktury " + invoice.getCode())

            grower.transportSupplies()
            grower.raiseField()

            processor.takeCropSupplies(Transport.transportCropSuplies()) // todo invoice processorem a transportem
            processor.payForInvoice(invoice, time)
            println()
        }

        fun requestTransportToMeatFactory(farmer: Farmer, meatFactory: MeatFactory, time: Int) {
            println("Proces transportace (from farmer " + farmer.getIdentifier() + " to processor) " + meatFactory.getIdentifier())

            // Poslani zvirat na jatka
            var processedAnimals: ArrayList<Meat> = farmer.callButcher()

            // Faktura
            var money: Double = 0.0
            for (animal in processedAnimals) {
                money += animal.getAmount() * animal.getShopPrice()
            }
            var invoice: Invoice = Invoice(meatFactory, farmer, money, InvoiceType.MEAT, time)
            invoice.attach(Report)
            println("Vznik faktury " + invoice.getCode())

            Transport.takeMeat(processedAnimals) //todo platba pro transport
            meatFactory.takeMeat(Transport.transportMeats())
            meatFactory.payForInvoice(invoice, time)

            println()
        }

        fun requestTransportToWarehouse(processor: Processor, retailer: Retailer, time: Int) {
            println("Proces transportace (from processor " + processor.getIdentifier() + " to retailer " + retailer.getIdentifier())

            // Faktura
            var money: Double = 0.0

            processor.transportProducts() //TODO tady to pada ...

            for (product in Transport.transportProducts()) {
                money += product.getAmount() * product.getShopPrice()
            }
            var invoice: Invoice = Invoice(retailer, processor, money, InvoiceType.PRODUCT, time)
            invoice.attach(Report)


            processor.transportProducts()
            println("Vznik faktury " + invoice.getCode())

            retailer.buyProducts(Transport.transportProducts()) // todo invoice retailer a transport
            retailer.payForInvoice(invoice, time)
        }

        fun requestTransportToWarehouse(meatFactory: MeatFactory, retailer: Retailer) {

        }
    }
}