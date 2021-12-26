package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
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
    fun execute(products : ArrayList<Product>): Double
}