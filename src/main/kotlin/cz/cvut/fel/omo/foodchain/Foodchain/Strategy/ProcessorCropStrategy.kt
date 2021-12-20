package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName

interface ProcessorCropStrategy {
    fun execute(cropName : CropName);

}