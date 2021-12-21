package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

// TODO bude potreba neco pridavat nevystacime si s Product a Crop a name


open class Product {
    private var name: String
    private var productType: ProductType
    private var shopPrice: Double
    private var productionCost: Double
    private var amount: Int
    private var unit: String
    private var uuid: UUID

    constructor(
        name: String,
        shopPrice: Double,
        productionCost: Double,
        amount: Int,
        unit: String
    ) {
        this.name = name
        this.productType = ProductType.NOTSET
        this.shopPrice = shopPrice
        this.productionCost = productionCost
        this.amount = amount
        this.unit = unit
        this.uuid = UUID.randomUUID()
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
}