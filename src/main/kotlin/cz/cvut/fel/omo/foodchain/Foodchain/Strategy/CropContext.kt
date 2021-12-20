package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class CropContext {
    var strategy : ProcessorCropStrategy

    constructor(strategy: ProcessorCropStrategy) {
        this.strategy = strategy
    }

    fun setStrategy(strategy : CerealCropStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : FruitCropStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : LegumesCropStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : FlowerCropStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : VegetableCropStrategy){
        this.strategy = strategy
    }

    fun processProduct(crop : Crop) : Product{
        return strategy.execute(crop)
    }


}