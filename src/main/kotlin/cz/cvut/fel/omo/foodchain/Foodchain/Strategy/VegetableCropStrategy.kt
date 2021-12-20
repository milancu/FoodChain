package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class VegetableCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop) : Product {
        when (crop.getName()) {
            CropName.POTATO -> return createFromPotato(crop)
            CropName.SALAD -> return Product(
                crop.getName().toString(),
                ProductType.VEGETABLES,
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                1,
                "kg"
            )
            CropName.CUCCUMBER -> return createFromCucumber(crop)
            CropName.TOMATO -> return createFromTomato(crop)
            CropName.ONION -> return createFromOnion(crop)
            CropName.SUGARBEAT -> return Product(
                "Suggar",
                ProductType.BULKINGREDIENTS,
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                (0.65 * crop.getAmount()).toInt(),
                "kg"
            )
            else -> throw Exception("Wrong crop name input")
        }
    }

    fun createFromTomato(crop : Crop) : Product{
        var random: Int = (1..4).random()
        when (random) {
            1 -> return Product(
                crop.getName().toString(),
                ProductType.VEGETABLES,
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                1,
                "kg"
            )
            2 -> return Product(
                "Ketchup",
                ProductType.SAUCE,
                listOf(crop),
                crop.getShopPrice() * 1.2 + 25,
                crop.getShopPrice() + 25,
                (crop.getAmount() * 0.60).toInt(),
                "l"
            )
            3 -> return Product(
                "Dried tomatoes",
                ProductType.CANS,
                listOf(crop),
                crop.getShopPrice() * 1.2 + 15,
                crop.getShopPrice() + 15,
                (crop.getAmount() * 0.85).toInt(),
                "kg"
            )
            else -> return Product(
                "Cropped tomatoes",
                ProductType.CANS,
                listOf(crop),
                crop.getShopPrice() * 1.2 + 10,
                crop.getShopPrice() + 10,
                (crop.getAmount() * 0.85).toInt(),
                "kg"
            )
        }
    }

    fun createFromCucumber(crop : Crop) : Product{
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                crop.getName().toString(),
                ProductType.VEGETABLES,
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                1,
                "kg"
            )
            else -> return Product(
                "jar of sour" + crop.getName().toString(),
                ProductType.VEGETABLES,
                listOf(crop),
                crop.getShopPrice() * 2.5,
                crop.getShopPrice() + 20,
                1,
                "kg"
            )
        }
    }

    fun createFromOnion(crop : Crop) : Product{
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                crop.getName().toString(),
                ProductType.VEGETABLES,
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                1,
                "kg"
            )
            else -> return Product(
                "Onion rings",
                ProductType.ICED,
                listOf(crop),
                crop.getShopPrice() * 2.0,
                crop.getShopPrice() + 10,
                (0.9 * crop.getAmount()).toInt(),
                "kg"
            )
        }
    }

    fun createFromPotato(crop: Crop) : Product{
        var random: Int = (1..3).random()
        when (random) {
            1 -> return Product(
                crop.getName().toString(),
                ProductType.VEGETABLES,
                listOf(crop),
                crop.getShopPrice() * 1.2,
                crop.getShopPrice(),
                1,
                "kg"
            )
            2 -> return Product(
                "Chips",
                ProductType.OTHERS,
                listOf(crop),
                crop.getShopPrice() * 2.5,
                crop.getShopPrice() + 15,
                (0.75 * crop.getAmount()).toInt(),
                "kg"
            )
            else -> return Product(
                "French fries",
                ProductType.OTHERS,
                listOf(crop),
                crop.getShopPrice() * 1.8,
                crop.getShopPrice() + 25,
                (0.65 * crop.getAmount()).toInt(),
                "kg"
            )
        }
    }

}