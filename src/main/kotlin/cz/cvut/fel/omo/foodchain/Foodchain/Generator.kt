package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.*
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import kotlin.random.Random.Default.nextInt


const val FINANCE_MIN = 1000000
const val FINANCE_MAX = 10000000
const val IDENTIFIER_MIN = 10000000
const val IDENTIFIER_MAX = 99999999

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

        val generatedName = (1..NAME_LENGTH) //TODO NEFUNGUJE GENEROVANI NAZVU
            .map { i -> nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString { "" };
        val generatedIdentifier = (IDENTIFIER_MIN..IDENTIFIER_MAX).random()
        val generatedLocation = (1..LOCATION_LENGTH) //TODO NEFUNGUJE GENEROVANI NAZVU
            .map { i -> nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString { "" } + ", " + (1000..9999).random();
        val generatedMoney = (FINANCE_MIN..FINANCE_MAX).random().toDouble();

        return BaseParty(generatedName, generatedIdentifier, generatedLocation, generatedMoney)
    }

    fun generateGrower() : Grower {
        val base : BaseParty = generateNewParty()
        return Grower(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }

    fun generateGrowers(number : Int) : ArrayList<Grower>{
        var growers : ArrayList<Grower> = ArrayList()
        for(i in 1..number){
            growers.add(generateGrower())
        }
        return growers;
    }

    fun generateProcessor() : Processor {
        val base : BaseParty = generateNewParty()
        return Processor(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }

    fun generateProcessors(number : Int) : ArrayList<Processor>{
        var processors : ArrayList<Processor> = ArrayList()
        for(i in 1..number){
            processors.add(generateProcessor())
        }
        return processors
    }

    fun generateRetailer() : Retailer{
        val base : BaseParty = generateNewParty();
        return Retailer(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }

    fun generateRetailers(number : Int) : ArrayList<Retailer>{
        var retailers : ArrayList<Retailer> = ArrayList()
        for(i in 1..number){
            retailers.add(generateRetailer())
        }
        return retailers
    }


}