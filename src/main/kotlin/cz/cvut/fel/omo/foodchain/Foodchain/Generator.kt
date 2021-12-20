package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Generator {

    fun generateAnimal() : BaseAnimal {
        return BaseAnimal(AnimalType.getAnimal())
    }

    fun generateListOfAnimals(): List<BaseAnimal> {
        var listOfAnimals: List<BaseAnimal> = emptyList();

        for (i in 10..(10..50).random()) {
            listOfAnimals.toMutableList().add(generateAnimal())
        }
        return listOfAnimals
    }

    fun generateField() : Field{
        var capacity = (1000..10000).random()
        return Field(generateCrop(capacity), capacity)
    }

    fun generateFields() : List<Field>{
        var listOfField : List<Field> = emptyList();
        for (i in 1..(2..10).random()) {
            listOfField.toMutableList().add(generateField())
        }
        return listOfField
    }

    fun generateCrop(capacity : Int) : Crop {
        var crop = CropName.getCropName()
        return Crop(crop, capacity, 2)
    }

    fun generateCrops() : List<Crop>{
        var listOfCrop : List<Crop> = emptyList();
        for (i in 10..(11..30).random()) {
            listOfCrop.toMutableList().add(generateCrop((1000..10000).random()))
        }
        return listOfCrop
    }
}