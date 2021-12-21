package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Transport
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

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

            grower.sellSupplies() // Pokud funguje predavani budu zpusobovat duplicitni odecet
            grower.transportSupplies()

            processor.takeCropSupplies(Transport.transportCropSuplies()) // todo invoice processorem a transportem
            processor.payForInvoice(invoice) // todo RIZIKO DVOJIHO ZAPLACENI, Presneji melo by k nemu dojit
        }

        fun requestTransportToWarehouse(){

        }

        fun requestTransportToRetailer(){

        }

    }
}