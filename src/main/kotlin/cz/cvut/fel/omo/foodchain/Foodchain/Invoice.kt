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
        notifyPaidInvoice()
    }


    override fun attach(o: Observer) {
        observers.add(o)
    }

    override fun detach(o: Observer) {
        observers.remove(o)
    }

    override fun notifyUpdate(uuid: UUID, report: String) {
        for (i in observers) {
            i.update(uuid, report)
        }
    }

    fun notifyUnpaidInvoice() {
        notifyUpdate(
            this.code,
            "subscriber: " + this.subscriber.getSubjectName() +
                    ", ico: " + this.subscriber.getIdentifier() +
                    " contractor: " + this.contractor.getSubjectName() +
                    ", ico: " + this.contractor.getIdentifier() +
                    ", price: " + this.price + " note: " + this.note.toString() +
                    ", create date: " + this.createTime.toString() +
                    ", was not paid"
        )
    }

    fun notifyPaidInvoice() {
        notifyUpdate(
            this.code,
            "subscriber: " + this.subscriber.getSubjectName() +
                    ", ico: " + this.subscriber.getIdentifier() +
                    " contractor: " + this.contractor.getSubjectName() +
                    ", ico: " + this.contractor.getIdentifier() +
                    ", price: " + this.price + " note: " + this.note.toString() +
                    ", create date: " + this.createTime +
                    ", was paid in: " + this.paidTime
        )
    }

}