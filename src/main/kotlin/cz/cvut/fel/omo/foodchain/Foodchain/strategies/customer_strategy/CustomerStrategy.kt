package cz.cvut.fel.omo.foodchain.Foodchain.strategies.customer_strategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Customer strategy
 *
 * @constructor Create empty Customer strategy
 */
interface CustomerStrategy {
    /**
     * Execute
     *
     * @param products
     * @return
     */
    fun execute(products : ArrayList<Product>): Pair<Double, ArrayList<Product>>
}