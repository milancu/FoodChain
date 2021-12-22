package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat

class Butcher {

    fun proccessAnimal(animals: ArrayList<BaseAnimal>): ArrayList<Meat> {
        var meatList = ArrayList<Meat>()

        animals.toList().iterator().forEach { animal ->
            when (animal.getName()) {
                "Cow" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.BEEF.price
                    var beef = Meat(MeatType.BEEF, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight(), animal.getOriginId())
                    meatList.add(beef)
                }

                "Pig" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.PORK.price
                    var pork = Meat(MeatType.PORK, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight(), animal.getOriginId())
                    meatList.add(pork)
                }

                "Chicken" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.CHICKEN.price
                    var chicken = Meat(MeatType.CHICKEN, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight(), animal.getOriginId())
                    meatList.add(chicken)
                }

                "Fish" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.FISH.price
                    var fish = Meat(MeatType.FISH, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight(), animal.getOriginId())
                    meatList.add(fish)
                }
            }
        }

        return meatList
    }
}