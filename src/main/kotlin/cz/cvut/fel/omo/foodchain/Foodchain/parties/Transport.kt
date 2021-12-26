package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Transport
 *
 * @constructor Create empty Transport
 */
class Transport{
    companion object TransportCompany {

        var transport : BaseParty = BaseParty("Transport S.R.O", "Unknown", 10000.00)

        /*private var amountOfMoney : Double = 10000.00*/
        private var cropSupplies : ArrayList<Crop> = ArrayList()
        private var products : ArrayList<Product> = ArrayList()
        private var meats : ArrayList<Meat> = ArrayList()

        fun transportCropSuplies() : ArrayList<Crop>{
            val toTransport : ArrayList<Crop> = cropSupplies
            for(supply in cropSupplies){
                transport.changeAmountOfMoney((supply.getShopPrice() * supply.getAmount() * 0.1))
/*
                amountOfMoney += supply.getShopPrice() * supply.getAmount() * 0.1 // TODO od koho si je vezme
*/
            }
            this.cropSupplies = ArrayList()
            return toTransport
        }

        fun transportProducts() : ArrayList<Product>{
            val toTransport : ArrayList<Product> = products
            for(product in products){
                transport.changeAmountOfMoney((product.getShopPrice() * product.getAmount() * 0.1))
/*
                amountOfMoney += product.getShopPrice() * product.getAmount() * 0.1 //TODO invoice smerem od transportu
*/
            }
            this.products = ArrayList()
            return toTransport
        }

        fun transportMeats() : ArrayList<Meat>{
            val toTransport : ArrayList<Meat> = meats
            for(meat in meats){
                transport.changeAmountOfMoney((meat.getShopPrice() * meat.getAmount() * 0.1))
/*
                amountOfMoney += meat.getShopPrice() * meat.getAmount() * 0.1 //TODO invoice smerem od transportu
*/
            }
            this.meats = ArrayList()
            return toTransport
        }

        fun takeCropSupplies(supplies : ArrayList<Crop>){
            if(supplies.size == 0) return
            for(supply in supplies){
                this.cropSupplies.add(supply)
            }
        }

        fun takeProducts(products : ArrayList<Product>){
            for(product in products){
                this.products.add(product)
            }
        }

        fun takeMeat(meats : ArrayList<Meat>){
            println("transport prebira masa : " + meats.size)
            for(meat in meats){
                this.meats.add(meat)
            }
            println("Transport prevzal masa : " + this.meats.size)
        }


        fun cargoDeduction(){
            var costs = 0.0
            for(meat in meats){
                costs += meat.getShopPrice() * meat.getAmount() * 0.025
            }
            for(crop in cropSupplies){
                costs += crop.getShopPrice() * crop.getAmount() * 0.025
            }
            for(product in products){
                costs += product.getShopPrice() * product.getAmount() * 0.025
            }
/*
            this.amountOfMoney -= costs
*/
            transport.changeAmountOfMoney(-costs)
            println("Dopravni spolecnost na nakladech utratila: $costs")
        }

        fun getIdentifier() : Int{
            return transport.getIdentifier()
        }
    }
}