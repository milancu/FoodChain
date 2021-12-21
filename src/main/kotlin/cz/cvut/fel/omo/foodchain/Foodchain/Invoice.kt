package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.BaseParty

class Invoice {

    private val subscriber : BaseParty // odberatel
    private val contractor : BaseParty // dodavatel
    private val price : Double
    private val note : InvoiceType
    private var isPaid : Boolean

    constructor(subscriber: BaseParty, contractor: BaseParty, price: Double, note: InvoiceType) {
        this.subscriber = subscriber
        this.contractor = contractor
        this.price = price
        this.note = note
        this.isPaid = false
    }

    fun getSubscriber() : BaseParty{
        return subscriber
    }

    fun getContractor() : BaseParty{
        return contractor
    }

    fun getPrice() : Double{
        return price
    }

    fun getNote() : InvoiceType{
        return note
    }

    fun isPaid() :Boolean{
        return isPaid
    }

    fun payInvoice() {
        isPaid = true
    }

}