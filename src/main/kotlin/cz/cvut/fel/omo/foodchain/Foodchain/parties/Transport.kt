package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Transport{
    companion object TransportCompany {
        private var name : String = "Transport S.R.O"
        private var identifier : String = "12345678"
        private var amountOfMoney : Double = 10000.00
        private var cropSupplies : ArrayList<Crop> = ArrayList()
        var products : ArrayList<Product> = ArrayList() //todo private
        private var meats : ArrayList<Meat> = ArrayList()

        fun transportCropSuplies() : ArrayList<Crop>{
            var toTransport : ArrayList<Crop> = cropSupplies
            for(supply in cropSupplies){
                amountOfMoney += supply.getShopPrice() * supply.getAmount() * 0.1 // TODO od koho si je vezme
            }
            this.cropSupplies = ArrayList()
            return toTransport
        }

        fun transportProducts() : ArrayList<Product>{
            var toTransport : ArrayList<Product> = products
            /*println("/////////////////////////////////////")
            println("k prevezeni: " + toTransport.size)
            println("/////////////////////////////////////")*/
            for(product in products){
                amountOfMoney += product.getShopPrice() * product.getAmount() * 0.1 //TODO invoice smerem od transportu
            }
            this.products = ArrayList()
            return toTransport
        }

        fun transportMeats() : ArrayList<Meat>{
            var toTransport : ArrayList<Meat> = meats
            for(meat in meats){
                amountOfMoney += meat.getShopPrice() * meat.getAmount() * 0.1 //TODO invoice smerem od transportu
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
            for(meat in meats){
                this.meats.add(meat)
            }
        }

        // TODO odecet za opotrebeni aut a benzin a platy - nezapomen to zavolat
        fun cargoDeduction(){
            var costs : Double = 0.0
            for(meat in meats){
                costs += meat.getShopPrice() * meat.getAmount() * 0.025
            }
            for(crop in cropSupplies){
                costs += crop.getShopPrice() * crop.getAmount() * 0.025
            }
            for(product in products){
                costs += product.getShopPrice() * product.getAmount() * 0.025
            }
            this.amountOfMoney -= costs
            println("Dopravni spolecnost na nakladech utratila: " + costs)
        }
    }
}