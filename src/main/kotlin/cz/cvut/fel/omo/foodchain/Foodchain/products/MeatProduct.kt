package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository


class MeatProduct(
    private var name: String,

    private var typeOfMeat: String,

    private var productType: ProductType,

    private var shopPrice: Double,

    private var productionCost: Double,

    private var amount: Int,

    private var unit: String,
) : Product(name, shopPrice, productionCost, amount, unit) {
    override fun getAmount(): Int {
        return amount
    }

    override fun getProductType(): ProductType {
        return this.productType
    }

    override fun getShopPrice(): Double {
        return shopPrice
    }
}