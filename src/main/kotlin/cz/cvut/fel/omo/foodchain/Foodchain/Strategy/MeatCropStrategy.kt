package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
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
                Product(
                    "Dumpling",
                    ProductType.BEEFDUMPLING,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                Product(
                    "BeefShoulder",
                    ProductType.BEEFSHOULDER,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                Product(
                    "Bovinecheek",
                    ProductType.BOVINECHEEK,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                Product(
                    "Beeftenderloin",
                    ProductType.BEEFTENDERLOIN,
                    TODO(),
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
                Product(
                    "Chicken thigh",
                    ProductType.CHICKENTHIGH,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                Product(
                    "Chicken breast",
                    ProductType.CHICKENBREAST,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                Product(
                    "Chicken wings",
                    ProductType.CHICKENWINGS,
                    TODO(),
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
                Product(
                    "Pork dumpling",
                    ProductType.PORKDUMPLING,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                Product(
                    "Pork roast",
                    ProductType.PORKROAST,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg"
                ),
                Product(
                    "Pork leg",
                    ProductType.PORKLEG,
                    TODO(),
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg"
                ),
                Product(
                    "Pork flank",
                    ProductType.PORKFLANK,
                    TODO(),
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
        return TODO();
    }


}