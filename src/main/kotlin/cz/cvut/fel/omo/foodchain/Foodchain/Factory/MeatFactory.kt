package cz.cvut.fel.omo.foodchain.Foodchain.Factory

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.FishType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.BaseParty
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.MeatProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class MeatFactory(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney){

    private var meatsForProducts : ArrayList<Meat> = ArrayList()
    private var productToSell : ArrayList<Product> = ArrayList()
    private var unpaidInvoices : ArrayList<Invoice> = ArrayList()


    fun takeMeat(newMeats : ArrayList<Meat>){
        for(meat in newMeats){
            meatsForProducts.add(meat)
        }
    }

    fun payForInvoice(invoice: Invoice){
        if(amountOfMoney >= invoice.getPrice()){
            invoice.payInvoice()
            invoice.getContractor().takeMoney(invoice.getPrice())
            amountOfMoney -= invoice.getPrice()
            println("Faktura " + invoice.getCode() + " zaplacena")
        } else {
            unpaidInvoices.add(invoice)
            println("!Faktura " + invoice.getCode() + " NENI uhrazena")
        }
    }

    fun packageProduct(){
        for(meat in meatsForProducts){
            when(meat.getType()){
                MeatType.PORK ->{
                    for(i in 1..(meat.getAmount()/1600).toInt()){
                        productToSell.add(packagePorkDumpling(meat))
                        productToSell.add(packagePorkRoast(meat))
                        productToSell.add(packagePorkFlank(meat))
                    }
                    for(i in 1..4){
                        productToSell.add(packagePorkLeg(meat))
                    }
                }
                MeatType.BEEF ->{
                    productToSell.add(packageBeefTenderloin(meat))
                    productToSell.add(packageBovineCheek(meat))
                    productToSell.add(packageBeefShoulder(meat))
                    productToSell.add(packageBeefDumpling(meat))
                }
                MeatType.CHICKEN ->{

                    productToSell.add(packageChickenBreast(meat))
                    productToSell.add(packageChickenWings(meat))
                    for(i in 1..2){
                        productToSell.add(packageChickenThigh(meat))
                    }
                }
                MeatType.FISH ->{
                    productToSell.add(packageCarp(meat))
                    productToSell.add(packageBream(meat))
                    productToSell.add(packageEel(meat))
                    productToSell.add(packageZander(meat))
                    productToSell.add(packageCatfish(meat))
                    productToSell.add(packagePerch(meat))
                }
            }
        }
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
        return product
    }

    fun packageCarp(meat: Meat): Product {
        var product = MeatProduct(
            "Carp 750g",
            FishType.CARP.toString(),
            ProductType.MEAT,
            420.0,
            560.0,
            750,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        return product
    }

    fun packageBream(meat: Meat): Product {
        var product = MeatProduct(
            "Bream 750g",
            FishType.BREAM.toString(),
            ProductType.MEAT,
            400.0,
            540.0,
            750,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        return product
    }

    fun packageEel(meat: Meat): Product {
        var product = MeatProduct(
            "Eel 800g",
            FishType.EEL.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            800,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        return product
    }

    fun packageZander(meat: Meat): Product {
        var product = MeatProduct(
            "Zander 600g",
            FishType.ZANDER.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        return product
    }

    fun packageCatfish(meat: Meat): Product {
        var product = MeatProduct(
            "Catfish 600g",
            FishType.CATFISH.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        return product
    }

    fun packagePerch(meat: Meat): Product {
        var product = MeatProduct(
            "Perch 600g",
            FishType.PERCH.toString(),
            ProductType.MEAT,
            500.0,
            640.0,
            600,
            "g",
            meat.getOriginID()
        )
        product.attach(Report)
        return product
    }
}