package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.Iterator.AnimalToProcess
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.Meat

/**
 * Farmer
 *
 * @constructor
 *
 * @param subjectName
 * @param location
 * @param amountOfMoney
 */
class Farmer(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    private var resources: ArrayList<Crop> = setInitialResources()
    private var animals: ArrayList<BaseAnimal> = setInitialAnimals()
    private var animalsToProcessing: ArrayList<BaseAnimal> = ArrayList();
    private var unpaidInvoices : ArrayList<Invoice> = ArrayList()
    private val butcher : Butcher = Butcher()
    private val animalToProcess : AnimalToProcess = AnimalToProcess() //ITERATOR

    /**
     * Set initial resources
     *
     * @return
     */
    fun setInitialResources(): ArrayList<Crop> {
        val generator = Generator()
        return generator.generateFeedingForAnimal()
    }

    /**
     * Set initial animals
     *
     * @return
     */
    fun setInitialAnimals(): ArrayList<BaseAnimal> {
        val generator = Generator()
        return generator.generateAnimals()
    }

    /**
     * Decrease resource
     *
     * @param feed
     */
    fun decreaseResource(feed: Crop) {
        for (resource in resources) {
            if (resource.getName() == feed.getName()) {
                val realValue: Int = resource.getAmount() - feed.getAmount();
                resource.setAmount(realValue)
            }
        }
    }

    /**
     * Animals to processing
     *
     * @return
     */
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

    /**
     * Animals to processing u s i n g i t e r a t o r
     *
     * @return
     */
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


    /**
     * Buy new animals
     *
     * @param value
     */
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

    /**
     * Get resources
     *
     * @return
     */
    fun getResources() : ArrayList<Crop>{
        return this.resources
    }

    /**
     * Get animals to processing
     *
     * @return
     */
    fun getAnimalsToProcessing(): ArrayList<BaseAnimal> {
        return this.animalsToProcessing
    }

    /**
     * Call butcher
     *
     * @return
     */
    fun callButcher() : ArrayList<Meat>{
        return butcher.proccessAnimal(animalsToProcessing())
    }

    /**
     * Call butcher u s i n g i t e r a t o r
     *
     * @return
     */
    fun callButcherUSINGITERATOR() : ArrayList<Meat>{ //ITERATOR
        return butcher.proccessAnimalUSINGITERATOR(animalToProcess)
    }

    /**
     * Get number of animals
     *
     * @return
     */
    fun getNumberOfAnimals() : Int{
        return animals.size
    }

    /**
     * Get number of animals to process
     *
     * @return
     */
    fun getNumberOfAnimalsToProcess() : Int{
        return animalsToProcessing.size
    }

    /**
     * Remove used resources
     *
     * @param crops
     */
    fun removeUsedResources(crops : ArrayList<Crop>){
        for(crop in crops){
            resources.remove(crop)
        }
    }

    /**
     * Feed animal
     *
     */
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

    /**
     * Grow animals
     *
     */
    fun growAnimals(){
        for(animal in animals){
            animal.growAnimal()
        }
    }

    /**
     * Need resource
     *
     * @return
     */
    fun needResource() : Boolean{
        if(resources.size != 0) return true
        return false
    }

    /**
     * Take resources
     *
     * @param crop
     */
    fun takeResources(crop : Crop){
        resources.add(crop)
    }

    /**
     * Pay for invoice
     *
     * @param invoice
     */
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

    /**
     * Pay debts
     *
     */
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
