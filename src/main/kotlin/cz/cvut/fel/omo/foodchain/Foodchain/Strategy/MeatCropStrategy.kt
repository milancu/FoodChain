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
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "BeefShoulder",
                    MeatProductType.BEEFSHOULDER.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Bovinecheek",
                    MeatProductType.BOVINECHEEK.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Beeftenderloin",
                    MeatProductType.BEEFTENDERLOIN.toString(),
                    ProductType.MEAT,
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
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Chicken breast",
                    MeatProductType.CHICKENBREAST.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Chicken wings",
                    MeatProductType.CHICKENWINGS.toString(),
                    ProductType.MEAT,
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
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork roast",
                    MeatProductType.PORKROAST.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork leg",
                    MeatProductType.PORKLEG.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    MeatProductType.PORKFLANK.toString(),
                    ProductType.MEAT,
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
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork roast",
                    FishType.BREAM.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork leg",
                    FishType.EEL.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    FishType.ZANDER.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    FishType.CATFISH.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                MeatProduct(
                    "Pork flank",
                    FishType.PERCH.toString(),
                    ProductType.MEAT,
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