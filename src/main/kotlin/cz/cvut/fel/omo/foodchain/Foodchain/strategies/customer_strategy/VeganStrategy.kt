package cz.cvut.fel.omo.foodchain.Foodchain.strategies.customer_strategy

import cz.cvut.fel.omo.foodchain.Foodchain.statics.Config
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Vegan strategy
 *
 * @constructor Create empty Vegan strategy
 */
class VeganStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Pair<Double, ArrayList<Product>>{
        var spended = 0.0
        val toRemove : ArrayList<Product> = ArrayList()

        for (product in products) {
            if (product.getProductType() != ProductType.MEAT
            ) {
                if(product.getAmount() >= Config.STANDARD_SHOP_SIZE){
                    product.decreaseAmount(Config.VEGAN_SHOP_SIZE)
                    product.notifyPurchased(product.getAmount())
                    spended += Config.VEGAN_SHOP_SIZE * product.getShopPrice()
                } else {
                    toRemove.add(product)
                    println("" + product.getProductType() + " " + product.getName() + " byl vyprodan")
                    product.getState().changeToNextState()
                    product.notifySoldOut()
                }
            }
        }
        var productsToReturn = removeProducts(products, toRemove)
        return Pair(spended, productsToReturn)
        /*return spended*/
    }

    /**
     * Remove products
     *
     * @param original
     * @param toRemove
     */
    private fun removeProducts(original : ArrayList<Product>, toRemove : ArrayList<Product>) : ArrayList<Product>{
        for(product in toRemove){
            original.remove(product)
        }
        return original
    }
}