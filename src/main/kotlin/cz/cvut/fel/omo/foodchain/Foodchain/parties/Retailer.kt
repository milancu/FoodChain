package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Retailer(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    private var warehouse: Warehouse = Warehouse()
    private var availableProducts: ArrayList<Product> = ArrayList()
    private var unpaidInvoices: ArrayList<Invoice> = ArrayList()
    private var productTypeMap: HashMap<ProductType, Int> = productMapInit()


    fun productMapInit(): HashMap<ProductType, Int> {
        var prepareMap: HashMap<ProductType, Int> = HashMap<ProductType, Int>()
        prepareMap.put(ProductType.CEREALS, 0)
        prepareMap.put(ProductType.FRUIT, 0)
        prepareMap.put(ProductType.VEGETABLES, 0)
        prepareMap.put(ProductType.LEGUMES, 0)
        prepareMap.put(ProductType.BULKINGREDIENTS, 0)
        prepareMap.put(ProductType.OTHERS, 0)
        prepareMap.put(ProductType.SAUCE, 0)
        prepareMap.put(ProductType.ICED, 0)
        prepareMap.put(ProductType.CANS, 0)
        prepareMap.put(ProductType.OIL, 0)
        prepareMap.put(ProductType.XXX, 0)
        prepareMap.put(ProductType.MEAT, 0)
        prepareMap.put(ProductType.DRINK, 0)
        prepareMap.put(ProductType.ALCOHOL, 0)
        return prepareMap
    }

    fun buyProducts(products: ArrayList<Product>) {
        println("Do warehouse privezeno: " + products.size)
        warehouse.takeIn(products)
        println("Naskladneno celkem typu produktu: " + warehouse.getStockSize())
        println()
    }

    fun payForInvoice(invoice: Invoice) {
        if (amountOfMoney >= invoice.getPrice()) {
            invoice.payInvoice()
            invoice.getContractor().takeMoney(invoice.getPrice())
            invoice.notifyPaid()
            amountOfMoney -= invoice.getPrice()
            println("Faktura " + invoice.getCode() + " zaplacena")
        } else {
            unpaidInvoices.add(invoice)
            println("!Faktura " + invoice.getCode() + " NENI uhrazena")
            invoice.notifyUnpaid()
        }
        println()
    }

    fun payDebts() {
        var toRemove: ArrayList<Invoice> = ArrayList()
        for (invoice in unpaidInvoices) {
            if (amountOfMoney >= invoice.getPrice()) {
                toRemove.add(invoice)
                invoice.payInvoice()
                amountOfMoney -= invoice.getPrice()
            }
        }
        for (invoice in toRemove) {
            println("Penize za " + invoice.getCode() + " splaceny")
            unpaidInvoices.remove(invoice)
        }
    }

    fun vacateWarehouse() {
        for (product in warehouse.getStoragedProducts()) {
            var count: Int? = productTypeMap.get(product.getProductType())
            count = count?.plus(product.getAmount())
            if (count != null) {
                productTypeMap.put(product.getProductType(), count)
            }
            availableProducts.add(product)
        }
    }

    fun fillIn() {
        for (product in warehouse.getStoragedProducts()) {
            if (productMapInit().get(product.getProductType())!! < 100) {
                availableProducts.add(product)
                warehouse.getStoragedProducts().remove(product)
            }
        }
    }

    fun fillIn(type: ProductType) {
        var newProducts: ArrayList<Product> = warehouse.getSpecificProducts(type)
        for (product in newProducts) {
            availableProducts.add(product)
        }
    }

    fun getStockSize(): Int {
        return availableProducts.size
    }

    fun getWarehouseStockSize(): Int {
        return warehouse.getStockSize()
    }

    fun getAvailableProducts() : ArrayList<Product>{
        return availableProducts
    }

    fun warehouseManagementPayment(){
        this.amountOfMoney -= warehouse.warehouseManagementPayment()
    }
}