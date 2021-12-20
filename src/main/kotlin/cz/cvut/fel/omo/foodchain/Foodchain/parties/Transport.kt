package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Transport(subjectName : String, identier : Int, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

    companion object TransportCompany {

        private var cropSupplies : List<Crop> = emptyList()

        fun create(): Transport = TODO() //generator

        fun expandSupplies(){
            // TODO
        }

        fun takeCropSupplies(supplies : List<Crop>){
            for(supply in supplies){
                cropSupplies.toMutableList().add(supply)
            }
        }



    }
        // Tansprot price 0.1 plodiny, pocita se z ostatnich
}