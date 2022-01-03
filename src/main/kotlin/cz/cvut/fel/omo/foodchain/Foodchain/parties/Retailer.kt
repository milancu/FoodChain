package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product
import org.springframework.beans.factory.annotation.Autowired

/**
 * Retailer
 *
 * @constructor
 *
 * @param subjectName
 * @param location
 * @param amountOfMoney
 */
class Retailer(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    @Autowired
    private var warehouse: Warehouse = Warehouse()
    private var availableProducts: ArrayList<Product> = ArrayList()
    private var unpaidInvoices: ArrayList<Invoice> = ArrayList()
    private var productTypeMap: HashMap<ProductType, Int> = productMapInit()


    /**
     * Product map init
     *
     * @return
     */
    private fun productMapInit(): HashMap<ProductType, Int> {
        val prepareMap: HashMap<ProductType, Int> = HashMap()
        prepareMap[ProductType.CEREALS] = 0
        prepareMap[ProductType.FRUIT] = 0
        prepareMap[ProductType.VEGETABLES] = 0
        prepareMap[ProductType.LEGUMES] = 0
        prepareMap[ProductType.BULKINGREDIENTS] = 0
        prepareMap[ProductType.OTHERS] = 0
        prepareMap[ProductType.SAUCE] = 0
        prepareMap[ProductType.ICED] = 0
        prepareMap[ProductType.CANS] = 0
        prepareMap[ProductType.OIL] = 0
        prepareMap[ProductType.XXX] = 0
        prepareMap[ProductType.MEAT] = 0
        prepareMap[ProductType.DRINK] = 0
        prepareMap[ProductType.ALCOHOL] = 0
        return prepareMap
    }

    /**
     * Buy products
     *
     * @param products
     */
    fun buyProducts(products: ArrayList<Product>) {
        println("Do warehouse privezeno: " + products.size)
        warehouse.takeIn(products)
        println("Naskladneno celkem typu produktu: " + warehouse.getStockSize())
        println()
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

    /**
     * Pay debts
     *
     */
    fun payDebts() {
        val toRemove: ArrayList<Invoice> = ArrayList()
        for (invoice in unpaidInvoices) {
            if (amountOfMoney >= invoice.getPrice()) {
                toRemove.add(invoice)
                payForInvoice(invoice)
            }
        }
        for (invoice in toRemove) {
            println("Penize za " + invoice.getCode() + " splaceny")
            unpaidInvoices.remove(invoice)
        }
    }

    /**
     * Vacate warehouse
     *
     */
    fun vacateWarehouse() {
        for (product in warehouse.getStoragedProducts()) {
            var count: Int? = productTypeMap[product.getProductType()]
            count = count?.plus(product.getAmount())
            if (count != null) {
                productTypeMap[product.getProductType()] = count
            }
            availableProducts.add(product)
        }
    }

    /**
     * Fill in
     *
     */
    fun fillIn() {
        for (product in warehouse.getStoragedProducts()) {
            if (productMapInit()[product.getProductType()]!! < 10) {
                availableProducts.add(product)
                warehouse.getStoragedProducts().remove(product)
            }
        }
    }

    /**
     * Fill in
     *
     * @param type
     */
    fun fillIn(type: ProductType) {
        val newProducts: ArrayList<Product> = warehouse.getSpecificProducts(type)
        for (product in newProducts) {
            availableProducts.add(product)
        }
    }

    /**
     * Get stock size
     *
     * @return
     */
    fun getStockSize(): Int {
        return availableProducts.size
    }

    /**
     * Get warehouse stock size
     *
     * @return
     */
    fun getWarehouseStockSize(): Int {
        return warehouse.getStockSize()
    }

    /**
     * Get available products
     *
     * @return
     */
    fun getAvailableProducts() : ArrayList<Product>{
        return availableProducts
    }

    /**
     * Warehouse management payment
     *
     */
    fun warehouseManagementPayment(){
        this.amountOfMoney -= warehouse.warehouseManagementPayment()
    }
}