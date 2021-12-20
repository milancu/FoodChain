package cz.cvut.fel.omo.foodchain.Foodchain.animals

import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

open class BaseAnimal {
    var weight: Double // TODO val podle toho, jestli budeme pracovat s vyvojem zvirete
    private var feed: CropType
    private var foodConsumption: Int
    private var age: Int
    private var price: Double
    var animalName: String

    constructor(animalType: AnimalType) {
        when (animalType.animalName) {
            "Cow" -> {
                this.weight = (150000..600000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (7..10).random()
                this.age = (1..10).random()
                this.price = 1000.00
                this.animalName = "Cow"
            }
            "Pig" -> {
                this.weight = (150000..600000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (6..10).random()
                this.age = (1..7).random()
                this.price = 8000.00
                this.animalName = "Pig"
            }
            "Chicken" -> {
                this.weight = (1500..3000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (1..3).random()
                this.age = (1..3).random()
                this.price = 100.00
                this.animalName = "Chicken"
            }
            "Goat" -> {
                this.weight = (150000..400000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (5..8).random()
                this.age = (1..10).random()
                this.price = 900.00
                this.animalName = "Goat"
            }
            "Fish" -> {
                this.weight = (1500..6000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (1..5).random()
                this.age = (1..10).random()
                this.price = 1000.00
                this.animalName = "Fish"
            }
            "Bee" -> {
                this.weight = (1..15).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = 1
                this.age = (1..10).random()
                this.price = 1000.00
                this.animalName = "Bee"
            }
            else -> {
                this.weight = (150000..600000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (7..10).random()
                this.age = (1..10).random()
                this.price = 1000.00
                this.animalName = ""
            }
        }
    }

    // funkce eat
    fun eatFeed(owner: Farmer, feed: Crop) {
        for (resource in owner.resources) {
            if (resource.getName() == feed.getName() && resource.getAmount() >= feed.getAmount()) {
                owner.decreaseResource(feed)
            }
        }
        println("Dej jim nazrat vole, nemas zasoby hajzle")
    }


}