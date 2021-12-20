package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Generator {

    fun generateListOfAnimals(): List<BaseAnimal> {
        var listOfAnimals: List<BaseAnimal> = emptyList();

        for (i in 10..(10..50).random()) {
            var randomIndex = (1..6).random();
            when (randomIndex) {
                1 -> listOfAnimals.toMutableList().add(Chicken((400..1000).random().toDouble(),1, (1..3).random(), 100.toDouble()))
                2 -> listOfAnimals.toMutableList().add(Cow((150000..600000).random().toDouble(),10, (1..10).random(), 1000.toDouble()))
                3 -> listOfAnimals.toMutableList().add(Fish((500..3000).random().toDouble(),2, (1..10).random(), 100.toDouble()))
                4 -> listOfAnimals.toMutableList().add(Goat((300000..700000).random().toDouble(),4, (1..10).random(), 1000.toDouble()))
                5 -> listOfAnimals.toMutableList().add(Pig((300000..700000).random().toDouble(),4, (1..10).random(), 1000.toDouble()))
                6 -> listOfAnimals.toMutableList().add(Sheep((300000..700000).random().toDouble(),4, (1..10).random(), 1000.toDouble()))
            }
        }

        return listOfAnimals
    }

    fun generateField() : Field{
        return TODO()
    }

    fun generateFields() : List<Field>{
        //random od 1..10
        return TODO()
    }

    fun generateCrop() : Crop {
        return TODO()
    }

    fun generateCrops() : List<Crop>{
        //random 10..30
        return TODO();
    }
}