package cz.cvut.fel.omo.foodchain.Foodchain.enums

import java.util.*

/**
 * Crop type
 *
 * @constructor Create empty Crop type
 */
enum class CropType {
    CEREAL, FRUIT, VEGETABLE, LEGUMES, FLOWER;

    companion object {
        fun getCropType(): CropType {
            val random = Random()
            return CropType.values()[random.nextInt(CropType.values().size)]
        }
    }
}