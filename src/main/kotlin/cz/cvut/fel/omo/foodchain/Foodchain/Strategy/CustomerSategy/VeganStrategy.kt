package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.Config
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Vegan strategy
 *
 * @constructor Create empty Vegan strategy
 */
class VeganStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Double{
        var spended = 0.0
        val toRemove : ArrayList<Product> = ArrayList()

        for (product in products) {
            if (product.getProductType() != ProductType.MEAT
            ) {
                if(product.getAmount() >= Config.STANDARD_SHOP_SIZE){
                    product.decreaseAmount(Config.VEGAN_SHOP_SIZE)
                    product.notifyPurchased()
                    spended += Config.VEGAN_SHOP_SIZE * product.getShopPrice()
                } else {
                    toRemove.add(product)
                    println("" + product.getProductType() + " " + product.getName() + " byl vyprodan")
                    product.getState().changeToNextState()
                    product.notifySoldOut()
                }
            }
        }
        removeProducts(products, toRemove)
        return spended
    }

    /**
     * Remove products
     *
     * @param original
     * @param toRemove
     */
    private fun removeProducts(original : ArrayList<Product>, toRemove : ArrayList<Product>){
        for(product in toRemove){
            original.remove(product)
        }
    }
}