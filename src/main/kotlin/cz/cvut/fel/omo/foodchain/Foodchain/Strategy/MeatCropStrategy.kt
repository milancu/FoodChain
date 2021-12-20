package cz.cvut.fel.omo.foodchain.Foodchain.Strategy

import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatName
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class MeatCropStrategy : ProcessorMeatStrategy {
    override fun execute(meat: Meat): Product {
        when(meat.getName()){
            MeatName.HAM->
        }
    }
}