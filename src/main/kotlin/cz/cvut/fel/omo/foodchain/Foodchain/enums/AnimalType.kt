package cz.cvut.fel.omo.foodchain.Foodchain.enums

import java.util.*

enum class AnimalType(var animalName: String) {

    COW("Cow"),
    PIG("Pig"),
    CHICKEN("Chicken"),
    GOAT("Goat"),
    FISH("Fish"),
    BEE("Bee");

    companion object {
        fun getAnimal(): AnimalType {
            val random = Random()
            return AnimalType.values()[random.nextInt(AnimalType.values().size)]
        }
    }
}





