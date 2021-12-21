package cz.cvut.fel.omo.foodchain.Foodchain.enums

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
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





