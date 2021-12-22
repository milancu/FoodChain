package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class EasterEggStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Double{
        var spended : Double = 0.0

        for(product in products){
            val random : Int = (0..1).random()
            val randomSize : Int = (5..15).random()
            if(random == 1 || product.getProductType() == ProductType.XXX){
                if(product.getAmount() >= randomSize){
                    product.decreaseAmount(randomSize)
                    spended += randomSize * product.getShopPrice()
                } else {
                    products.remove(product)
                }
            }
        }
        return spended
    }
}