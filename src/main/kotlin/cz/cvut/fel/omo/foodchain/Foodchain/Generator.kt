package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Generator {

    fun generateAnimal() : BaseAnimal {
        return BaseAnimal(AnimalType.getAnimal())
    }

    fun generateAnimals(): ArrayList<BaseAnimal> {
        var listOfAnimals = ArrayList<BaseAnimal>();

        for (i in 10..(10..50).random()) {
            listOfAnimals.add(generateAnimal())
        }
        return listOfAnimals
    }

    fun generateField() : Field{
        var capacity = (1000..10000).random()
        return Field(generateCrop(capacity), capacity)
    }

    fun generateFields() : ArrayList<Field>{
        var listOfField = ArrayList<Field>();
        for (i in 1..(2..10).random()) {
            listOfField.add(generateField())
        }
        return listOfField
    }

    fun generateCrop(capacity : Int) : Crop {
        var crop = CropName.getCropName()
        return Crop(crop, capacity, 2)
    }

    fun generateCrops() : ArrayList<Crop>{
        var listOfCrop = ArrayList<Crop>();
        for (i in 10..(11..30).random()) {
            listOfCrop.add(generateCrop((1000..10000).random()))
        }
        return listOfCrop
    }
}