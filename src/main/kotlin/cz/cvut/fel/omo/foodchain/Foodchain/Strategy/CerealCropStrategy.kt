package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class CerealCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        when (crop.getName()) {
            CropName.BARLEY -> return prepareForBeer(crop)
            CropName.CORN -> return createFromCorn(crop)
            CropName.OATS -> return createFromOats(crop)
            CropName.RYE -> return createFromGrain(crop)
            CropName.WHEET -> return createFromGrain(crop)
            CropName.HOP -> return prepareForBeer(crop)
            else -> throw Exception("Wrong crop name input")
        }
    }

    fun createFromGrain(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                "Flour",
                ProductType.BULKINGREDIENTS,
                listOf(crop),
                (15..40).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.4).toInt(),
                "kg"
            )
            else -> return Product(
                "Coarse flour",
                ProductType.BULKINGREDIENTS,
                listOf(crop),
                (10..30).random().toDouble(),
                (1..4).random().toDouble(),
                (crop.getAmount() * 0.4).toInt(),
                "kg"
            )
        }
    }

    // TODO product beer
    fun prepareForBeer(crop: Crop): Product {
        return Product(
            crop.getName().toString(),
            ProductType.CEREALS,
            listOf(crop),
            (4..6).random().toDouble(),
            (2..4).random().toDouble(),
            (crop.getAmount() * 0.25).toInt(),
            "kg"
        )
    }

    fun createFromCorn(crop: Crop): Product {
        var random: Int = (1..3).random()
        when (random) {
            1 -> return Product(
                "Boiled corn",
                ProductType.VEGETABLES,
                listOf(crop),
                (40..45).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.95).toInt(),
                "kg"
            )
            2 -> return Product(
                "Corn can",
                ProductType.CANS,
                listOf(crop),
                (30..45).random().toDouble(),
                (3..6).random().toDouble(),
                (crop.getAmount() * 0.4).toInt(),
                "kg"
            )
            else -> return Product(
                "Iced corn",
                ProductType.ICED,
                listOf(crop),
                (30..35).random().toDouble(),
                (1..2).random().toDouble(),
                (crop.getAmount() * 0.4).toInt(),
                "kg"
            )
        }
    }

    fun createFromOats(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                "Musli",
                ProductType.CEREALS,
                listOf(crop),
                (15..30).random().toDouble(),
                (2..6).random().toDouble(),
                (crop.getAmount() * 0.75).toInt(),
                "kg"
            )
            else -> return Product(
                "Oat flakes",
                ProductType.CEREALS,
                listOf(crop),
                (20..35).random().toDouble(),
                (1..2).random().toDouble(),
                (crop.getAmount() * 0.75).toInt(),
                "kg"
            )
        }
    }
}