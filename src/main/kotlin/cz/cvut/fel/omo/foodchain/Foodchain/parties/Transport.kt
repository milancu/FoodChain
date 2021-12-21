package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Transport{
    companion object TransportCompany {
        var name : String = "Transport S.R.O"
        var identifier : String = "12345678"
        var amountOfMoney : Double = 10000.00
        var cropSupplies : ArrayList<Crop> = ArrayList<Crop>()

        fun transportCropSuplies() : ArrayList<Crop>{
            for(supply in cropSupplies){
                amountOfMoney += supply.getShopPrice() * supply.getAmount() * 0.1 // TODO od koho si je vezme
            }
            return cropSupplies
        }

        fun takeCropSupplies(supplies : ArrayList<Crop>){
            for(supply in supplies){
                cropSupplies.add(supply)
            }
        }

    }
        // Tansprot price 0.1 plodiny, pocita se z ostatnich
}