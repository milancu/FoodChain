package cz.cvut.fel.omo.foodchain.Foodchain.enums

import java.util.*

enum class AnimalType(var weight: Double, var foodConsumption: Int, var age: Int, var price: Double) {
    COW((150000..600000).random().toDouble(), (7..10).random(), (1..10).random(), 1000.00),
    PIG((300000..700000).random().toDouble(), (6..10).random(), (1..10).random(), 800.00),
    CHICKEN((400..1000).random().toDouble(), (1..3).random(), (1..3).random(), 100.00),
    GOAT((300000..700000).random().toDouble(), (5..8).random(), (1..10).random(), 900.00),
    FISH((500..3000).random().toDouble(), (1..3).random(), (1..10).random(), 500.00),
    BEE((1..10).random().toDouble(), 1, (1..10).random(), 500.00);

    companion object {
        fun getAnimal(): AnimalType {
            val random = Random()
            return AnimalType.values()[random.nextInt(AnimalType.values().size)]
        }
    }
}