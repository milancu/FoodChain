package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.FishType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class MeatCropStrategy : ProcessorMeatStrategy {
    override fun execute(meat: Meat): ArrayList<Product> {
        when (meat.getType()) {
            MeatType.BEEF -> return executeBeef(meat)
            MeatType.FISH -> return executeFish(meat)
            MeatType.CHICKEN -> return executeChicken(meat)
            MeatType.PORK -> return executePork(meat)
        }
    }

    fun executeBeef(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        meats.addAll(
            listOf(
                MeatProduct(
                    "Dumpling",
                    MeatProductType.BEEFDUMPLING.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "BeefShoulder",
                    MeatProductType.BEEFSHOULDER.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Bovinecheek",
                    MeatProductType.BOVINECHEEK.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Beeftenderloin",
                    MeatProductType.BEEFTENDERLOIN.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 18).toInt(),
                    "k=g"
                )
            )
        )
        return meats;
    }

    fun executeChicken(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        meats.addAll(
            listOf(
                MeatProduct(
                    "Chicken thigh",
                    MeatProductType.CHICKENTHIGH.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Chicken breast",
                    MeatProductType.CHICKENBREAST.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Chicken wings",
                    MeatProductType.CHICKENWINGS.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                )
            )
        )
        return meats;
    }

    fun executePork(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        meats.addAll(
            listOf(
                MeatProduct(
                    "Pork dumpling",
                    MeatProductType.PORKDUMPLING.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork roast",
                    MeatProductType.PORKROAST.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork leg",
                    MeatProductType.PORKLEG.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    MeatProductType.PORKFLANK.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                )
            )
        )
        return meats;
    }

    fun executeFish(meat: Meat): ArrayList<Product> {
        var meats = ArrayList<Product>()
        meats.addAll(
            listOf(
                MeatProduct(
                    "Pork dumpling",
                    FishType.CARP.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork roast",
                    FishType.BREAM.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork leg",
                    FishType.EEL.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    FishType.ZANDER.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    FishType.CATFISH.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    FishType.PERCH.toString(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                )
            )
        )
        return meats;
    }


}