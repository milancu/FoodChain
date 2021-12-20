package cz.cvut.fel.omo.foodchain.Foodchain.enums

import java.util.*

enum class CropName (val shopPrice: Double, val growthTime: Int){
    APPLE( 45.0, 23),
    BARLEY(10.0, 23),
    BEAN(10.0, 45),
    CORN(5.0, 12),
    CUCCUMBER(14.0, 48),
    CHERRIES(35.0, 21),
    FLEX(75.0, 43),
    GRAPEVINE(49.0, 23),
    HEMP(120.0, 14),
    HOP(12.0, 17),
    LENTIL(5.0, 19),
    OATS(12.0, 34),
    OILSEED(12.0, 45),
    ONION(20.0, 23),
    PEAR(69.69, 43),
    PLUMS(70.07, 12),
    POPPY(150.01, 11),
    POTATO(45.90, 10),
    RYE(12.20, 15),
    SALAD(37.23, 19),
    SUGARBEAT(35.456, 28),
    SUNFLOWER(12.5678, 19),
    TOMATO(68.45, 10),
    WHEET(8.5, 20);

    companion object {
        fun getCropName(): CropName {
            val random = Random()
            return values()[random.nextInt(values().size)]
        }
    }
}