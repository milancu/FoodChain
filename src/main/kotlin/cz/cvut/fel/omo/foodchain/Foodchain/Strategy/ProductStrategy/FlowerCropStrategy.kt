package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.ProductStrategy

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.CropProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product


class FlowerCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        when (crop.getName()) {
            CropName.FLEX -> return createFromFlex(crop)
            CropName.HEMP -> return createFromHemp(crop)
            CropName.OILSEED -> return createFromOilSeed(crop)
            CropName.POPPY -> return createFromPoppy(crop)
            CropName.SUNFLOWER -> return createFromSunflower(crop)
            else -> throw Exception("Wrong crop name input " + crop.getName())
        }
    }

    fun createFromFlex(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Flex powder",
                    ProductType.BULKINGREDIENTS,
                    (40..60).random().toDouble(),
                    (2..5).random().toDouble(),
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
                    "Flex material",
                    ProductType.OTHERS,
                    (250..600).random().toDouble(),
                    (40..60).random().toDouble(),
                    (crop.getAmount() * 0.15).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
        }
    }

    fun createFromSunflower(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Sunflower seeds",
                    ProductType.OTHERS,
                    (30..60).random().toDouble(),
                    (5..10).random().toDouble(),
                    (crop.getAmount() * 0.15).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            else -> {
                val product = CropProduct(
                    "Sunflower oil",
                    ProductType.OIL,
                    (40..75).random().toDouble(),
                    (15..20).random().toDouble(),
                    (crop.getAmount() * 0.15).toInt(),
                    "l",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
        }
    }

    fun createFromPoppy(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Milled poppy",
                    ProductType.BULKINGREDIENTS,
                    (40..60).random().toDouble(),
                    (2..5).random().toDouble(),
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
                    "Opium",
                    ProductType.XXX,
                    (250..600).random().toDouble(),
                    (40..60).random().toDouble(),
                    (crop.getAmount() * 0.15).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
        }
    }

    fun createFromHemp(crop: Crop): Product {
        var random: Int = (1..6).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Hemp Tea",
                    ProductType.DRINK,
                    (150..250).random().toDouble(),
                    (2..5).random().toDouble(),
                    (crop.getAmount() * 0.2).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            2 -> {
                val product = CropProduct(
                    "Hemp ointment",
                    ProductType.OTHERS,
                    (400..1500).random().toDouble(),
                    (100..350).random().toDouble(),
                    (crop.getAmount() * 0.8).toInt(),
                    "l",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            3 -> {
                val product = CropProduct(
                    "Hemp protein",
                    ProductType.OTHERS,
                    (80..200).random().toDouble(),
                    (40..65).random().toDouble(),
                    (crop.getAmount() * 0.2).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            4 -> {
                val product = CropProduct(
                    "Hemp cookies",
                    ProductType.OTHERS,
                    (800..1500).random().toDouble(),
                    (300..600).random().toDouble(),
                    (crop.getAmount() * 0.1).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            5 -> {
                val product = CropProduct(
                    "Hemp oil",
                    ProductType.OIL,
                    (60..140).random().toDouble(),
                    (20..40).random().toDouble(),
                    (crop.getAmount() * 0.1).toInt(),
                    "l",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
            else -> {
                val product = CropProduct(
                    "Weed",
                    ProductType.XXX,
                    (600..1200).random().toDouble(),
                    (250..450).random().toDouble(),
                    (crop.getAmount() * 0.1).toInt(),
                    "kg",
                    crop.getOriginID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                return product
            }
        }
    }

    fun createFromOilSeed(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    "Oilseed oil",
                    ProductType.OIL,
                    (40..60).random().toDouble(),
                    (2..5).random().toDouble(),
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
                    "Biofuel",
                    ProductType.OTHERS,
                    (250..600).random().toDouble(),
                    (40..60).random().toDouble(),
                    (crop.getAmount() * 0.15).toInt(),
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