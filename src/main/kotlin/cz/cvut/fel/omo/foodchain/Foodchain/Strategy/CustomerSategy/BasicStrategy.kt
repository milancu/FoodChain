package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.Config
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Basic strategy
 *
 * @constructor Create empty Basic strategy
 */
class BasicStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Double{
        var spended = 0.0

        val productTypeMap: HashMap<ProductType, Int> = productMapInit()
        val toRemove : ArrayList<Product> = ArrayList()

        for(product in products){
            if(productTypeMap[product.getProductType()]!! < Config.STANDARD_SHOP_SIZE){
                if(product.getAmount() >= Config.STANDARD_SHOP_SIZE){
                    product.decreaseAmount(Config.STANDARD_SHOP_SIZE)
                    spended += Config.STANDARD_SHOP_SIZE * product.getShopPrice()
                    product.notifyPurchased()
                } else {
                    println("" + product.getProductType() + " " + product.getName() + " byl vyprodan")
                    toRemove.add(product)
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

    /**
     * Product map init
     *
     * @return
     */
    private fun productMapInit(): HashMap<ProductType, Int> {
        val prepareMap: HashMap<ProductType, Int> = HashMap()
        prepareMap[ProductType.CEREALS] = 0
        prepareMap[ProductType.FRUIT] = 0
        prepareMap[ProductType.VEGETABLES] = 0
        prepareMap[ProductType.LEGUMES] = 0
        prepareMap[ProductType.BULKINGREDIENTS] = 0
        prepareMap[ProductType.OTHERS] = 0
        prepareMap[ProductType.SAUCE] = 0
        prepareMap[ProductType.ICED] = 0
        prepareMap[ProductType.CANS] = 0
        prepareMap[ProductType.OIL] = 0
        prepareMap[ProductType.XXX] = 0
        prepareMap[ProductType.MEAT] = 0
        prepareMap[ProductType.DRINK] = 0
        prepareMap[ProductType.ALCOHOL] = 0
        return prepareMap
    }
}