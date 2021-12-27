package cz.cvut.fel.omo.foodchain.Foodchain.Factory

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.FishType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.BaseParty
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Transport
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Meat factory
 *
 * @constructor
 *
 * @param subjectName
 * @param location
 * @param amountOfMoney
 */
class MeatFactory(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    private var meatsForProducts: ArrayList<Meat> = ArrayList()
    private var productToSell: ArrayList<Product> = ArrayList()
    private val unpaidInvoices: ArrayList<Invoice> = ArrayList()

    /**
     * Get meat resources
     *
     * @return
     */
    fun getMeatResources(): Int {
        return meatsForProducts.size
    }

    /**
     * Get prepared porducts
     *
     * @return
     */
    fun getPreparedPorducts(): Int {
        return productToSell.size
    }

    /**
     * Take meat
     *
     * @param newMeats
     */
    fun takeMeat(newMeats: ArrayList<Meat>) {
        for (meat in newMeats) {
            meatsForProducts.add(meat)
        }
        println("Prevzato masa k zabaleni: " + meatsForProducts.size)
    }

    /**
     * Transport products
     *
     */
    fun transportProducts() {
        Transport.takeProducts(productToSell)
        productToSell = ArrayList()
    }

    /**
     * Pay for invoice
     *
     * @param invoice
     */
    fun payForInvoice(invoice: Invoice) {
        if (amountOfMoney >= invoice.getPrice()) {
            invoice.payInvoice()
            invoice.getContractor().takeMoney(invoice.getPrice())
            amountOfMoney -= invoice.getPrice()
            invoice.notifyPaid()
            println("Faktura " + invoice.getCode() + " zaplacena")
        } else {
            unpaidInvoices.add(invoice)
            invoice.notifyUnpaid()
            println("!Faktura " + invoice.getCode() + " NENI uhrazena")
        }
    }

    /**
     * Pay debts
     *
     */
    fun payDebts() {
        val toRemove: ArrayList<Invoice> = ArrayList()
        for (invoice in unpaidInvoices) {
            if (amountOfMoney >= invoice.getPrice()) {
                payForInvoice(invoice)
                toRemove.add(invoice)
            }
        }
        for (invoice in toRemove) {
            println("Penize za " + invoice.getCode() + " splaceny")
            unpaidInvoices.remove(invoice)
        }
    }

    /**
     * Package product
     *
     */
    fun packageProduct() {
        for (meat in meatsForProducts) {
            println("Maso puvodu : " + meat.getOriginID() + " je baleno")
            when (meat.getType()) {
                MeatType.PORK -> {
                    productToSell.add(packagePorkDumpling(meat))
                    productToSell.add(packagePorkRoast(meat))
                    productToSell.add(packagePorkFlank(meat))
                    for (i in 1..4) {
                        productToSell.add(packagePorkLeg(meat))
                    }
                }
                MeatType.BEEF -> {
                    productToSell.add(packageBeefTenderloin(meat))
                    productToSell.add(packageBovineCheek(meat))
                    productToSell.add(packageBeefShoulder(meat))
                    productToSell.add(packageBeefDumpling(meat))

                }
                MeatType.CHICKEN -> {
                    productToSell.add(packageChickenBreast(meat))
                    for (i in 1..2) {
                        productToSell.add(packageChickenThigh(meat))
                        productToSell.add(packageChickenWings(meat))
                    }
                }
                MeatType.FISH -> {
                    when ((1..6).random()) {
                        1 -> productToSell.add(packageCarp(meat))
                        2 -> productToSell.add(packageBream(meat))
                        3 -> productToSell.add(packageEel(meat))
                        4 -> productToSell.add(packageZander(meat))
                        5 -> productToSell.add(packageCatfish(meat))
                        6 -> productToSell.add(packagePerch(meat))
                    }
                }
            }
        }
        meatsForProducts = ArrayList()
    }

    /**
     * Package pork dumpling
     *
     * @param meat
     * @return
     */
    private fun packagePorkDumpling(meat: Meat): Product {
        val product = MeatProduct(
            "Pork Dumpling 300g",
            MeatProductType.PORKDUMPLING.toString(),
            ProductType.MEAT,
            150.0,
            180.0,
            300,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package pork roast
     *
     * @param meat
     * @return
     */
    private fun packagePorkRoast(meat: Meat): Product {
        val product = MeatProduct(
            "Pork Roast 300g",
            MeatProductType.PORKROAST.toString(),
            ProductType.MEAT,
            160.0,
            170.0,
            300,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package pork leg
     *
     * @param meat
     * @return
     */
    private fun packagePorkLeg(meat: Meat): Product {
        val product = MeatProduct(
            "Pork Leg 400g",
            MeatProductType.PORKLEG.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            400,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package pork flank
     *
     * @param meat
     * @return
     */
    private fun packagePorkFlank(meat: Meat): Product {
        val product = MeatProduct(
            "Pork Flank 200g",
            MeatProductType.PORKFLANK.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            200,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package beef tenderloin
     *
     * @param meat
     * @return
     */
    private fun packageBeefTenderloin(meat: Meat): Product {
        val product = MeatProduct(
            "Beef TenderLoin 400g",
            MeatProductType.BEEFTENDERLOIN.toString(),
            ProductType.MEAT,
            280.0,
            330.0,
            400,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package bovine cheek
     *
     * @param meat
     * @return
     */
    private fun packageBovineCheek(meat: Meat): Product {
        val product = MeatProduct(
            "Bovine Cheek 300g",
            MeatProductType.BOVINECHEEK.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package beef shoulder
     *
     * @param meat
     * @return
     */
    private fun packageBeefShoulder(meat: Meat): Product {
        val product = MeatProduct(
            "Beef Shoulder 300g",
            MeatProductType.BEEFSHOULDER.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package beef dumpling
     *
     * @param meat
     * @return
     */
    private fun packageBeefDumpling(meat: Meat): Product {
        val product = MeatProduct(
            "Beef Dumpling 300g",
            MeatProductType.BEEFDUMPLING.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package chicken thigh
     *
     * @param meat
     * @return
     */
    private fun packageChickenThigh(meat: Meat): Product {
        val product = MeatProduct(
            "Chicken Thigh 100g",
            MeatProductType.CHICKENTHIGH.toString(),
            ProductType.MEAT,
            90.0,
            110.0,
            100,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package chicken breast
     *
     * @param meat
     * @return
     */
    private fun packageChickenBreast(meat: Meat): Product {
        val product = MeatProduct(
            "Chicken Breast 150g",
            MeatProductType.CHICKENBREAST.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package chicken wings
     *
     * @param meat
     * @return
     */
    private fun packageChickenWings(meat: Meat): Product {
        val product = MeatProduct(
            "Chicken Wings 150g",
            MeatProductType.CHICKENWINGS.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g",
            meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package carp
     *
     * @param meat
     * @return
     */
    private fun packageCarp(meat: Meat): Product {
        val product = MeatProduct(
            "Carp 750g", FishType.CARP.toString(), ProductType.MEAT, 420.0, 560.0, 750, "g", meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package bream
     *
     * @param meat
     * @return
     */
    private fun packageBream(meat: Meat): Product {
        val product = MeatProduct(
            "Bream 750g", FishType.BREAM.toString(), ProductType.MEAT, 400.0, 540.0, 750, "g", meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package eel
     *
     * @param meat
     * @return
     */
    private fun packageEel(meat: Meat): Product {
        val product = MeatProduct(
            "Eel 800g", FishType.EEL.toString(), ProductType.MEAT, 500.0, 640.0, 800, "g", meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package zander
     *
     * @param meat
     * @return
     */
    private fun packageZander(meat: Meat): Product {
        val product = MeatProduct(
            "Zander 600g", FishType.ZANDER.toString(), ProductType.MEAT, 500.0, 640.0, 600, "g", meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package catfish
     *
     * @param meat
     * @return
     */
    private fun packageCatfish(meat: Meat): Product {
        val product = MeatProduct(
            "Catfish 600g", FishType.CATFISH.toString(), ProductType.MEAT, 500.0, 640.0, 600, "g", meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    /**
     * Package perch
     *
     * @param meat
     * @return
     */
    private fun packagePerch(meat: Meat): Product {
        val product = MeatProduct(
            "Perch 600g", FishType.PERCH.toString(), ProductType.MEAT, 500.0, 640.0, 600, "g", meat.getOriginID(),
            meat.getState().changeToNextState()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }
}