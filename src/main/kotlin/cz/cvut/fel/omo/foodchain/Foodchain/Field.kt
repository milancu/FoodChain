package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import kotlin.math.roundToInt

class Field {

    // TODO doba rustu

    private var crop : Crop
    private var owner :Grower
    private val capacity : Int
    private var isRaised : Boolean = true

    constructor(crop: Crop, owner: Grower, capacity: Int) {
        this.crop = crop
        this.owner = owner
        this.capacity = capacity
    }

    fun isRaised() : Boolean{
        return isRaised;
    }

    fun setRaised(value : Boolean){
        isRaised = value;
    }

    fun decreaseProduction(){
        crop.setAmount((crop.getAmount() * 0.8).roundToInt())
    }

    fun resetField(){
        crop.setAmount(capacity)
    }

    fun getCrop() : Crop{
       return crop
    }
}