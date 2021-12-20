package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

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

    fun setStrategy(strategy : LegumesStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : SeedsStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : VegetableCropStrategy){
        this.strategy = strategy
    }

    fun processProduct(crop : Crop){
        strategy.execute(crop)
    }


}