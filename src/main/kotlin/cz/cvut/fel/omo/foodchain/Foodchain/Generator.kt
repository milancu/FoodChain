package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.animals.Chicken

class Generator {

    fun generateListOfAnimals(): List<BaseAnimal> {
        var listOfAnimals: List<BaseAnimal> = emptyList();

        for (i in 10..(10..50).random()) {
            var randomIndex = (1..6).random();
            when (randomIndex) {
                1 -> print("Chicken")
                    var chicken = Chicken((400..1000).random(), ,1, (1..3).random(), 100)
                2 -> print("Cow")
                3 -> print("Fish")
                4 -> print("Goat")
                5 -> print("Pig")
                6 -> print("Sheep")
            }
        }

        return listOfAnimals
    }
}