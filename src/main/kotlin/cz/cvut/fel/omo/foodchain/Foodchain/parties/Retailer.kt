package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Retailer(subjectName : String, identier : Int, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

    private var warehouse : Warehouse = Warehouse() //TODO odecet financi za plnost skladu
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


}

// TODO system slev? :D
