package cz.cvut.fel.omo.foodchain.Foodchain.enums

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
enum class AnimalType(@Value("\${animal.name}") var animalName: String) {
    @Autowired
    COW("Cow"),
    @Autowired
    PIG("Pig"),
    @Autowired
    CHICKEN("Chicken"),
    @Autowired
    GOAT("Goat"),
    @Autowired
    FISH("Fish"),
    @Autowired
    BEE("Bee");

    companion object {
        fun getAnimal(): AnimalType {
            val random = Random()
            return AnimalType.values()[random.nextInt(AnimalType.values().size)]
        }
    }
}





