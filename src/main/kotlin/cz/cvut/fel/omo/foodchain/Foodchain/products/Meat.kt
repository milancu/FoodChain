package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.Week
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import java.util.*

/**
 * Meat
 *
 * @constructor Create empty Meat
 */
class Meat(
    private val type: MeatType,
    private var shopPrice: Double,
    private var productionCost: Double,
    private var amount: Double,
    private var origin: UUID
) : Subject {

    private var observers: ArrayList<Observer> = ArrayList()

    /**
     * Get origin i d
     *
     * @return
     */
    fun getOriginID(): UUID {
        return this.origin
    }

    /**
     * Get type
     *
     * @return
     */
    fun getType(): MeatType {
        return this.type
    }


    /**
     * Get shop price
     *
     * @return
     */
    fun getShopPrice(): Double {
        return this.shopPrice
    }

    /**
     * Get production cost
     *
     * @return
     */
    fun getProductionCost(): Double {
        return this.productionCost
    }

    /**
     * Get amount
     *
     * @return
     */
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
            i.update(this.origin, "NEW MEAT, " + this.type + ", amount: " + this.amount + "g, in week: " + Week.acutalWeek)
        }
    }


}