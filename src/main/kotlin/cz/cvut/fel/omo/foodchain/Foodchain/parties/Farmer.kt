package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Farmer(subjectName : String, identier : Int, location : String, amountOfMoney : Int)
    : BaseParty(subjectName, identier, location, amountOfMoney) {


    var resources : List<Crop> = setInitialResources()
        get() = field
        set(value){
            resources = value
    }

    fun setInitialResources() : List<Crop>{
             var initialResources : List<Crop> = TODO()
             // TODO podle potravin
             return initialResources
       }

    fun decreaseResource(feed : Crop) {
        for(resource in resources){
            if(resource.name == feed.name){
                resource.amount = feed.amount
            }
        }
    }



}