package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.Iterator.AnimalToProcess
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

class Farmer(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    private var resources: ArrayList<Crop> = setInitialResources()
    private var animals: ArrayList<BaseAnimal> = setInitialAnimals()
    private var animalsToProcessing: ArrayList<BaseAnimal> = ArrayList();
    private var unpaidInvoices : ArrayList<Invoice> = ArrayList()

    @Autowired
    private val butcher : Butcher = Butcher()

    @Autowired
    private val animalToProcess : AnimalToProcess = AnimalToProcess() //ITERATOR

    fun setInitialResources(): ArrayList<Crop> {
        val generator = Generator()
        return generator.generateFeedingForAnimal()
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
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Pig" -> {
                    if (animal.getAge() > 20) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Chicken" -> {
                    if (animal.getAge() > 10) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Goat" -> {
                    if (animal.getAge() > 15) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Fish" -> {
                    if (animal.getAge() > 5) {
                        animalsToProcessing.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
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

    fun animalsToProcessingUSINGITERATOR(): AnimalToProcess { //ITERATOR
        animals.iterator().forEach { animal ->
            when (animal.getName()) {
                "Cow" -> {
                    if (animal.getAge() > 30) {
                        animalToProcess.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Pig" -> {
                    if (animal.getAge() > 20) {
                        animalToProcess.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Chicken" -> {
                    if (animal.getAge() > 10) {
                        animalToProcess.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Goat" -> {
                    if (animal.getAge() > 15) {
                        animalToProcess.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
                "Fish" -> {
                    if (animal.getAge() > 5) {
                        animalToProcess.add(animal)
                        animal.notifyAnimalWasMoveToProcess()
                    }
                }
            }
        }

        println("Aktualni pocet zvirat : " + animals.size)
        println("Na jatka bylo poslano : " + animalToProcess.getSize() + " zvirat")
        animals.removeAll(animalToProcess.getAnimalList())
        println("Aktualni pocet zvirat : " + animals.size)
        buyNewAnimals(animalToProcess.getSize())
        println("Po dokoupeni pocet zvirat : " + animals.size)

        return animalToProcess
    }


    fun buyNewAnimals(value : Int){
        val generator : Generator = Generator()
        if(value != 0) {
            for (i in (1..value)) {
                val newAnimal: BaseAnimal = generator.generateAnimal()
                animals.add(newAnimal)
                this.amountOfMoney -= newAnimal.getWeight()
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

    fun callButcherUSINGITERATOR() : ArrayList<Meat>{ //ITERATOR
        return butcher.proccessAnimalUSINGITERATOR(animalToProcess)
    }

    fun getNumberOfAnimals() : Int{
        return animals.size
    }

    fun getNumberOfAnimalsToProcess() : Int{
        return animalsToProcessing.size
    }

    fun removeUsedResources(crops : ArrayList<Crop>){
        for(crop in crops){
            resources.remove(crop)
        }
    }

    fun feedAnimal(){
        var feeded : Boolean = false
        for(animal in animals){
            var toRemove : ArrayList<Crop> = ArrayList()
            for (crop in resources) {
                if (crop.getAmount() >= 5) {
                    feeded = true
                    crop.decreaseAmount()
                    break
                } else {
                    toRemove.add(crop)
                }
            }
            removeUsedResources(toRemove)

            if(feeded){
                animal.increaseWeight()
                println("Zvire " + animal.getName() + " " + animal.getOriginId() + " bylo nakrmeno")
            }
            else {
                println("Zvire " + animal.getName() + " " + animal.getOriginId() + " ZUSTALO o hladu, potrebuje dokoupit zasoby")
                animal.decreaseWeight()
            }
        }
    }

    fun growAnimals(){
        for(animal in animals){
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
            invoice.payInvoice()
            invoice.notifyPaid()
        } else {
            unpaidInvoices.add(invoice)
            println("!Faktura " + invoice.getCode() + " NENI uhrazena")
            invoice.notifyUnpaid()
        }
        println()
    }

    fun payDebts() {
        var toRemove: ArrayList<Invoice> = ArrayList()
        for (invoice in unpaidInvoices) {
            if (amountOfMoney >= invoice.getPrice()) {
                toRemove.add(invoice)
                invoice.payInvoice()
                invoice.notifyPaid()
                amountOfMoney -= invoice.getPrice()
            }
        }
        for (invoice in toRemove) {
            println("Penize za " + invoice.getCode() + " splaceny")
            unpaidInvoices.remove(invoice)
        }
    }
}
