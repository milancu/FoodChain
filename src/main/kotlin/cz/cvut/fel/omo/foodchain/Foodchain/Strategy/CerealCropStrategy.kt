package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
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
        val random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Flour",
                    ProductType.BULKINGREDIENTS,
                    (15..40).random().toDouble(),
                    (2..5).random().toDouble(),
                    (crop.getAmount() * 0.4).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            else -> {
                val product = CropProduct(
                    "Coarse flour",
                    ProductType.BULKINGREDIENTS,
                    (10..30).random().toDouble(),
                    (1..4).random().toDouble(),
                    (crop.getAmount() * 0.4).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
        }
    }

    // TODO product beer
    fun prepareForBeer(crop: Crop): Product {
        val product = CropProduct(
            crop.getName().toString(),
            ProductType.CEREALS,
            (4..6).random().toDouble(),
            (2..4).random().toDouble(),
            (crop.getAmount() * 0.25).toInt(),
            "kg",
            crop.getOriginID()
        )
        product.attach(Report)
        crop.notifyCropWasExecuted()
        return product
    }

    fun createFromCorn(crop: Crop): Product {
        val random: Int = (1..3).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Boiled corn",
                    ProductType.VEGETABLES,
                    (40..45).random().toDouble(),
                    (2..5).random().toDouble(),
                    (crop.getAmount() * 0.95).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            2 -> {
                val product = CropProduct(
                    "Corn can",
                    ProductType.CANS,
                    (30..45).random().toDouble(),
                    (3..6).random().toDouble(),
                    (crop.getAmount() * 0.4).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            else -> {
                val product = CropProduct(
                    "Iced corn",
                    ProductType.ICED,
                    (30..35).random().toDouble(),
                    (1..2).random().toDouble(),
                    (crop.getAmount() * 0.4).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
        }
    }

    fun createFromOats(crop: Crop): Product {
        val random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Musli",
                    ProductType.CEREALS,
                    (15..30).random().toDouble(),
                    (2..6).random().toDouble(),
                    (crop.getAmount() * 0.75).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            else -> {
                val product = CropProduct(
                    "Oat flakes",
                    ProductType.CEREALS,
                    (20..35).random().toDouble(),
                    (1..2).random().toDouble(),
                    (crop.getAmount() * 0.75).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
        }
    }
}