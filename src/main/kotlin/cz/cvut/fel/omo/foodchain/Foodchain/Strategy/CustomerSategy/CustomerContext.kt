package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy

import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class CustomerContext {
    var strategy : CustomerStrategy

    constructor(strategy: CustomerStrategy) {
        this.strategy = strategy
    }

    fun setStrategy(strategy : BasicStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : EasterEggStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : MeatLoverStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : RandomStrategy){
        this.strategy = strategy
    }

    fun setStrategy(strategy : VeganStrategy){
        this.strategy = strategy
    }

    fun goShopping() : ArrayList<Product>{
        return strategy.execute()
    }
}