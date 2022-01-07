package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.states.Context
import cz.cvut.fel.omo.foodchain.Foodchain.states.State
import cz.cvut.fel.omo.foodchain.Foodchain.statics.Week
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import java.util.*

//TODO jakto ze productionCost neni pouzita? Vyres, zbytek asi mila? Date?

/**
 * Product
 *
 * @constructor Create empty Product
 */
open class Product(
    private var name: String,
    private var shopPrice: Double,
    private var productionCost: Double,
    private var amount: Int,
    private var unit: String,
    private var origin: UUID,
    private var state : State
) : Subject, Context {

    private var observers: ArrayList<Observer> = ArrayList()

    private var productType: ProductType = ProductType.NOTSET
    private var uuid: UUID = UUID.randomUUID()
    private var createdAt : Int = Week.acutalWeek


    /**
     * Get create at
     *
     * @return
     */
    fun getCreateAt() : Int {
        return this.createdAt
    }

    /**
     * Get origin id
     *
     * @return
     */
    open fun getOriginId(): UUID {
        return this.origin
    }

    /**
     * Get product type
     *
     * @return
     */
    open fun getProductType(): ProductType {
        return this.productType
    }

    /**
     * Get shop price
     *
     * @return
     */
    open fun getShopPrice(): Double {
        return shopPrice
    }

    /**
     * Get amount
     *
     * @return
     */
    open fun getAmount(): Int {
        return this.amount
    }

    /**
     * Get name
     *
     * @return
     */
    open fun getName() : String{
        return this.name
    }

    override fun attach(o: Observer) {
        observers.add(o)
    }

    override fun detach(o: Observer) {
        observers.remove(o)
    }

    override fun notifyUpdate() {
        for (i in observers) {
            i.update(this.origin,
                "NEW PRODUCT, " + this.name + ", amount: " + this.amount + "g, shop price: " + this.shopPrice + " in week:" + Week.acutalWeek)
        }
    }

    open fun notifyTransport() {
        for (i in observers) {
            i.update(this.origin,
                "PRODUCT HAS BEEN SHIPPED, " + this.name + ", shop price: " + this.shopPrice + " in week:" + Week.acutalWeek)
        }
    }

    open fun notifyPurchased(amount :Int){
        for (i in observers) {
            i.update(this.origin,
                "PRODUCT HAS BEEN PURCHASED, " + this.name + ", amount: " + amount.toString() + "g, shop price: " + this.shopPrice + " in week:" + Week.acutalWeek)
        }
    }

    open fun notifySoldOut(){
        for (i in observers) {
            i.update(this.origin,
                "PRODUCT WAS SOLD OUT, in week:" + Week.acutalWeek)
        }
    }

    /**
     * Decrease amount
     *
     * @param value
     */
    open fun decreaseAmount(value : Int){
        this.amount = this.amount - value
    }

    override fun setState(state: State) {
        this.state = state
    }

/*    fun changeState() {
        this.state.changeToNextState()
    }*/

    fun getState() : State{
        return state
    }
}