package cz.cvut.fel.omo.foodchain.Foodchain.products

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