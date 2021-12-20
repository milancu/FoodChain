package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class LegumesStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                "Raw" + crop.getName().toString(),
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                1,
                "kg"
            )
            else -> return Product(
                "Can of " + crop.getName().toString(),
                listOf(crop),
                crop.getShopPrice() * 1.4,
                crop.getShopPrice() + 5,
                1,
                "kg"
            )
        }
    }
}