package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType

class CropProduct(
    private var name: String,
    private var type: ProductType,
    private var shopPrice: Double,
    private var productionCost: Double,
    private var amount: Int,
    private var unit: String,
) :
    Product(
        name,
        type,
        shopPrice,
        productionCost,
        amount,
        unit
    )
