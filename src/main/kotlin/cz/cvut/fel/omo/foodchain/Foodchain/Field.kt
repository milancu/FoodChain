package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import kotlin.math.roundToInt

class Field {

    // TODO doba rustu

    private var crop : Crop
    private val capacity : Int
    private var isRaised : Boolean = true

    constructor(crop: Crop, capacity: Int) {
        this.crop = crop
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
        crop.resetCrop()
        crop.setAmount(capacity)
    }

    fun getCrop() : Crop{
       return crop
    }
}