package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.Field
import cz.cvut.fel.omo.foodchain.Foodchain.Generator


class Grower(subjectName : String, identier : Int, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

    private val fields : ArrayList<Field> = setInitialField()
    private var supplies : ArrayList<Crop> = setInitalSupplies()

    private fun setInitialField() : ArrayList<Field>{
        val generator : Generator = Generator()
        return generator.generateFields()
    }

    private fun setInitalSupplies() : ArrayList<Crop>{
        val generator : Generator = Generator()
        return generator.generateCrops()
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

    fun harvest(){
        var harvestedCrop : ArrayList<Crop> = ArrayList()
        for(field in fields){
            if(field.getCrop().getGrowth() >= 10){
                println("Plodina " + field.getCrop().getName() + " sklizena v poctu " + field.getCrop().getAmount())
                harvestedCrop.add(field.getCrop())
                field.resetField()
            }
        }

        for(crop in harvestedCrop){
            supplies.add(crop)
        }

        println()
    }

    fun transportSupplies(){
        Transport.TransportCompany.takeCropSupplies(supplies)
        // TODO odecet za dopravu, faktura...
        supplies = ArrayList();
    }

    fun getSupplies() : ArrayList<Crop> {
        return supplies
    }

}









