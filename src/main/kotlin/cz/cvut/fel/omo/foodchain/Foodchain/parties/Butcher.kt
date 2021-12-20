package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat

class Butcher {

    fun proccessAnimal(animals: ArrayList<BaseAnimal>): ArrayList<Meat> {
        var meatList = ArrayList<Meat>()

        animals.toList().iterator().forEach { animal ->
            when (animal.animalName) {
                "Cow" -> {
                    val shopPrice = 0.7 * animal.weight * MeatType.BEEF.price
                    meatList.add(Meat(MeatType.BEEF, shopPrice, shopPrice * 1.4, 0.7 * animal.weight))
                }

                "Pig" -> {
                    val shopPrice = 0.7 * animal.weight * MeatType.PORK.price
                    meatList.add(Meat(MeatType.PORK, shopPrice, shopPrice * 1.4, 0.7 * animal.weight))
                }

                "Chicken" -> {
                    val shopPrice = 0.7 * animal.weight * MeatType.CHICKEN.price
                    meatList.add(Meat(MeatType.CHICKEN, shopPrice, shopPrice * 1.4, 0.7 * animal.weight))
                }

                "Fish" -> {
                    val shopPrice = 0.7 * animal.weight * MeatType.FISH.price
                    meatList.add(Meat(MeatType.FISH, shopPrice, shopPrice * 1.4, 0.7 * animal.weight))
                }
            }
        }

        return meatList
    }
}