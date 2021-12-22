package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.enums.InvoiceType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.BaseParty
import java.util.*

class Invoice : Subject {

    private var observers: ArrayList<Observer> = ArrayList()

    private val subscriber: BaseParty // odberatel
    private val contractor: BaseParty // dodavatel
    private val price: Double
    private val note: InvoiceType
    private var isPaid: Boolean
    private var code: UUID
    private var createTime: Int
    private var paidTime: Int = 0

    constructor(subscriber: BaseParty, contractor: BaseParty, price: Double, note: InvoiceType) {
        this.subscriber = subscriber
        this.contractor = contractor
        this.price = price
        this.note = note
        this.isPaid = false
        this.code = UUID.randomUUID()
        this.createTime = Week.acutalWeek
    }

    fun getCreateTime(): Int {
        return this.createTime
    }

    fun getSubscriber(): BaseParty {
        return subscriber
    }

    fun getContractor(): BaseParty {
        return contractor
    }

    fun getPrice(): Double {
        return price
    }

    fun getNote(): InvoiceType {
        return note
    }

    fun getCode(): UUID {
        return code
    }

    fun isPaid(): Boolean {
        return isPaid
    }

    fun payInvoice() {
        this.paidTime = Week.acutalWeek
        isPaid = true
    }


    override fun attach(o: Observer) {
        observers.add(o)
    }

    override fun detach(o: Observer) {
        observers.remove(o)
    }

    override fun notifyUpdate() {
        for (i in observers) {
            i.update(this.code, "NEW INVOICE, Subsriber: " + this.subscriber.getIdentifier() + ", Contractor: " + this.contractor.getIdentifier() + ", price: " + this.price + ", in week:" + Week.acutalWeek)
        }
    }

    fun notifyPaid(){
        for (i in observers) {
            i.update(this.code, "INVOICE HAS BEEN PAID, Subsriber: " + this.subscriber.getIdentifier() + ", Contractor: " + this.contractor.getIdentifier() + ", price: " + this.price + ", in week:" + Week.acutalWeek)
        }
    }

    fun notifyUnpaid(){
        for (i in observers) {
            i.update(this.code, "INVOICE HAS NOT BEEN PAID, Subsriber: " + this.subscriber.getIdentifier() + ", Contractor: " + this.contractor.getIdentifier() + ", price: " + this.price)
        }
    }
}