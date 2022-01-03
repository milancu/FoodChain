package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Iterator.AnimalToProcess
import cz.cvut.fel.omo.foodchain.Foodchain.Iterator.CustomIterator
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat

class Butcher {


    fun proccessAnimal(animals: AnimalToProcess): ArrayList<Meat> { //ITERATOR
        val meatList = ArrayList<Meat>()

        val iterator: CustomIterator = animals
        while (iterator.hasNext()) {
            val animal: BaseAnimal = iterator.next()
            when (animal.getName()) {
                "Cow" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.BEEF.price
                    val beef = Meat(
                        MeatType.BEEF,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId(), animal.getState().changeToNextState().changeToNextState()
                    )
                    meatList.add(beef)
                    animal.notifyAnimalWasProcessed()
                    beef.attach(Report)
                    beef.notifyUpdate()
                }

                "Pig" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.PORK.price
                    val pork = Meat(
                        MeatType.PORK,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId(), animal.getState().changeToNextState()
                    )
                    meatList.add(pork)
                    animal.notifyAnimalWasProcessed()
                    pork.attach(Report)
                    pork.notifyUpdate()
                }

                "Chicken" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.CHICKEN.price
                    val chicken = Meat(
                        MeatType.CHICKEN,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId(), animal.getState().changeToNextState()
                    )
                    meatList.add(chicken)
                    animal.notifyAnimalWasProcessed()
                    chicken.attach(Report)
                    chicken.notifyUpdate()
                }

                "Fish" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.FISH.price
                    val fish = Meat(
                        MeatType.FISH,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId(), animal.getState().changeToNextState()
                    )
                    meatList.add(fish)
                    animal.notifyAnimalWasProcessed()
                    fish.attach(Report)
                    fish.notifyUpdate()
                }
            }
        }
        return meatList
    }
}