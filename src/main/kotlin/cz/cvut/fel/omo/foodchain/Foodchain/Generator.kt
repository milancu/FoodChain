package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.animals.*
import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.*
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import kotlin.random.Random.Default.nextInt

class Generator {

    public fun generateAnimal(): BaseAnimal {
        var animal = BaseAnimal(AnimalType.getAnimal())
        animal.attach(Report)
        return animal
    }

    public fun generateAnimals(): ArrayList<BaseAnimal> {
        var listOfAnimals = ArrayList<BaseAnimal>();

        for (i in 1..(Config.ANIMALS_MIN..Config.ANIMALS_MAX).random()) {
            listOfAnimals.add(generateAnimal())
        }
        return listOfAnimals
    }

    private fun generateField(): Field {
        var capacity = (Config.FIELD_CAPACITY_MIN..Config.FIELD_CAPACITY_MAX).random()
        val field = Field(generateCrop(capacity), capacity)
        field.attach(Report)
        return field
    }

    public fun generateFields(): ArrayList<Field> {
        var listOfField = ArrayList<Field>();
        for (i in 1..(Config.MIN_FIELDS..Config.MAX_FIELDS).random()) {
            listOfField.add(generateField())
        }
        return listOfField
    }

    private fun generateCrop(capacity: Int): Crop {
        var cropName = CropName.getCropName()
        var type = setType(cropName)
        var growthTime = (0..Config.FLOWER_MAX_AGE).random()
        var crop = Crop(cropName, type, capacity, growthTime)
        crop.attach(Report)
        return crop
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
        for (i in 1..(Config.MIN_DEAFAULT_CROPTYPES..Config.MAX_DEFAULT_CROPTYPES).random()) {
            listOfCrop.add(generateCrop((Config.MIN_DEFAULT_CROPS..Config.MAX_DEFAULT_CROPS).random()))
        }
        return listOfCrop
    }

    // TODO nezapomen ze customers maj jako identifikator rodne cislo a ma se prepsat, mozno nepouzit tenhle generator na customera
    private fun generateNewParty(): BaseParty {
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z')

        val generatedName = (1..Config.NAME_LENGTH)
            .map { charPool.random() }
            .joinToString("")
        val generatedLocation = (1..Config.LOCATION_LENGTH)
            .map { charPool.random() }
            .joinToString("") + ", " + (1000..9999).random()
        val generatedMoney = (Config.FINANCE_MIN..Config.FINANCE_MAX).random().toDouble();

        return BaseParty(generatedName, generatedLocation, generatedMoney)
    }

    private fun generateCustomer() : Customer{
        val base: BaseParty = generateNewParty()
        val money : Double = (Config.SALARY_MIN..Config.SALARY_MAX).random().toDouble()
        return Customer(base.getSubjectName(), base.getLocation(), money)
    }

    private fun generateCustomers() : ArrayList<Customer>{
        val customers: ArrayList<Customer> = ArrayList()
        for (i in 1..Config.CUSTOMERS) {
            customers.add(generateCustomer())
        }
        return customers;
    }

    private fun generateFarmer(): Farmer {
        val base: BaseParty = generateNewParty()
        return Farmer(base.getSubjectName(), base.getLocation(), base.getAmountOfMoney())
    }

    private fun generateGrower(): Grower {
        val base: BaseParty = generateNewParty()
        return Grower(base.getSubjectName(), base.getLocation(), base.getAmountOfMoney())
    }

    private fun generateProcessor(): Processor {
        val base: BaseParty = generateNewParty()
        return Processor(base.getSubjectName(), base.getLocation(), base.getAmountOfMoney())
    }

    private fun generateRetailer(): Retailer {
        val base: BaseParty = generateNewParty();
        return Retailer(base.getSubjectName(), base.getLocation(), base.getAmountOfMoney())
    }

    public fun generateFactory() : MeatFactory{
        val base: BaseParty = generateNewParty()
        return MeatFactory(base.getSubjectName(), base.getLocation(), base.getAmountOfMoney())
    }

    public fun generateGrowers(): ArrayList<Grower> {
        val growers: ArrayList<Grower> = ArrayList()
        for (i in 1..Config.GROWERS) {
            growers.add(generateGrower())
        }
        return growers;
    }

    public fun generateFarmers(): ArrayList<Farmer> {
        val farmers: ArrayList<Farmer> = ArrayList()
        for (i in 1..Config.FARMERS) {
            farmers.add(generateFarmer())
        }
        return farmers;
    }

    public fun generateProcessors(): ArrayList<Processor> {
        val processors: ArrayList<Processor> = ArrayList()
        for (i in 1..Config.PROCESSORS) {
            processors.add(generateProcessor())
        }
        return processors
    }

    public fun generateRetailers(): ArrayList<Retailer> {
        val retailers: ArrayList<Retailer> = ArrayList()
        for (i in 1..Config.RETAILERS) {
            retailers.add(generateRetailer())
        }
        return retailers
    }
}