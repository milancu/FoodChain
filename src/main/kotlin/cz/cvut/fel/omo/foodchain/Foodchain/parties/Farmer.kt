package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Farmer(subjectName: String, identier: Int, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, identier, location, amountOfMoney) {

    var resources: List<Crop> = setInitialResources()

    var animals: List<BaseAnimal> = setInitialAnimals()

    fun setInitialResources(): List<Crop> {
        var initialResources: List<Crop> = TODO()
        // TODO podle potravin
        return initialResources
    }

    fun setInitialAnimals(): List<BaseAnimal> {
        val generator = Generator()
        return generator.generateAnimals()
    }

    fun decreaseResource(feed: Crop) {
        for (resource in resources) {
            if (resource.getName() == feed.getName()) {
                val realValue: Int = resource.getAmount() - feed.getAmount();
                resource.setAmount(realValue)
            }
        }
    }


}