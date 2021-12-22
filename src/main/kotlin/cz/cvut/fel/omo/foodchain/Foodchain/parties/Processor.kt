package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.Strategy.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Processor(subjectName : String,  location : String, amountOfMoney : Double)
    : BaseParty(subjectName,  location, amountOfMoney) {

    private val cerealStrategy : CerealCropStrategy = CerealCropStrategy()
    private val flowerStrategy : FlowerCropStrategy = FlowerCropStrategy()
    private val fruitStrategy : FruitCropStrategy = FruitCropStrategy()
    private val legumesStrategy : LegumesCropStrategy = LegumesCropStrategy()
    private val vegetableStrategy : VegetableCropStrategy = VegetableCropStrategy()

    private var cropSupplies : ArrayList<Crop> = ArrayList()
    private var unpaidInvoices : ArrayList<Invoice> = ArrayList()
    private var products : ArrayList<Product> = ArrayList()

    fun createProduct(crop : Crop) : Product {
        var context : CropContext
        when(crop.getType()){
            CropType.CEREAL -> {
                context = CropContext(cerealStrategy)
                return context.processProduct(crop)
            }
            CropType.FRUIT -> {
                context = CropContext(fruitStrategy)
                return context.processProduct(crop)
            }
            CropType.VEGETABLE -> {
                context = CropContext(vegetableStrategy)
                return context.processProduct(crop)
            }
            CropType.LEGUMES -> {
                context = CropContext(legumesStrategy)
                return context.processProduct(crop)
            }
            CropType.FLOWER -> {
                context = CropContext(flowerStrategy)
                return context.processProduct(crop)
            }
            else -> throw Exception("Wrong crop type")
        }
    }

    fun processProduct(){
        for(supply in cropSupplies){
            products.add(createProduct(supply))
        }
    }

    fun payForInvoice(invoice: Invoice, time :Int){
        if(amountOfMoney >= invoice.getPrice()){
            invoice.payInvoice(time)
            invoice.getContractor().takeMoney(invoice.getPrice())
            amountOfMoney -= invoice.getPrice()
            println("Faktura " + invoice.getCode() + " zaplacena")
            invoice.notifyPaidInvoice()
        } else {
            unpaidInvoices.add(invoice)
            println("!Faktura " + invoice.getCode() + " NENI uhrazena")
            invoice.notifyUnpaidInvoice()
        }
    }

    fun takeCropSupplies(supplies : ArrayList<Crop>){
        for(supply in supplies){
            cropSupplies.add(supply)
        }
    }

    fun transportProducts(){
        Transport.TransportCompany.takeProducts(products)
        products = ArrayList()
    }

    fun getStockSuppliesSize() : Int{
        return cropSupplies.size
    }

    fun getStockProductsSize() : Int{
        return products.size
    }



}