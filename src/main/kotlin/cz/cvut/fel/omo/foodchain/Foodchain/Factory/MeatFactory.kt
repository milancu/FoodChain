package cz.cvut.fel.omo.foodchain.Foodchain.Factory

import cz.cvut.fel.omo.foodchain.Foodchain.enums.FishType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class MeatFactory {

    fun packagePorkDumpling(meat: Meat): Product {
        return MeatProduct(
            "Pork Dumpling 300g",
            MeatProductType.PORKDUMPLING.toString(),
            ProductType.MEAT,
            150.0,
            180.0,
            300,
            "g",
            meat.getOriginID()
        )
    }

    fun packagePorkRoast(meat: Meat): Product {
        return MeatProduct(
            "Pork Roast 300g",
            MeatProductType.PORKROAST.toString(),
            ProductType.MEAT,
            160.0,
            170.0,
            300,
            "g",
            meat.getOriginID()
        )
    }

    fun packagePorkLeg(meat: Meat): Product {
        return MeatProduct(
            "Pork Leg 400g",
            MeatProductType.PORKLEG.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            400,
            "g",
            meat.getOriginID()
        )
    }

    fun packagePorkFlank(meat: Meat): Product {
        return MeatProduct(
            "Pork Flank 200g",
            MeatProductType.PORKFLANK.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            200,
            "g",
            meat.getOriginID()
        )
    }

    fun packageBeefTenderloin(meat: Meat): Product {
        return MeatProduct(
            "Beef TenderLoin 400g",
            MeatProductType.BEEFTENDERLOIN.toString(),
            ProductType.MEAT,
            280.0,
            330.0,
            400,
            "g",
            meat.getOriginID()
        )
    }

    fun packageBovineCheek(meat: Meat): Product {
        return MeatProduct(
            "Bovine Cheek 300g",
            MeatProductType.BOVINECHEEK.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID()
        )
    }

    fun packageBeefShoulder(meat: Meat): Product {
        return MeatProduct(
            "Beef Shoulder 300g",
            MeatProductType.BEEFSHOULDER.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID()
        )
    }

    fun packageBeefDumpling(meat: Meat): Product {
        return MeatProduct(
            "Beef Dumpling 300g",
            MeatProductType.BEEFDUMPLING.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID()
        )
    }

    fun packageChickenThigh(meat: Meat): Product {
        return MeatProduct(
            "Chicken Thigh 100g",
            MeatProductType.CHICKENTHIGH.toString(),
            ProductType.MEAT,
            90.0,
            110.0,
            100,
            "g",
            meat.getOriginID()
        )
    }

    fun packageChickenBreast(meat: Meat): Product {
        return MeatProduct(
            "Chicken Thigh 150g",
            MeatProductType.CHICKENBREAST.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g",
            meat.getOriginID()
        )
    }

    fun packageChickenWings(meat: Meat): Product {
        return MeatProduct(
            "Chicken Wings 150g",
            MeatProductType.CHICKENWINGS.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g",
            meat.getOriginID()
        )
    }

    fun packageCarp(meat: Meat): Product {
        return MeatProduct(
            "Carp 750g",
            FishType.CARP.toString(),
            ProductType.MEAT,
            420.0,
            560.0,
            750,
            "g",
            meat.getOriginID()
        )
    }

    fun packageBream(meat: Meat): Product {
        return MeatProduct(
            "Bream 750g",
            FishType.BREAM.toString(),
            ProductType.MEAT,
            400.0,
            540.0,
            750,
            "g",
            meat.getOriginID()
        )
    }

    fun packageEel(meat: Meat): Product {
        return MeatProduct(
            "Eel 800g",
            FishType.EEL.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            800,
            "g",
            meat.getOriginID()
        )
    }

    fun packageZander(meat: Meat): Product {
        return MeatProduct(
            "Zander 600g",
            FishType.ZANDER.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g",
            meat.getOriginID()
        )
    }

    fun packageCatfish(meat: Meat): Product {
        return MeatProduct(
            "Catfish 600g",
            FishType.CATFISH.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g",
            meat.getOriginID()
        )
    }

    fun packagePerch(meat: Meat): Product {
        return MeatProduct(
            "Perch 600g",
            FishType.PERCH.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g",
            meat.getOriginID()
        )
    }
}