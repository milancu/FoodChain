package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.ProductStrategy

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.FishType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product
import kotlin.collections.ArrayList

class MeatStrategy : ProcessorMeatStrategy {

    override fun execute(meat: Meat): ArrayList<Product> {
        when (meat.getType()) {
            MeatType.BEEF -> {
                return executeBeef(meat)
            }
            MeatType.FISH -> {
                return executeFish(meat)
            }
            MeatType.CHICKEN -> {
                return executeChicken(meat)
            }
            MeatType.PORK -> {
                return executePork(meat)
            }
        }
    }

    fun executeBeef(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        var Dumpling = MeatProduct(
            "Dumpling",
            MeatProductType.BEEFDUMPLING.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var BeefShoulder = MeatProduct(
            "BeefShoulder",
            MeatProductType.BEEFSHOULDER.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var Bovinecheek = MeatProduct(
            "Bovinecheek",
            MeatProductType.BOVINECHEEK.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )
        var Beeftenderloin = MeatProduct(
            "Beeftenderloin",
            MeatProductType.BEEFTENDERLOIN.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 18).toInt(),
            "kg",
            meat.getOriginID()
        )
        Dumpling.attach(Report)
        BeefShoulder.attach(Report)
        Bovinecheek.attach(Report)
        Beeftenderloin.attach(Report)
        Dumpling.notifyUpdate()
        BeefShoulder.notifyUpdate()
        Bovinecheek.notifyUpdate()
        Beeftenderloin.notifyUpdate()

        meats.addAll(
            listOf(
                Dumpling, BeefShoulder, Bovinecheek, Beeftenderloin
            )
        )
        return meats;
    }

    fun executeChicken(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        var ChickenThigh = MeatProduct(
            "Chicken thigh",
            MeatProductType.CHICKENTHIGH.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var ChickenBreast = MeatProduct(
            "Chicken breast",
            MeatProductType.CHICKENBREAST.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var ChickenWings = MeatProduct(
            "Chicken wings",
            MeatProductType.CHICKENWINGS.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )

        ChickenThigh.attach(Report)
        ChickenBreast.attach(Report)
        ChickenWings.attach(Report)

        ChickenThigh.notifyUpdate()
        ChickenBreast.notifyUpdate()
        ChickenWings.notifyUpdate()

        meats.addAll(
            listOf(
                ChickenThigh, ChickenBreast, ChickenWings
            )
        )
        return meats;
    }

    fun executePork(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        var PorkDumpling = MeatProduct(
            "Pork dumpling",
            MeatProductType.PORKDUMPLING.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var PorkRoast = MeatProduct(
            "Pork roast",
            MeatProductType.PORKROAST.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var PorkLeg = MeatProduct(
            "Pork leg",
            MeatProductType.PORKLEG.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )
        var PorkFlank = MeatProduct(
            "Pork flank",
            MeatProductType.PORKFLANK.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )

        PorkDumpling.attach(Report)
        PorkRoast.attach(Report)
        PorkLeg.attach(Report)
        PorkFlank.attach(Report)

        PorkDumpling.notifyUpdate()
        PorkRoast.notifyUpdate()
        PorkLeg.notifyUpdate()
        PorkFlank.notifyUpdate()

        meats.addAll(
            listOf(
                PorkDumpling, PorkRoast, PorkLeg, PorkFlank
            )
        )
        return meats;
    }

    fun executeFish(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        var carp = MeatProduct(
            "CARP",
            FishType.CARP.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var bream = MeatProduct(
            "BREAM",
            FishType.BREAM.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID()
        )
        var eel = MeatProduct(
            "EEL",
            FishType.EEL.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )
        var zander = MeatProduct(
            "ZANDER",
            FishType.ZANDER.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )
        var catfish = MeatProduct(
            "CATFISH",
            FishType.CATFISH.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )
        var perch = MeatProduct(
            "PERCH",
            FishType.PERCH.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID()
        )

        carp.attach(Report)
        bream.attach(Report)
        eel.attach(Report)
        zander.attach(Report)
        catfish.attach(Report)
        perch.attach(Report)

        carp.notifyUpdate()
        bream.notifyUpdate()
        eel.notifyUpdate()
        zander.notifyUpdate()
        catfish.notifyUpdate()
        perch.notifyUpdate()

        meats.addAll(
            listOf(
                carp, bream, eel, zander, catfish, perch
            )
        )
        return meats;
    }


}