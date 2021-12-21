package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.CropProduct
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
            1 -> return CropProduct(
                "Flour",
                ProductType.BULKINGREDIENTS,
                (15..40).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.4).toInt(),
                "kg"
            )
            else -> return CropProduct(
                "Coarse flour",
                ProductType.BULKINGREDIENTS,
                (10..30).random().toDouble(),
                (1..4).random().toDouble(),
                (crop.getAmount() * 0.4).toInt(),
                "kg"
            )
        }
    }

    // TODO product beer
    fun prepareForBeer(crop: Crop): Product {
        return CropProduct(
            crop.getName().toString(),
            ProductType.CEREALS,
            (4..6).random().toDouble(),
            (2..4).random().toDouble(),
            (crop.getAmount() * 0.25).toInt(),
            "kg"
        )
    }

    fun createFromCorn(crop: Crop): Product {
        var random: Int = (1..3).random()
        when (random) {
            1 -> return CropProduct(
                "Boiled corn",
                ProductType.VEGETABLES,
                (40..45).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.95).toInt(),
                "kg"
            )
            2 -> return CropProduct(
                "Corn can",
                ProductType.CANS,
                (30..45).random().toDouble(),
                (3..6).random().toDouble(),
                (crop.getAmount() * 0.4).toInt(),
                "kg"
            )
            else -> return CropProduct(
                "Iced corn",
                ProductType.ICED,
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
            1 -> return CropProduct(
                "Musli",
                ProductType.CEREALS,
                (15..30).random().toDouble(),
                (2..6).random().toDouble(),
                (crop.getAmount() * 0.75).toInt(),
                "kg"
            )
            else -> return CropProduct(
                "Oat flakes",
                ProductType.CEREALS,
                (20..35).random().toDouble(),
                (1..2).random().toDouble(),
                (crop.getAmount() * 0.75).toInt(),
                "kg"
            )
        }
    }
}