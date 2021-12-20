package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.Field


class Grower(subjectName : String, identier : Int, location : String, amountOfMoney : Int)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

    val fields : List<Field> = setInitialField()
    var supplies : List<Crop> = setInitalSupplies()

    fun setInitialField() : List<Field>{
        return TODO()
    }

    fun setInitalSupplies() : List<Crop>{
        return TODO()
    }

    fun raiseAboutField(){
        for(field in fields){
            if(amountOfMoney >= 1000){
                field.setRaised(true)
            }
            else if(field.isRaised()){
                field.setRaised(false)
            } else {
                field.decreaseProduction()
            }
        }
    }

    fun harvest() : List<Crop>{
        for(field in fields){
            // TODO sebrani
            field.resetField()
        }
        return TODO()
    }



}









