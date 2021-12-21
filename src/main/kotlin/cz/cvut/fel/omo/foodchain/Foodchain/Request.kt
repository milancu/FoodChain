package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Transport
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Request {
    companion object requestService{

        // TODO kam ukladat faktury

        fun requestTransportToProcessor(grower: Grower, processor: Processor, crops : ArrayList<Crop>){

            // Faktury
            var money : Double = 0.0
            for(crop in crops){
                money += crop.getAmount() * crop.getShopPrice()
            }
            var invoice : Invoice = Invoice(processor, grower, money, InvoiceType.CROP)

            grower.transportSupplies()

            processor.takeCropSupplies(Transport.transportCropSuplies()) // todo invoice processorem a transportem
            processor.payForInvoice(invoice)
        }

        fun requestTransportToWarehouse(processor : Processor, retailer: Retailer, products : ArrayList<Product>){
            var money : Double = 0.0
            for(product in products){
                money += product.getAmount() * product.getShopPrice()
            }
            var Invoice : Invoice = Invoice(retailer, processor, money, InvoiceType.PRODUCT)

            processor.transportProducts()

            retailer.buyProducts(Transport.transportProducts()) // todo invoice retailer a transport


        }

        fun requestTransportToRetailer(){

        }

    }
}