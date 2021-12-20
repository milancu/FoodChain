package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product


class FlowerStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        when(crop.getName()){
            CropName.FLEX -> return TODO()
            CropName.HEMP -> return TODO()
            CropName.OILSEED -> return TODO()
            CropName.POPPY -> return TODO()
            CropName.SUNFLOWER -> return TODO()
            else -> throw Exception("Wrong crop name input")
        }
    }
}