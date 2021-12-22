package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import java.util.*

open class Product : Subject{
    companion object {
        private var observers: ArrayList<Observer> = ArrayList()
    }
    private var name: String
    private var productType: ProductType
    private var shopPrice: Double
    private var productionCost: Double
    private var amount: Int
    private var unit: String
    private var uuid: UUID
    private var origin: UUID

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
        notifyUpdate(origin, this.name + " " + this.shopPrice + "Kc" + this.amount + "g")
    }

    open fun getOriginId() : UUID{
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

    override fun attach(o: Observer) {
        Product.observers.add(o)
    }

    override fun detach(o: Observer) {
        Product.observers.remove(o)
    }

    override fun notifyUpdate(uuid: UUID, report: String) {
        for(i in Product.observers){
            i.update(uuid, report)
        }
    }
}