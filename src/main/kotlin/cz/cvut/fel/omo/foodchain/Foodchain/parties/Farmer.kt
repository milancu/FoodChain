package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Farmer(subjectName : String, identier : Int, location : String, amountOfMoney : Int)
    : BaseParty(subjectName, identier, location, amountOfMoney) {


    private var resources : List<Crop> = setInitialResources()

    fun setInitialResources() : List<Crop>{
             var initialResources : List<Crop> = TODO()
             // TODO podle potravin
             return initialResources
       }

    set(feed : Crop){

    }
}