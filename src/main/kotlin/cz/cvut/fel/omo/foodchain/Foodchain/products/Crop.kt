package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import java.util.*

class Crop {
    private val name: CropName
    private var amount: Int
    private val uuid : UUID
    private var shopPrice : Double
    private var productionCost : Double
    private val growthTime : Int

    constructor(name: CropName, amount: Int, growthTime: Int) {
        this.name = name
        this.amount = amount
        this.uuid = UUID.randomUUID()
        this.shopPrice = name.shopPrice
        this.productionCost = shopPrice * 0.01
        this.growthTime = name.growthTime
    }

    fun getName() : CropName{
        return name
    }

    fun getAmount() : Int{
        return amount
    }

    fun getProductionCost() : Double{
        return productionCost
    }

    fun getShopPrice() : Double{
        return shopPrice
    }

    fun setAmount(value : Int){
        amount = value
    }
}