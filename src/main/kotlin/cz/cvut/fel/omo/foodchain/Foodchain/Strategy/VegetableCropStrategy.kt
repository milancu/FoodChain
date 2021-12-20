package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class VegetableCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop) : Product {
        when (crop.getName()) {
            CropName.POTATO -> return TODO()
            CropName.SALAD -> return Product(
                crop.getName().toString(),
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                1,
                "kg"
            )
            CropName.CUCCUMBER -> return TODO()
            CropName.TOMATO -> return TODO()
            CropName.ONION -> return TODO()
            CropName.SUGARBEAT -> return TODO()
            else -> throw Exception("Wrong crop name input")
        }
    }

    fun createFromPotato(crop : Crop) : Product{

    }

}