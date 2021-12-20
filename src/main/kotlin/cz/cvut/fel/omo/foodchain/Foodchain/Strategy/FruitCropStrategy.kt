package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class FruitCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        if(crop.getName() == CropName.GRAPEVINE){
            return createFromVine(crop);
        }
        val random: Int = (1..4).random()
        when (random) {
            1 -> return Product(
                crop.getName().toString(),
                listOf(crop),
                crop.getShopPrice() * 1.4,
                crop.getShopPrice(),
                1,
                "kg"
            )
            2 -> return Product(
                crop.getName().toString() + "jam",
                listOf(crop),
                crop.getShopPrice() + 50,
                crop.getShopPrice(),
                (crop.getAmount() * 0.85).toInt(),
                "kg"
            )
            3 -> return Product(
                crop.getName().toString() + "juice",
                listOf(crop),
                crop.getShopPrice() + 50,
                crop.getShopPrice(),
                (crop.getAmount() * 0.85).toInt(),
                "l"
            )
            else -> return Product(
                crop.getName().toString() + "compote",
                listOf(crop),
                crop.getShopPrice() + 40,
                crop.getShopPrice(),
                (crop.getAmount() * 0.85).toInt(),
                "kg"
            )
        }
    }

    fun createFromVine(crop : Crop) : Product{
        val random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                crop.getName().toString(),
                listOf(crop),
                crop.getShopPrice() * 1.4,
                crop.getShopPrice(),
                1,
                "kg")
            else -> return Product(
                "Vine" + (2010..2022).random(),
                listOf(crop),
                crop.getShopPrice() + 120,
                crop.getShopPrice() * 2.45,
                1,
                "l")
        }
    }
}