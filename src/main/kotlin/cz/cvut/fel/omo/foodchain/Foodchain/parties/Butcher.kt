package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Iterator.AnimalToProcess
import cz.cvut.fel.omo.foodchain.Foodchain.Iterator.CustomIterator
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.enums.MeatType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat

/**
 * Butcher
 *
 * @constructor Create empty Butcher
 */
class Butcher {

    /**
     * Proccess animal
     *
     * @param animals
     * @return
     */
    fun proccessAnimal(animals: ArrayList<BaseAnimal>): ArrayList<Meat> {
        var meatList = ArrayList<Meat>()

        animals.toList().iterator().forEach { animal ->
            when (animal.getName()) {
                "Cow" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.BEEF.price
                    var beef =
                        Meat(MeatType.BEEF, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight(), animal.getOriginId())
                    meatList.add(beef)
                    animal.notifyAnimalWasProcessed()
                    beef.attach(Report)
                    beef.notifyUpdate()
                }

                "Pig" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.PORK.price
                    var pork =
                        Meat(MeatType.PORK, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight(), animal.getOriginId())
                    meatList.add(pork)
                    animal.notifyAnimalWasProcessed()
                    pork.attach(Report)
                    pork.notifyUpdate()
                }

                "Chicken" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.CHICKEN.price
                    var chicken = Meat(
                        MeatType.CHICKEN,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId()
                    )
                    meatList.add(chicken)
                    animal.notifyAnimalWasProcessed()
                    chicken.attach(Report)
                    chicken.notifyUpdate()
                }

                "Fish" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.FISH.price
                    var fish =
                        Meat(MeatType.FISH, shopPrice, shopPrice * 1.4, 0.7 * animal.getWeight(), animal.getOriginId())
                    meatList.add(fish)
                    animal.notifyAnimalWasProcessed()
                    fish.attach(Report)
                    fish.notifyUpdate()
                }
            }
        }
        return meatList
    }

    /**
     * Proccess animal u s i n g i t e r a t o r
     *
     * @param animals
     * @return
     */
    fun proccessAnimalUSINGITERATOR(animals: AnimalToProcess): ArrayList<Meat> { //ITERATOR
        var meatList = ArrayList<Meat>()

        val iterator: CustomIterator = animals
        while (iterator.hasNext()) {
            val animal: BaseAnimal = iterator.next()
            when (animal.getName()) {
                "Cow" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.BEEF.price
                    var beef = Meat(
                        MeatType.BEEF,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId()
                    )
                    meatList.add(beef)
                    animal.notifyAnimalWasProcessed()
                    beef.attach(Report)
                    beef.notifyUpdate()
                }

                "Pig" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.PORK.price
                    var pork = Meat(
                        MeatType.PORK,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId()
                    )
                    meatList.add(pork)
                    animal.notifyAnimalWasProcessed()
                    pork.attach(Report)
                    pork.notifyUpdate()
                }

                "Chicken" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.CHICKEN.price
                    var chicken = Meat(
                        MeatType.CHICKEN,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId()
                    )
                    meatList.add(chicken)
                    animal.notifyAnimalWasProcessed()
                    chicken.attach(Report)
                    chicken.notifyUpdate()
                }

                "Fish" -> {
                    val shopPrice = 0.7 * animal.getWeight() * MeatType.FISH.price
                    var fish = Meat(
                        MeatType.FISH,
                        shopPrice,
                        shopPrice * 1.4,
                        0.7 * animal.getWeight(),
                        animal.getOriginId()
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