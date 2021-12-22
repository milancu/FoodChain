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
    private var animalsToProcessing: ArrayList<BaseAnimal> = animalsToProcessing();
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

        // TODO vyhazovani z listu
        animals.toList().iterator().forEach { animal ->
            when (animal.getName()) {
                "Cow" -> if (animal.getAge() > 30) animalsToProcessing.add(animal)
                "Pig" -> if (animal.getAge() > 20) animalsToProcessing.add(animal)
                "Chicken" -> if (animal.getAge() > 10) animalsToProcessing.add(animal)
                "Goat" -> if (animal.getAge() > 15) animalsToProcessing.add(animal)
                "Fish" -> if (animal.getAge() > 5) animalsToProcessing.add(animal)
            }
        }

        // TODO otestovat
        animals.toMutableList().removeAll(animalsToProcessing)

        return animalsToProcessing
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

    fun feedAnimal(){ // todo do requestu
        var feeded : Boolean = false
        for(animal in animals){
            for(crop in resources){
                if(crop.getAmount() >= 5){
                    feeded = true
                    crop.decreaseAmount()
                    break
                }
            }
            if(feeded){ animal.increaseWeight() }
            else { animal.decreaseWeight() }

            controlResources()
            animal.growAnimal()
        }
    }

    // todo nakup cropu od growera

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