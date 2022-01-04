package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Random strategy
 *
 * @constructor Create empty Random strategy
 */
class RandomStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Pair<Double, ArrayList<Product>>{
        var spended = 0.0
        val toRemove : ArrayList<Product> = ArrayList()

        for(product in products){
            val random : Int = (0..1).random()
            val randomSize : Int = /*(5..15).random()*/ 5
            if(random == 1){
                if(product.getAmount() >= randomSize){
                    product.decreaseAmount(randomSize)
                    product.notifyPurchased(4, product.getAmount())
                    spended += randomSize * product.getShopPrice()
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