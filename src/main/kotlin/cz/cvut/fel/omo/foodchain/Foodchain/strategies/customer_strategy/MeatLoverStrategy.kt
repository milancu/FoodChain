package cz.cvut.fel.omo.foodchain.Foodchain.strategies.customer_strategy

import cz.cvut.fel.omo.foodchain.Foodchain.statics.Config
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product
import org.slf4j.LoggerFactory

/**
 * Meat lover strategy
 *
 * @constructor Create empty Meat lover strategy
 */
class MeatLoverStrategy : CustomerStrategy {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun execute(products: ArrayList<Product>): Pair<Double, ArrayList<Product>> {
        var spended = 0.0
        val toRemove : ArrayList<Product> = ArrayList()

        for (product in products) {
            if (product.getProductType() == ProductType.MEAT ||
                product.getProductType() == ProductType.OTHERS ||
                product.getProductType() == ProductType.SAUCE
            ) {
                if(product.getProductType() == ProductType.MEAT){
                    product.notifyPurchased(product.getAmount())
                    spended += Config.WORKOUT_SHOP_SIZE * product.getShopPrice()
                    toRemove.add(product)
                }
                 else if(product.getAmount() >= Config.WORKOUT_SHOP_SIZE){
                    product.decreaseAmount(Config.WORKOUT_SHOP_SIZE)
                    product.notifyPurchased(product.getAmount())
                    spended += Config.WORKOUT_SHOP_SIZE * product.getShopPrice()
                } else {
                    toRemove.add(product)
                    logger.info("" + product.getProductType() + " " + product.getName() + " byl vyprodan")
                    product.getState().changeToNextState()
                    product.notifySoldOut()
                }
            }
        }
        val productsToReturn = removeProducts(products, toRemove)
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