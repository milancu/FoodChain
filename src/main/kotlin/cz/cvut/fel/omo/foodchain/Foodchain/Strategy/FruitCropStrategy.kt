package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.CropProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class FruitCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        if (crop.getName() == CropName.GRAPEVINE) {
            return createFromVine(crop);
        }
        val random: Int = (1..4).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    crop.getName().toString(),
                    ProductType.FRUIT,
                    crop.getShopPrice() * 1.4,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                return product

            }
            2 -> {
                val product = CropProduct(
                    crop.getName().toString() + "jam",
                    ProductType.SAUCE,
                    crop.getShopPrice() + 50,
                    crop.getShopPrice(),
                    (crop.getAmount() * 0.85).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                return product
            }
            3 -> {
                val product = CropProduct(
                    crop.getName().toString() + "juice",
                    ProductType.DRINK,
                    crop.getShopPrice() + 50,
                    crop.getShopPrice(),
                    (crop.getAmount() * 0.85).toInt(),
                    "l",
                    crop.getOriginID()
                )
                product.attach(Report)
                return product
            }
            else -> {
                val product = CropProduct(
                    crop.getName().toString() + "compote",
                    ProductType.CANS,
                    (crop.getShopPrice() + 40),
                    crop.getShopPrice(),
                    (crop.getAmount() * 0.85).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                return product
            }
        }
    }

    fun createFromVine(crop: Crop): Product {
        val random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    crop.getName().toString(),
                    ProductType.FRUIT,
                    crop.getShopPrice() * 1.4,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                return product
            }
            else -> {
                val product = CropProduct(
                    "Vine" + (2010..2022).random(),
                    ProductType.ALCOHOL,
                    crop.getShopPrice() + 120,
                    crop.getShopPrice() * 2.45,
                    1,
                    "l",
                    crop.getOriginID()
                )
                product.attach(Report)
                return product
            }
        }
    }
}