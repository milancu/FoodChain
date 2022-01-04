package cz.cvut.fel.omo.foodchain.Foodchain.strategies.product_strategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Processor meat strategy
 *
 * @constructor Create empty Processor meat strategy
 */
interface ProcessorMeatStrategy {
    /**
     * Execute
     *
     * @param meat
     * @return
     */
    fun execute(meat : Meat) : ArrayList<Product>
}