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

    private fun generateAnimal(): BaseAnimal {
        return BaseAnimal(AnimalType.getAnimal())
    }

    public fun generateAnimals(): ArrayList<BaseAnimal> {
        var listOfAnimals = ArrayList<BaseAnimal>();

        for (i in 10..(10..50).random()) {
            listOfAnimals.add(generateAnimal())
        }
        return listOfAnimals
    }

    private fun generateField(): Field {
        var capacity = (1000..10000).random()
        return Field(generateCrop(capacity), capacity)
    }

    public fun generateFields(): ArrayList<Field> {
        var listOfField = ArrayList<Field>();
        for (i in 1..(2..10).random()) {
            listOfField.add(generateField())
        }
        return listOfField
    }

    private fun generateCrop(capacity: Int): Crop {
        var crop = CropName.getCropName()
        var type = setType(crop)
        return Crop(crop, type, capacity, 2)
    }

    private fun setType(name: CropName): CropType {
        when (name) {
            CropName.APPLE -> return CropType.FRUIT
            CropName.BARLEY -> return CropType.CEREAL
            CropName.BEAN -> return CropType.LEGUMES
            CropName.CORN -> return CropType.CEREAL
            CropName.CUCCUMBER -> return CropType.VEGETABLE
            CropName.CHERRIES -> return CropType.FRUIT
            CropName.FLEX -> return CropType.FLOWER
            CropName.GRAPEVINE -> return CropType.FRUIT
            CropName.HEMP -> return CropType.FLOWER
            CropName.HOP -> return CropType.CEREAL
            CropName.LENTIL -> return CropType.LEGUMES
            CropName.OATS -> return CropType.CEREAL
            CropName.OILSEED -> return CropType.FLOWER
            CropName.ONION -> return CropType.VEGETABLE
            CropName.PEAR -> return CropType.FRUIT
            CropName.PLUMS -> return CropType.FRUIT
            CropName.POPPY -> return CropType.FLOWER
            CropName.POTATO -> return CropType.FRUIT
            CropName.RYE -> return CropType.CEREAL
            CropName.SALAD -> return CropType.VEGETABLE
            CropName.SUGARBEAT -> return CropType.VEGETABLE
            CropName.SUNFLOWER -> return CropType.FLOWER
            CropName.TOMATO -> return CropType.VEGETABLE
            CropName.WHEET -> return CropType.CEREAL
        }
    }

    public fun generateCrops(): ArrayList<Crop> {
        var listOfCrop = ArrayList<Crop>();
        for (i in 10..(11..30).random()) {
            listOfCrop.add(generateCrop((1000..10000).random()))
        }
        return listOfCrop
    }

    // TODO nezapomen ze customers maj jako identifikator rodne cislo a ma se prepsat, mozno nepouzit tenhle generator na customera
    private fun generateNewParty(): BaseParty {
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

    private fun generateFarmer(): Farmer {
        val base: BaseParty = generateNewParty()
        return Farmer(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }

    private fun generateGrower(): Grower {
        val base: BaseParty = generateNewParty()
        return Grower(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }

    private fun generateProcessor(): Processor {
        val base: BaseParty = generateNewParty()
        return Processor(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }

    private fun generateRetailer(): Retailer {
        val base: BaseParty = generateNewParty();
        return Retailer(base.getSubjectName(), base.getIdentifier(), base.getLocation(), base.getAmountOfMoney())
    }

    public fun generateGrowers(number: Int): ArrayList<Grower> {
        var growers: ArrayList<Grower> = ArrayList()
        for (i in 1..number) {
            growers.add(generateGrower())
        }
        return growers;
    }

    public fun generateFarmers(number: Int): ArrayList<Farmer> {
        var farmers: ArrayList<Farmer> = ArrayList()
        for (i in 1..number) {
            farmers.add(generateFarmer())
        }
        return farmers;
    }

    public fun generateProcessors(number: Int): ArrayList<Processor> {
        var processors: ArrayList<Processor> = ArrayList()
        for (i in 1..number) {
            processors.add(generateProcessor())
        }
        return processors
    }

    public fun generateRetailers(number: Int): ArrayList<Retailer> {
        var retailers: ArrayList<Retailer> = ArrayList()
        for (i in 1..number) {
            retailers.add(generateRetailer())
        }
        return retailers
    }
}