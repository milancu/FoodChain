package cz.cvut.fel.omo.foodchain.Foodchain.strategies.product_strategy

import cz.cvut.fel.omo.foodchain.Foodchain.observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.FishType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product
import kotlin.collections.ArrayList

/**
 * Meat strategy
 *
 * @constructor Create empty Meat strategy
 */
class MeatStrategy : ProcessorMeatStrategy {

    override fun execute(meat: Meat): ArrayList<MeatProduct> {
        return when (meat.getType()) {
            MeatType.BEEF -> {
                executeBeef(meat)
            }
            MeatType.FISH -> {
                executeFish(meat)
            }
            MeatType.CHICKEN -> {
                executeChicken(meat)
            }
            MeatType.PORK -> {
                executePork(meat)
            }
        }
    }

    /**
     * Execute beef
     *
     * @param meat
     * @return
     */
    private fun executeBeef(meat: Meat): ArrayList<MeatProduct> {
        val meats = ArrayList<MeatProduct>()
        val dumpling = MeatProduct(
            "Dumpling",
            MeatProductType.BEEFDUMPLING.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val beefShoulder = MeatProduct(
            "BeefShoulder",
            MeatProductType.BEEFSHOULDER.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val bovinecheek = MeatProduct(
            "Bovinecheek",
            MeatProductType.BOVINECHEEK.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val beeftenderloin = MeatProduct(
            "Beeftenderloin",
            MeatProductType.BEEFTENDERLOIN.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 18).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        dumpling.attach(Report)
        beefShoulder.attach(Report)
        bovinecheek.attach(Report)
        beeftenderloin.attach(Report)
        dumpling.notifyUpdate()
        beefShoulder.notifyUpdate()
        bovinecheek.notifyUpdate()
        beeftenderloin.notifyUpdate()

        meats.addAll(
            listOf(
                dumpling, beefShoulder, bovinecheek, beeftenderloin
            )
        )
        return meats
    }

    /**
     * Execute chicken
     *
     * @param meat
     * @return
     */
    private fun executeChicken(meat: Meat): ArrayList<MeatProduct> {
        val meats = ArrayList<MeatProduct>()
        val chickenThigh = MeatProduct(
            "Chicken thigh",
            MeatProductType.CHICKENTHIGH.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val chickenBreast = MeatProduct(
            "Chicken breast",
            MeatProductType.CHICKENBREAST.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val chickenWings = MeatProduct(
            "Chicken wings",
            MeatProductType.CHICKENWINGS.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )

        chickenThigh.attach(Report)
        chickenBreast.attach(Report)
        chickenWings.attach(Report)

        chickenThigh.notifyUpdate()
        chickenBreast.notifyUpdate()
        chickenWings.notifyUpdate()

        meats.addAll(
            listOf(
                chickenThigh, chickenBreast, chickenWings
            )
        )
        return meats
    }

    /**
     * Execute pork
     *
     * @param meat
     * @return
     */
    private fun executePork(meat: Meat): ArrayList<MeatProduct> {
        val meats = ArrayList<MeatProduct>()
        val porkDumpling = MeatProduct(
            "Pork dumpling",
            MeatProductType.PORKDUMPLING.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val porkRoast = MeatProduct(
            "Pork roast",
            MeatProductType.PORKROAST.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 8).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val porkLeg = MeatProduct(
            "Pork leg",
            MeatProductType.PORKLEG.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        val porkFlank = MeatProduct(
            "Pork flank",
            MeatProductType.PORKFLANK.toString(),
            ProductType.MEAT,
            meat.getShopPrice() / 4,
            (meat.getShopPrice() / 4) * 1.4,
            (meat.getAmount() / 16).toInt(),
            "kg",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )

        porkDumpling.attach(Report)
        porkRoast.attach(Report)
        porkLeg.attach(Report)
        porkFlank.attach(Report)

        porkDumpling.notifyUpdate()
        porkRoast.notifyUpdate()
        porkLeg.notifyUpdate()
        porkFlank.notifyUpdate()

        meats.addAll(
            listOf(
                porkDumpling, porkRoast, porkLeg, porkFlank
            )
        )
        return meats
    }

    /**
     * Execute fish
     *
     * @param meat
     * @return
     */
    private fun executeFish(meat: Meat): ArrayList<MeatProduct> {
        val meats = ArrayList<MeatProduct>()
        when ((1..6).random()) {
            1 -> {
                val carp = MeatProduct(
                    "CARP",
                    FishType.CARP.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg",
                    meat.getOriginID(),
                    meat.getState().changeToNextState()
                )
                carp.attach(Report)
                carp.notifyUpdate()
                meats.add(carp)
            }
            2 -> {
                val bream = MeatProduct(
                    "BREAM",
                    FishType.BREAM.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 8).toInt(),
                    "kg",
                    meat.getOriginID(),
                    meat.getState().changeToNextState()
                )
                bream.attach(Report)
                bream.notifyUpdate()
                meats.add(bream)

            }
            3 -> {
                val eel = MeatProduct(
                    "EEL",
                    FishType.EEL.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg",
                    meat.getOriginID(),
                    meat.getState().changeToNextState()
                )
                eel.attach(Report)
                eel.notifyUpdate()
                meats.add(eel)

            }
            4 -> {
                val zander = MeatProduct(
                    "ZANDER",
                    FishType.ZANDER.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg",
                    meat.getOriginID(),
                    meat.getState().changeToNextState()
                )
                zander.attach(Report)
                zander.notifyUpdate()
                meats.add(zander)

            }
            5 -> {
                val catfish = MeatProduct(
                    "CATFISH",
                    FishType.CATFISH.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg",
                    meat.getOriginID(),
                    meat.getState().changeToNextState()
                )
                catfish.attach(Report)
                catfish.notifyUpdate()
                meats.add(catfish)

            }
            6 -> {
                val perch = MeatProduct(
                    "PERCH",
                    FishType.PERCH.toString(),
                    ProductType.MEAT,
                    meat.getShopPrice() / 4,
                    (meat.getShopPrice() / 4) * 1.4,
                    (meat.getAmount() / 16).toInt(),
                    "kg",
                    meat.getOriginID(),
                    meat.getState().changeToNextState()
                )
                perch.attach(Report)
                perch.notifyUpdate()
                meats.add(perch)
            }
        }
        return meats
    }
}