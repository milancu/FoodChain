package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Transport{
    companion object TransportCompany {
        var name : String = "Transport S.R.O"
        var identifier : String = "12345678"
        var amountOfMoney : Double = 10000.00
        var cropSupplies : ArrayList<Crop> = ArrayList<Crop>()

        fun transportCropSuplies() : List<Crop>{
            for(supply in cropSupplies){
                amountOfMoney += supply.getShopPrice() * supply.getAmount() * 0.1
            }
            return cropSupplies
        }

        fun takeCropSupplies(supplies : List<Crop>){
            for(supply in supplies){
                cropSupplies.toMutableList().add(supply)
            }
        }

    }
        // Tansprot price 0.1 plodiny, pocita se z ostatnich
}