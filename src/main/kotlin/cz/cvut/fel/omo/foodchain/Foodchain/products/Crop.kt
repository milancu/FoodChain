package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.Week
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import java.util.*

/**
 * Crop
 *
 * @constructor Create empty Crop
 */
class Crop : Subject {

    private var observers: ArrayList<Observer> = ArrayList()

    private val name: CropName
    private val type: CropType
    private var amount: Int
    private val uuid: UUID
    private var shopPrice: Double
    private var productionCost: Double
    private var growthTime: Int

    constructor(name: CropName, type: CropType, amount: Int, growthTime: Int) {
        this.name = name
        this.type = type
        this.amount = amount
        this.uuid = UUID.randomUUID()
        this.shopPrice = name.shopPrice
        this.productionCost = shopPrice * 0.01
        this.growthTime = growthTime
    }

    /**
     * Get u u i d
     *
     * @return
     */
    fun getUUID(): UUID {
        return this.uuid
    }

    /**
     * Get capacity
     *
     * @return
     */
    fun getCapacity(): Int {
        return this.amount
    }

    /**
     * Get name
     *
     * @return
     */
    fun getName(): CropName {
        return name
    }

    /**
     * Get amount
     *
     * @return
     */
    fun getAmount(): Int {
        return amount
    }

    /**
     * Get production cost
     *
     * @return
     */
    fun getProductionCost(): Double {
        return productionCost
    }

    /**
     * Get shop price
     *
     * @return
     */
    fun getShopPrice(): Double {
        return shopPrice
    }

    /**
     * Get type
     *
     * @return
     */
    fun getType(): CropType {
        return type
    }

    /**
     * Get growth
     *
     * @return
     */
    fun getGrowth(): Int {
        return growthTime
    }

    /**
     * Set amount
     *
     * @param value
     */
    fun setAmount(value: Int) {
        this.amount = value
    }

    /**
     * Decrease amount
     *
     */
    fun decreaseAmount() {
        this.amount -= 5
    }

    /**
     * Reset crop
     *
     */
    fun resetCrop() {
        growthTime = 0
    }

    /**
     * Grow
     *
     */
    fun grow() {
        growthTime++;
    }

    override fun attach(o: Observer) {
        observers.add(o)
    }

    override fun detach(o: Observer) {
        observers.remove(o)
    }

    override fun notifyUpdate() {
        for (i in observers) {
            i.update(this.uuid, "NEW CROP, " + this.name + ", amount: " + this.amount + "g, in week: " + Week.acutalWeek)
        }
    }

    /**
     * Notify was harvested
     *
     */
    fun notifyWasHarvested(){
        for (i in observers) {
            i.update(this.uuid, "CROP HAS BEEN HARVESTED IN WEEK: " + Week.acutalWeek)
        }
    }
}