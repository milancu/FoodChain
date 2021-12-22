package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class RandomStrategy : CustomerStrategy {
    override fun execute(products : ArrayList<Product>) : Double{
        var spended : Double = 0.0

        for(product in products){
            val random : Int = (0..1).random()
            if(random == 1){
                if(product.getAmount() >= 10){

                }
            }
        }

        return spended
    }
}