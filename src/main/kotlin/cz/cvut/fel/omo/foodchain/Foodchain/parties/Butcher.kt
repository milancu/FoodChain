package cz.cvut.fel.omo.foodchain.Foodchain.parties

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
                    meatList.add(Meat(MeatType.BEEF, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight()))
                }

                "Pig" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.PORK.price
                    meatList.add(Meat(MeatType.PORK, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight()))
                }

                "Chicken" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.CHICKEN.price
                    meatList.add(Meat(MeatType.CHICKEN, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight()))
                }

                "Fish" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.FISH.price
                    meatList.add(Meat(MeatType.FISH, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight()))
                }
            }
        }

        return meatList
    }
}