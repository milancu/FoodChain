package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatName
import java.util.*

class Meat {
    private val name: MeatName
    private var amount: Int
    private val uuid: UUID
    private var shopPrice: Double
    private var productionCost: Double

    constructor(name: MeatName, amount: Int, growthTime: Int) {
        this.name = name
        this.amount = amount
        this.uuid = UUID.randomUUID()
        this.shopPrice = name.shopPrice
        this.productionCost = shopPrice * 0.01
    }

    fun getName(): MeatName {
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

    fun setAmount(value: Int) {
        amount = value
    }
}