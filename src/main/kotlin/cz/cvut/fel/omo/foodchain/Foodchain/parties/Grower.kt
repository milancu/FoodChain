package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.Field


class Grower(subjectName : String, identier : Int, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

    val fields : List<Field> = setInitialField()
    var supplies : List<Crop> = setInitalSupplies()

    fun setInitialField() : List<Field>{
        return TODO()
    }

    fun setInitalSupplies() : List<Crop>{
        return TODO()
    }

    fun raiseField(){
        for(field in fields){
            if(amountOfMoney >= field.getCrop().getProductionCost()){
                field.setRaised(true)
                amountOfMoney -= field.getCrop().getProductionCost();
            }
            else if(field.isRaised()){
                field.setRaised(false)
            } else {
                field.decreaseProduction()
            }
        }
    }

    fun harvest() : List<Crop>{
        var harvestedCrop = emptyList<Crop>()
        for(field in fields){
            harvestedCrop.toMutableList().add(field.getCrop())
            field.resetField()
        }
        return harvestedCrop; //TODO proces, prodata doplnit harvest
    }

    fun transportSupplies(){
        Transport.TransportCompany.takeCropSupplies(supplies)
    }

    fun sellSupplies() {
        for(supply in supplies){
            this.amountOfMoney += supply.getAmount() * supply.getShopPrice()
        }
        supplies = emptyList();
    }





}









