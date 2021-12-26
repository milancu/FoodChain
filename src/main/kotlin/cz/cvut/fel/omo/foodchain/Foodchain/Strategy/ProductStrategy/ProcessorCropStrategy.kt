package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.ProductStrategy

import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Processor crop strategy
 *
 * @constructor Create empty Processor crop strategy
 */
interface ProcessorCropStrategy {
    /**
     * Execute
     *
     * @param crop
     * @return
     */
    fun execute(crop : Crop) : Product

}