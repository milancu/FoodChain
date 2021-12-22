package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.Config
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class BasicStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Double{
        var spended : Double = 0.0

        val productTypeMap: HashMap<ProductType, Int> = productMapInit()
        var toRemove : ArrayList<Product> = ArrayList()

        for(product in products){
            if(productTypeMap.get(product.getProductType())!! < Config.STANDARD_SHOP_SIZE){
                if(product.getAmount() >= Config.STANDARD_SHOP_SIZE){
                    product.decreaseAmount(Config.STANDARD_SHOP_SIZE)
                    spended += Config.STANDARD_SHOP_SIZE * product.getShopPrice()
                } else {
                    println("" + product.getProductType() + " " + product.getName() + " byl vyprodan")
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

    fun productMapInit(): HashMap<ProductType, Int> {
        var prepareMap: HashMap<ProductType, Int> = HashMap<ProductType, Int>()
        prepareMap.put(ProductType.CEREALS, 0)
        prepareMap.put(ProductType.FRUIT, 0)
        prepareMap.put(ProductType.VEGETABLES, 0)
        prepareMap.put(ProductType.LEGUMES, 0)
        prepareMap.put(ProductType.BULKINGREDIENTS, 0)
        prepareMap.put(ProductType.OTHERS, 0)
        prepareMap.put(ProductType.SAUCE, 0)
        prepareMap.put(ProductType.ICED, 0)
        prepareMap.put(ProductType.CANS, 0)
        prepareMap.put(ProductType.OIL, 0)
        prepareMap.put(ProductType.XXX, 0)
        prepareMap.put(ProductType.MEAT, 0)
        prepareMap.put(ProductType.DRINK, 0)
        prepareMap.put(ProductType.ALCOHOL, 0)
        return prepareMap
    }
}