package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat

class Farmer(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    private var resources: ArrayList<Crop> = setInitialResources()
    private var animals: ArrayList<BaseAnimal> = setInitialAnimals()
    private var animalsToProcessing: ArrayList<BaseAnimal> = ArrayList();
    private var unpaidInvoices : ArrayList<Invoice> = ArrayList()
    private val butcher : Butcher = Butcher()

    fun setInitialResources(): ArrayList<Crop> {
        val generator = Generator()
        return generator.generateCrops()
    }

    fun setInitialAnimals(): ArrayList<BaseAnimal> {
        val generator = Generator()
        return generator.generateAnimals()
    }

    fun decreaseResource(feed: Crop) {
        for (resource in resources) {
            if (resource.getName() == feed.getName()) {
                val realValue: Int = resource.getAmount() - feed.getAmount();
                resource.setAmount(realValue)
            }
        }
    }

    fun animalsToProcessing(): ArrayList<BaseAnimal> {
        val animalsToProcessing = ArrayList<BaseAnimal>()

        animals.iterator().forEach { animal ->
            when (animal.getName()) {
                "Cow" -> {
                    if (animal.getAge() > 30) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalMoveToProcess()
                    }
                }
                "Pig" -> {
                    if (animal.getAge() > 20) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalMoveToProcess()
                    }
                }
                "Chicken" -> {
                    if (animal.getAge() > 10) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalMoveToProcess()
                    }
                }
                "Goat" -> {
                    if (animal.getAge() > 15) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalMoveToProcess()
                    }
                }
                "Fish" -> {
                    if (animal.getAge() > 5) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalMoveToProcess()
                    }
                }
            }
        }

        println("Aktualni pocet zvirat : " + animals.size)
        println("Na jatka bylo poslano : " + animalsToProcessing.size + " zvirat")
        animals.removeAll(animalsToProcessing)
        println("Aktualni pocet zvirat : " + animals.size)
        buyNewAnimals(animalsToProcessing.size)
        println("Po dokoupeni pocet zvirat : " + animals.size)

        return animalsToProcessing
    }

    fun buyNewAnimals(value : Int){
        val generator : Generator = Generator()
        if(value != 0) {
            for (i in (1..value)) {
                val newAnimal: BaseAnimal = generator.generateAnimal()
                animals.add(newAnimal)
                this.amountOfMoney -= newAnimal.getWeight() // todo letmej typ
            }
        }
    }

    fun getResources() : ArrayList<Crop>{
        return this.resources
    }

    fun getAnimalsToProcessing(): ArrayList<BaseAnimal> {
        return this.animalsToProcessing
    }

    fun callButcher() : ArrayList<Meat>{
        return butcher.proccessAnimal(animalsToProcessing())
    }

    fun getNumberOfAnimals() : Int{
        return animals.size
    }

    fun getNumberOfAnimalsToProcess() : Int{
        return animalsToProcessing.size
    }

    fun controlResources(){
        for(crop in resources){
            if(crop.getAmount() <= 5){
                resources.remove(crop)
            }
        }
    }

    fun feedAnimal(){
        var feeded : Boolean = false
        for(animal in animals){
            for(crop in resources){
                if(crop.getAmount() >= 5){
                    feeded = true
                    crop.decreaseAmount()
                    break
                }
            }
            if(feeded){
                animal.increaseWeight()
                println("Zvire " + animal.getName() + animal.getOriginId() + " bylo nakrmeno")
            }
            else {
                println("Zvire " + animal.getName() + animal.getOriginId() + " ZUSTALO o hladu, potrebuje dokoupit zasoby")
                animal.decreaseWeight()
            }

            controlResources()
            animal.growAnimal()
        }
    }

    fun needResource() : Boolean{
        if(resources.size != 0) return true
        return false
    }

    fun takeResources(crop : Crop){
        resources.add(crop)
    }

    fun payForInvoice(invoice : Invoice){
        if (amountOfMoney >= invoice.getPrice()) {
            invoice.getContractor().takeMoney(invoice.getPrice())
            amountOfMoney -= invoice.getPrice()
            println("Faktura " + invoice.getCode() + " zaplacena")
            invoice.notifyPaidInvoice()
        } else {
            unpaidInvoices.add(invoice)
            println("!Faktura " + invoice.getCode() + " NENI uhrazena")
            invoice.notifyUnpaidInvoice()
        }
        println()
    }
}