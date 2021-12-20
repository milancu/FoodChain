package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType

class Meat {
    private val type: MeatType
    private var shopPrice: Double
    private var productionCost: Double
    private var amount: Double

    constructor(
        type: MeatType,
        shopPrice: Double,
        productionCost: Double,
        amount: Double,
    ) {
        this.type = type
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.amount = amount
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

}