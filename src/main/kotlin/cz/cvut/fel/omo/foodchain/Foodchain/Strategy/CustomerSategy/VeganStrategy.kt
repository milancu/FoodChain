package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.Config
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class VeganStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Double{
        var spended : Double = 0.0
        var toRemove : ArrayList<Product> = ArrayList()

        for (product in products) {
            if (product.getProductType() != ProductType.MEAT
            ) {
                if(product.getAmount() >= Config.STANDARD_SHOP_SIZE){
                    product.decreaseAmount(Config.VEGAN_SHOP_SIZE)
                    spended += Config.VEGAN_SHOP_SIZE * product.getShopPrice()
                } else {
                    toRemove.add(product)
                }
            }
        }
        removeProducts(products, toRemove)
        return spended
    }

    fun removeProducts(original : ArrayList<Product>, toRemove : ArrayList<Product>){
        for(product in toRemove){
            original.remove(product)
        }
    }
}