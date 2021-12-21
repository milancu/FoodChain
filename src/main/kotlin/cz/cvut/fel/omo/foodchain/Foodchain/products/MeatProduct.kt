package cz.cvut.fel.omo.foodchain.Foodchain.products

import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatProductType

class MeatProduct(
    name: String,
    private var type: String,
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