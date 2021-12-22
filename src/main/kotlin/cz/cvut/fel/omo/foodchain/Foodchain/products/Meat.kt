package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.Week
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import java.util.*

class Meat : Subject{
    companion object {
        private var observers: ArrayList<Observer> = ArrayList()
    }
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
        notifyUpdate(origin, this.type.toString() + " " + this.shopPrice + "Kc" + this.amount + "g" + "\n")
    }

    fun getOriginID() : UUID{
        return this.origin
    }

    fun getType () : MeatType{
        return this.type
    }


    fun getShopPrice() : Double{
        return this.shopPrice
    }

    fun getProductionCost() : Double{
        return this.productionCost
    }

    fun getAmount() : Double{
        return this.amount
    }

    override fun attach(o: Observer) {
        Meat.observers.add(o)
    }

    override fun detach(o: Observer) {
        Meat.observers.remove(o)
    }

    override fun notifyUpdate(uuid: UUID, report: String) {
        for(i in Meat.observers){
            i.update(uuid, report)
        }
    }

    fun notifyMeatWasProcessed(){
        notifyUpdate(this.origin, this.type.toString() + " was processed, amount: " + this.amount.toString() + " week: " + Week.acutalWeek.toString() + "\n")
    }

    fun notifyMeatWasPackaged(){
        notifyUpdate(this.origin, this.type.toString() + " was packaged, amount: " + this.amount.toString() + " price: " + this.shopPrice.toString() + " week: " + Week.acutalWeek.toString() + "\n")
    }

}