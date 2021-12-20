package cz.cvut.fel.omo.foodchain.Foodchain.enums

import java.util.*

enum class MeatName (val shopPrice: Double){
    HAM(100.0),
    WINGS(70.0),
    THIGHS(80.0),
    SALAM(150.0),
    SAUSAGE(90.0),
    BREAST(69.69),
    FISH(180.0);

    companion object {
        fun getMeatName(): MeatName {
            val random = Random()
            return MeatName.values()[random.nextInt(MeatName.values().size)]
        }
    }
}