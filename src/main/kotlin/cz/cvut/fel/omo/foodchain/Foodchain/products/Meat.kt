package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.Week
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import java.util.*

class Meat : Subject {

    private var observers: ArrayList<Observer> = ArrayList()

    private val type: MeatType
    private var shopPrice: Double
    private var productionCost: Double
    private var amount: Double
    private var origin: UUID

    constructor(
        type: MeatType,
        shopPrice: Double,
        productionCost: Double,
        amount: Double,
        origin: UUID
    ) {
        this.type = type
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.amount = amount
        this.origin = origin
    }

    fun getOriginID(): UUID {
        return this.origin
    }

    fun getType(): MeatType {
        return this.type
    }


    fun getShopPrice(): Double {
        return this.shopPrice
    }

    fun getProductionCost(): Double {
        return this.productionCost
    }

    fun getAmount(): Double {
        return this.amount
    }

    override fun attach(o: Observer) {
        observers.add(o)
    }

    override fun detach(o: Observer) {
        observers.remove(o)
    }

    override fun notifyUpdate() {
        for (i in observers) {
            i.update(this.origin, "")
        }
    }


}