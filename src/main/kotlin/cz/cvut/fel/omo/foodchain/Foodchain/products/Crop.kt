package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.Code
import java.util.*

class Crop {
    private val name: String
    private var amount: Int
    private val code : Code
    private var shopPrice : Double
    private var productionCost : Int
    private val growthTime : Int

    constructor(name: String, amount: Int, code: Code, shopPrice: Double, productionCost: Int, growthTime: Int) {
        this.name = name
        this.amount = amount
        this.code = code
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.growthTime = growthTime
    }

    fun getName() : String{
        return name
    }

    fun getAmount() : Int{
        return amount
    }

    fun getProductionCost() : Int{
        return productionCost
    }

    fun getShopPrice() : Double{
        return shopPrice
    }

    fun setAmount(value : Int){
        amount = value
    }







}