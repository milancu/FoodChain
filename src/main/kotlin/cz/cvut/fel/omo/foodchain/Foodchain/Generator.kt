package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.BaseParty
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.parties.LOCATION_LENGTH
import cz.cvut.fel.omo.foodchain.Foodchain.parties.NAME_LENGTH
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class Generator {

    fun generateAnimal(): BaseAnimal {
        return BaseAnimal(AnimalType.getAnimal())
    }

    fun generateAnimals(): ArrayList<BaseAnimal> {
        var listOfAnimals = ArrayList<BaseAnimal>();

        for (i in 10..(10..50).random()) {
            listOfAnimals.add(generateAnimal())
        }
        return listOfAnimals
    }

    fun generateField(): Field {
        var capacity = (1000..10000).random()
        return Field(generateCrop(capacity), capacity)
    }

    fun generateFields(): ArrayList<Field> {
        var listOfField = ArrayList<Field>();
        for (i in 1..(2..10).random()) {
            listOfField.add(generateField())
        }
        return listOfField
    }

    fun generateCrop(capacity: Int): Crop {
        var crop = CropName.getCropName()
        var type = CropType.getCropType()
        return Crop(crop, type, capacity, 2)
    }

    fun generateCrops(): ArrayList<Crop> {
        var listOfCrop = ArrayList<Crop>();
        for (i in 10..(11..30).random()) {
            listOfCrop.add(generateCrop((1000..10000).random()))
        }
        return listOfCrop
    }

    // TODO nezapomen ze customers maj jako identifikator rodne cislo a ma se prepsat, mozno nepouzit tenhle generator na customera
    fun generateNewParty(): BaseParty {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z')

        val generatedName = (1..NAME_LENGTH)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString { "" };
        val generatedIdentifier = (10000000..99999999).random()
        val generatedLocation = (1..LOCATION_LENGTH)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString { "" } + ", " + (1000..9999).random();
        val generatedMoney = (10000..1000000).random().toDouble();

        return BaseParty(generatedName, generatedIdentifier, generatedLocation, generatedMoney)
    }

    fun generateGrower() : Grower {
        val base : BaseParty = generateNewParty()
        return Grower(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }


}