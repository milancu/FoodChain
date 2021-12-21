package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Farmer(subjectName: String, identier: Int, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, identier, location, amountOfMoney) {

    private var resources: List<Crop> = setInitialResources()

    private var animals: List<BaseAnimal> = setInitialAnimals()

    private var animalsToProcessing: List<BaseAnimal> = animalsToProcessing();

    fun setInitialResources(): List<Crop> {
        val generator = Generator()
        return generator.generateCrops()
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

    fun animalsToProcessing(): List<BaseAnimal> {
        val animalsToProcessing = ArrayList<BaseAnimal>()

        animals.toList().iterator().forEach { animal ->
            when (animal.getName()) {
                "Cow" -> if (animal.getAge() > 3) animalsToProcessing.add(animal)
                "Pig" -> if (animal.getAge() > 3) animalsToProcessing.add(animal)
                "Chicken" -> if (animal.getAge() > 2) animalsToProcessing.add(animal)
                "Goat" -> if (animal.getAge() > 4) animalsToProcessing.add(animal)
                "Fish" -> if (animal.getAge() > 1) animalsToProcessing.add(animal)
            }
        }
        return animalsToProcessing
    }

    fun getResources() : List<Crop>{
        return this.resources
    }

    fun getAnimalsToProcessing(): List<BaseAnimal> {
        return this.animalsToProcessing
    }
}