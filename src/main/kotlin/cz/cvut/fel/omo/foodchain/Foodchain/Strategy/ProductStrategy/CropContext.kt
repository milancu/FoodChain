package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.ProductStrategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Crop context
 *
 * @property strategy
 * @constructor Create empty Crop context
 */
class CropContext(var strategy: ProcessorCropStrategy) {

    /**
     * Set strategy
     *
     * @param strategy
     */
    fun setStrategy(strategy : CerealCropStrategy){
        this.strategy = strategy
    }

    /**
     * Set strategy
     *
     * @param strategy
     */
    fun setStrategy(strategy : FruitCropStrategy){
        this.strategy = strategy
    }

    /**
     * Set strategy
     *
     * @param strategy
     */
    fun setStrategy(strategy : LegumesCropStrategy){
        this.strategy = strategy
    }

    /**
     * Set strategy
     *
     * @param strategy
     */
    fun setStrategy(strategy : FlowerCropStrategy){
        this.strategy = strategy
    }

    /**
     * Set strategy
     *
     * @param strategy
     */
    fun setStrategy(strategy : VegetableCropStrategy){
        this.strategy = strategy
    }

    /**
     * Process product
     *
     * @param crop
     * @return
     */
    fun processProduct(crop : Crop) : Product{
        return strategy.execute(crop)
    }


}