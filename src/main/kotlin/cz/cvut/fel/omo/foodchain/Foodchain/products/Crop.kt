package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import java.util.*

class Crop : Subject {
    companion object {
        private var observers: ArrayList<Observer> = ArrayList()
    }

    private val name: CropName
    private val type: CropType
    private var amount: Int
    private val uuid: UUID
    private var shopPrice: Double
    private var productionCost: Double
    private var growthTime: Int
    private val origin: UUID

    constructor(name: CropName, type: CropType, amount: Int, growthTime: Int) {
        this.name = name
        this.type = type
        this.amount = amount
        this.uuid = UUID.randomUUID()
        this.shopPrice = name.shopPrice
        this.productionCost = shopPrice * 0.01
        this.growthTime = growthTime
        this.origin = UUID.randomUUID()
        notifyUpdate(origin, this.name.toString() + " " + this.amount.toString() + "kg")

    }

    fun getOriginID(): UUID {
        return this.origin
    }

    fun getName(): CropName {
        return name
    }

    fun getAmount(): Int {
        return amount
    }

    fun getProductionCost(): Double {
        return productionCost
    }

    fun getShopPrice(): Double {
        return shopPrice
    }

    fun getType(): CropType {
        return type
    }

    fun getGrowth(): Int {
        return growthTime
    }

    fun setAmount(value: Int) {
        this.amount = value
    }

    fun decreaseAmount() {
        this.amount -= 5
    }

    fun resetCrop() {
        growthTime = 0
    }

    fun grow() {
        growthTime++;
    }

    override fun attach(o: Observer) {
        Crop.observers.add(o)
    }

    override fun detach(o: Observer) {
        Crop.observers.remove(o)
    }

    override fun notifyUpdate(uuid: UUID, report: String) {
        for (i in Crop.observers) {
            i.update(uuid, report)
        }
    }

    fun notifyCropWasExecuted() {
        notifyUpdate(
            origin,
            this.name.toString() + "\n" +
                    ", Crop was executed " + "\n" +
                    this.type.toString() + " \n" +
                    this.amount.toString() + "kg" +
                    " shopprice: " + this.shopPrice.toString()
        )
    }

    fun notifyCropWasHarvested(){
        notifyUpdate(
            origin,
            this.name.toString() + "\n" +
                    ", Crop was harvested " + "\n" +
                    this.type.toString() + " \n" +
                    this.amount.toString() + "kg" +
                    " shopprice: " + this.shopPrice.toString()
        )
    }
}