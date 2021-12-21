package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType

class CropProduct(
    name: String,
    private var type: ProductType,
    shopPrice: Double,
    productionCost: Double,
    amount: Int,
    unit: String,
) :
    Product(
        name,
        shopPrice,
        productionCost,
        amount,
        unit
    )
