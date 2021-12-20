package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product


class FlowerStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        when (crop.getName()) {
            CropName.FLEX -> return TODO()
            CropName.HEMP -> return TODO()
            CropName.OILSEED -> return TODO()
            CropName.POPPY -> return TODO()
            CropName.SUNFLOWER -> return TODO()
            else -> throw Exception("Wrong crop name input")
        }
    }

    fun createFromFlex(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                "Flex powder",
                listOf(crop),
                (40..60).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.75).toInt(),
                "kg"
            )
            else -> return Product(
                "Flex material",
                listOf(crop),
                (250..600).random().toDouble(),
                (40..60).random().toDouble(),
                (crop.getAmount() * 0.15).toInt(),
                "kg"
            )
        }
    }

    fun createFromSunflower(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                "Sunflower seeds",
                listOf(crop),
                (30..60).random().toDouble(),
                (5..10).random().toDouble(),
                (crop.getAmount() * 0.15).toInt(),
                "kg"
            )
            else -> return Product(
                "Sunflower oil",
                listOf(crop),
                (40..75).random().toDouble(),
                (15..20).random().toDouble(),
                (crop.getAmount() * 0.15).toInt(),
                "l"
            )
        }
    }

    fun createFromPoppy(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                "Milled poppy",
                listOf(crop),
                (40..60).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.75).toInt(),
                "kg"
            )
            else -> return Product(
                "Opium",
                listOf(crop),
                (250..600).random().toDouble(),
                (40..60).random().toDouble(),
                (crop.getAmount() * 0.15).toInt(),
                "kg"
            )
        }
    }

    fun createFromHemp(crop: Crop): Product {
        var random: Int = (1..6).random()
        when (random) {
            1 -> return Product(
                "Hemp Tea",
                listOf(crop),
                (150..250).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.2).toInt(),
                "kg"
            )
            2 -> return Product(
                "Hemp ointment",
                listOf(crop),
                (400..1500).random().toDouble(),
                (100..350).random().toDouble(),
                (crop.getAmount() * 0.8).toInt(),
                "l"
            )
            3 -> return Product(
                "Hemp protein",
                listOf(crop),
                (80..200).random().toDouble(),
                (40..65).random().toDouble(),
                (crop.getAmount() * 0.2).toInt(),
                "kg"
            )
            4 -> return Product(
                "Hemp cookies",
                listOf(crop),
                (800..1500).random().toDouble(),
                (300..600).random().toDouble(),
                (crop.getAmount() * 0.1).toInt(),
                "kg"
            )
            5 -> return Product(
                "Hemp oil",
                listOf(crop),
                (60..140).random().toDouble(),
                (20..40).random().toDouble(),
                (crop.getAmount() * 0.1).toInt(),
                "l"
            )
            else -> return Product(
                "Weed",
                listOf(crop),
                (600..1200).random().toDouble(),
                (250..450).random().toDouble(),
                (crop.getAmount() * 0.1).toInt(),
                "kg"
            )
        }
    }

    fun createFromOilSeed(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> return Product(
                "Oilseed oil",
                listOf(crop),
                (40..60).random().toDouble(),
                (2..5).random().toDouble(),
                (crop.getAmount() * 0.75).toInt(),
                "kg"
            )
            else -> return Product(
                "Biofuel",
                listOf(crop),
                (250..600).random().toDouble(),
                (40..60).random().toDouble(),
                (crop.getAmount() * 0.15).toInt(),
                "kg"
            )
        }
    }


}