package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

interface ProcessorCropStrategy {
    fun execute(crop : Crop) {
        var randomIndex = (1..3).random();
        when (randomIndex) {
            1 ->
            2 ->
            3 ->
        }

    }
}