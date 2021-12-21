package cz.cvut.fel.omo.foodchain.Foodchain.animals

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import java.util.*


open class BaseAnimal : Subject {
    private var observers: List<Observer> = ArrayList()

    private var weight: Double // TODO val podle toho, jestli budeme pracovat s vyvojem zvirete
    private var feed: CropType
    private var foodConsumption: Int
    private var age: Int
    private var price: Double
    private var animalName: String
    private var animalType: AnimalType
    private var origin: UUID

    constructor(animalType: AnimalType) {
        when (animalType) {
            AnimalType.COW -> {
                this.weight = (150000..600000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (7..10).random()
                this.age = (1..10).random()
                this.price = 1000.00
                this.animalName = "Cow"
                this.animalType = animalType
                this.origin = UUID.randomUUID()
                notifyUpdate(origin, "Krava")
            }
            AnimalType.PIG -> {
                this.weight = (150000..600000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (6..10).random()
                this.age = (1..7).random()
                this.price = 8000.00
                this.animalName = "Pig"
                this.animalType = animalType
                this.origin = UUID.randomUUID()
                notifyUpdate(origin, "Krava")
            }
            AnimalType.CHICKEN -> {
                this.weight = (1500..3000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (1..3).random()
                this.age = (1..3).random()
                this.price = 100.00
                this.animalName = "Chicken"
                this.animalType = animalType
                this.origin = UUID.randomUUID()
                notifyUpdate(origin, "Krava")
            }
            AnimalType.GOAT -> {
                this.weight = (150000..400000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (5..8).random()
                this.age = (1..10).random()
                this.price = 900.00
                this.animalName = "Goat"
                this.animalType = animalType
                this.origin = UUID.randomUUID()
                notifyUpdate(origin, "Krava")
            }
            AnimalType.FISH -> {
                this.weight = (1500..6000).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = (1..5).random()
                this.age = (1..10).random()
                this.price = 1000.00
                this.animalName = "Fish"
                this.animalType = animalType
                this.origin = UUID.randomUUID()
                notifyUpdate(origin, "Krava")
            }
            AnimalType.BEE -> {
                this.weight = (1..15).random().toDouble()
                this.feed = CropType.CEREAL
                this.foodConsumption = 1
                this.age = (1..10).random()
                this.price = 1000.00
                this.animalName = "Bee"
                this.animalType = animalType
                this.origin = UUID.randomUUID()
                notifyUpdate(origin, "Krava")
            }
            else -> throw Exception("unexpected type")
        }
    }

    // funkce eat
    fun eatFeed(owner: Farmer, feed: Crop) {
        for (resource in owner.getResources()) {
            if (resource.getName() == feed.getName() && resource.getAmount() >= feed.getAmount()) {
                owner.decreaseResource(feed)
            }
        }
        println("Dej jim nazrat vole, nemas zasoby hajzle")
    }

    fun getAge(): Int {
        return this.age
    }

    fun getWeight(): Double {
        return this.weight
    }

    fun getName(): String {
        return this.animalName
    }

    fun getOriginId(): UUID {
        return this.origin
    }

    override fun attach(o: Observer) {
        observers.toMutableList().add(o)
    }

    override fun detach(o: Observer) {
        observers.toMutableList().remove(o)
    }

    override fun notifyUpdate(uuid: UUID, report: String) {
        for(i in observers){
            i.update(uuid, report)
        }
    }

}