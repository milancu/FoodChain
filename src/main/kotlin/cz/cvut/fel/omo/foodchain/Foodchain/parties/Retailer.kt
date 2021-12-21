package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Retailer(subjectName : String, identier : Int, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

    private var warehouse : Warehouse = Warehouse() //TODO odecet financi za plnost skladu
    private var availableProducts : ArrayList<Product> = ArrayList()
    private var unpaidInvoices : ArrayList<Invoice> = ArrayList()

    fun buyProducts(products : ArrayList<Product>){
        warehouse.takeIn(products)
    }

    fun payForInvoice(invoice: Invoice){
        if(amountOfMoney >= invoice.getPrice()){
            invoice.payInvoice()
            invoice.getContractor().takeMoney(invoice.getPrice())
            amountOfMoney -= invoice.getPrice()
        } else {
            unpaidInvoices.add(invoice)
        }
    }

    fun vacateWarehouse(){
        for(product in warehouse.getStoragedProducts()){
            availableProducts.add(product)
        }
    }

/*    fun fillIn(){
        for(product in warehouse.)
    }*/

    fun fillIn(type : ProductType){
        var newProducts : ArrayList<Product> = warehouse.getSpecificProducts(type)
        for(product in newProducts){
            availableProducts.add(product)
        }
    }



}

// TODO system slev? :D
