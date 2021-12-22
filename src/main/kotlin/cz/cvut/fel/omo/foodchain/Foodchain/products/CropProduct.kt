package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

//@Component
class CropProduct(
    private var name: String,

    private var type: ProductType,

    private var shopPrice: Double,

    private var productionCost: Double,

    private var amount: Int,

    private var unit: String,

    private var origin: UUID,


    ) :  Product(name, shopPrice, productionCost, amount, unit, origin) {

    override fun getName() : String{
        return this.name
    }

    override fun getAmount(): Int {
        return amount
    }

    override fun getProductType(): ProductType {
        return this.type
    }

    override fun getShopPrice(): Double {
        return shopPrice
    }

    override fun getOriginId(): UUID {
        return this.origin
    }
}