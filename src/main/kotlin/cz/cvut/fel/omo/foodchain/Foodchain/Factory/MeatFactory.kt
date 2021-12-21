package cz.cvut.fel.omo.foodchain.Foodchain.Factory

import cz.cvut.fel.omo.foodchain.Foodchain.enums.FishType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class MeatFactory {

    fun packagePorkDumpling(): Product {
        return MeatProduct(
            "Pork Dumpling 300g",
            MeatProductType.PORKDUMPLING.toString(),
            ProductType.MEAT,
            150.0,
            180.0,
            300,
            "g"
        )
    }

    fun packagePorkRoast(): Product {
        return MeatProduct(
            "Pork Roast 300g",
            MeatProductType.PORKROAST.toString(),
            ProductType.MEAT,
            160.0,
            170.0,
            300,
            "g"
        )
    }

    fun packagePorkLeg(): Product {
        return MeatProduct(
            "Pork Leg 400g",
            MeatProductType.PORKLEG.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            400,
            "g"
        )
    }

    fun packagePorkFlank(): Product {
        return MeatProduct(
            "Pork Flank 200g",
            MeatProductType.PORKFLANK.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            200,
            "g"
        )
    }

    fun packageBeefTenderloin(): Product {
        return MeatProduct(
            "Beef TenderLoin 400g",
            MeatProductType.BEEFTENDERLOIN.toString(),
            ProductType.MEAT,
            280.0,
            330.0,
            400,
            "g"
        )
    }

    fun packageBovineCheek(): Product {
        return MeatProduct(
            "Bovine Cheek 300g",
            MeatProductType.BOVINECHEEK.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g"
        )
    }

    fun packageBeefShoulder(): Product {
        return MeatProduct(
            "Beef Shoulder 300g",
            MeatProductType.BEEFSHOULDER.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g"
        )
    }

    fun packageBeefDumpling(): Product {
        return MeatProduct(
            "Beef Dumpling 300g",
            MeatProductType.BEEFDUMPLING.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g"
        )
    }

    fun packageChickenThigh(): Product {
        return MeatProduct(
            "Chicken Thigh 100g",
            MeatProductType.CHICKENTHIGH.toString(),
            ProductType.MEAT,
            90.0,
            110.0,
            100,
            "g"
        )
    }

    fun packageChickenBreast(): Product {
        return MeatProduct(
            "Chicken Thigh 150g",
            MeatProductType.CHICKENBREAST.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g"
        )
    }

    fun packageChickenWings(): Product {
        return MeatProduct(
            "Chicken Wings 150g",
            MeatProductType.CHICKENWINGS.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g"
        )
    }

    fun packageCarp(): Product {
        return MeatProduct(
            "Carp 750g",
            FishType.CARP.toString(),
            ProductType.MEAT,
            420.0,
            560.0,
            750,
            "g"
        )
    }

    fun packageBream(): Product {
        return MeatProduct(
            "Bream 750g",
            FishType.BREAM.toString(),
            ProductType.MEAT,
            400.0,
            540.0,
            750,
            "g"
        )
    }

    fun packageEel(): Product {
        return MeatProduct(
            "Eel 800g",
            FishType.EEL.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            800,
            "g"
        )
    }

    fun packageZander(): Product {
        return MeatProduct(
            "Zander 600g",
            FishType.ZANDER.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g"
        )
    }

    fun packageCatfish(): Product {
        return MeatProduct(
            "Catfish 600g",
            FishType.CATFISH.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g"
        )
    }

    fun packagePerch(): Product {
        return MeatProduct(
            "Perch 600g",
            FishType.PERCH.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g"
        )
    }
}