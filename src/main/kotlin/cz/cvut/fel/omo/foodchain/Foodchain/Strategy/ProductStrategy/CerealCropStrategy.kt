package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.ProductStrategy

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.CropProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Cereal crop strategy
 *
 * @constructor Create empty Cereal crop strategy
 */
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

    /**
     * Create from grain
     *
     * @param crop
     * @return
     */
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
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
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
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
                return product
            }
        }
    }

    /**
     * Prepare for beer
     *
     * @param crop
     * @return
     */
    fun prepareForBeer(crop: Crop): Product {
        val product = CropProduct(
            "Beer",
            ProductType.ALCOHOL,
            (4..6).random().toDouble(),
            (2..4).random().toDouble(),
            (crop.getAmount() * 0.25).toInt(),
            "l",
            crop.getUUID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Create from corn
     *
     * @param crop
     * @return
     */
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
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
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
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
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
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
                return product
            }
        }
    }

    /**
     * Create from oats
     *
     * @param crop
     * @return
     */
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
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
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
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
                return product
            }
        }
    }
}