package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Farmer(subjectName : String, identier : Int, location : String, amountOfMoney : Int)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

    var resources : List<Crop> = setInitialResources()

    fun setInitialResources() : List<Crop>{
             var initialResources : List<Crop> = TODO()
             // TODO podle potravin
             return initialResources
       }

    fun decreaseResource(feed : Crop) {
        for(resource in resources){
            if(resource.getName() == feed.getName()){
                val realValue : Int = resource.getAmount() - feed.getAmount();
                resource.setAmount(realValue)
            }
        }
    }

}