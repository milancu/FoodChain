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

class MeatFactory(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    private var meatsForProducts: ArrayList<Meat> = ArrayList()
    private var productToSell: ArrayList<Product> = ArrayList()
    private var unpaidInvoices: ArrayList<Invoice> = ArrayList()

    fun getMeatResources(): Int {
        return meatsForProducts.size
    }

    fun getPreparedPorducts(): Int {
        return productToSell.size
    }

    fun takeMeat(newMeats: ArrayList<Meat>) {
        for (meat in newMeats) {
            meatsForProducts.add(meat)
        }
        println("Prevzato masa k zabaleni: " + meatsForProducts.size)
    }

    fun transportProducts() {
        println("/////////////////////////////////////////////")
        println("Aktualne v meetfactory typu produktu k odvezeni: " + productToSell.size)
        Transport.takeProducts(productToSell)
        println("Aktualne prevezeno produktu z MeatFactory: " + Transport.products.size)
        productToSell = ArrayList()
        println("/////////////////////////////////////////////")
        println()
    }

    fun payForInvoice(invoice: Invoice) {
        if (amountOfMoney >= invoice.getPrice()) {
            invoice.payInvoice()
            invoice.getContractor().takeMoney(invoice.getPrice())
            amountOfMoney -= invoice.getPrice()
            println("Faktura " + invoice.getCode() + " zaplacena")
        } else {
            unpaidInvoices.add(invoice)
            println("!Faktura " + invoice.getCode() + " NENI uhrazena")
        }
    }

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
                    var random = (1..6).random()
                    when (random) {
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

    fun packagePorkDumpling(meat: Meat): Product {
        var product = MeatProduct(
            "Pork Dumpling 300g",
            MeatProductType.PORKDUMPLING.toString(),
            ProductType.MEAT,
            150.0,
            180.0,
            300,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packagePorkRoast(meat: Meat): Product {
        var product = MeatProduct(
            "Pork Roast 300g",
            MeatProductType.PORKROAST.toString(),
            ProductType.MEAT,
            160.0,
            170.0,
            300,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packagePorkLeg(meat: Meat): Product {
        var product = MeatProduct(
            "Pork Leg 400g",
            MeatProductType.PORKLEG.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            400,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packagePorkFlank(meat: Meat): Product {
        var product = MeatProduct(
            "Pork Flank 200g",
            MeatProductType.PORKFLANK.toString(),
            ProductType.MEAT,
            180.0,
            200.0,
            200,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageBeefTenderloin(meat: Meat): Product {
        var product = MeatProduct(
            "Beef TenderLoin 400g",
            MeatProductType.BEEFTENDERLOIN.toString(),
            ProductType.MEAT,
            280.0,
            330.0,
            400,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageBovineCheek(meat: Meat): Product {
        var product = MeatProduct(
            "Bovine Cheek 300g",
            MeatProductType.BOVINECHEEK.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageBeefShoulder(meat: Meat): Product {
        var product = MeatProduct(
            "Beef Shoulder 300g",
            MeatProductType.BEEFSHOULDER.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageBeefDumpling(meat: Meat): Product {
        var product = MeatProduct(
            "Beef Dumpling 300g",
            MeatProductType.BEEFDUMPLING.toString(),
            ProductType.MEAT,
            220.0,
            270.0,
            300,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageChickenThigh(meat: Meat): Product {
        var product = MeatProduct(
            "Chicken Thigh 100g",
            MeatProductType.CHICKENTHIGH.toString(),
            ProductType.MEAT,
            90.0,
            110.0,
            100,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageChickenBreast(meat: Meat): Product {
        var product = MeatProduct(
            "Chicken Thigh 150g",
            MeatProductType.CHICKENBREAST.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageChickenWings(meat: Meat): Product {
        var product = MeatProduct(
            "Chicken Wings 150g",
            MeatProductType.CHICKENWINGS.toString(),
            ProductType.MEAT,
            120.0,
            160.0,
            150,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageCarp(meat: Meat): Product {
        var product = MeatProduct(
            "Carp 750g", FishType.CARP.toString(), ProductType.MEAT, 420.0, 560.0, 750, "g", meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageBream(meat: Meat): Product {
        var product = MeatProduct(
            "Bream 750g", FishType.BREAM.toString(), ProductType.MEAT, 400.0, 540.0, 750, "g", meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageEel(meat: Meat): Product {
        var product = MeatProduct(
            "Eel 800g", FishType.EEL.toString(), ProductType.MEAT, 500.0, 640.0, 800, "g", meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageZander(meat: Meat): Product {
        var product = MeatProduct(
            "Zander 600g", FishType.ZANDER.toString(), ProductType.MEAT, 500.0, 640.0, 600, "g", meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packageCatfish(meat: Meat): Product {
        var product = MeatProduct(
            "Catfish 600g", FishType.CATFISH.toString(), ProductType.MEAT, 500.0, 640.0, 600, "g", meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }

    fun packagePerch(meat: Meat): Product {
        var product = MeatProduct(
            "Perch 600g", FishType.PERCH.toString(), ProductType.MEAT, 500.0, 640.0, 600, "g", meat.getOriginID()
        )
        product.attach(Report)
        product.notifyUpdate()
        return product
    }
}