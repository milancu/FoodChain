package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.Week
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import java.util.*

open class Product : Subject {

    private var observers: ArrayList<Observer> = ArrayList()

    private var name: String
    private var productType: ProductType
    private var shopPrice: Double
    private var productionCost: Double
    private var amount: Int
    private var unit: String
    private var uuid: UUID
    private var origin: UUID
    private var createdAt : Int

    constructor(
        name: String,
        shopPrice: Double,
        productionCost: Double,
        amount: Int,
        unit: String,
        origin: UUID
    ) {
        this.name = name
        this.productType = ProductType.NOTSET
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.amount = amount
        this.unit = unit
        this.uuid = UUID.randomUUID()
        this.origin = origin
        this.createdAt = Week.acutalWeek
    }

    fun getCreateAt() : Int {
        return this.createdAt
    }

    open fun getOriginId(): UUID {
        return this.origin
    }

    open fun getProductType(): ProductType {
        return this.productType
    }

    open fun getShopPrice(): Double {
        return shopPrice
    }

    open fun getAmount(): Int {
        return amount
    }

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

    fun decreaseAmount(value : Int){
        this.amount -= value
    }
}