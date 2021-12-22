package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Butcher
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer

class FarmerToProcessorChannel {

    private var farmers : ArrayList<Farmer>
    val meatFactory : MeatFactory

    constructor(){
        println("PHASE 1.1 - Farmers, buthcers and meaaFactory creation")
        val generator : Generator = Generator()
        this.farmers = generator.generateFarmers(2)
        this.meatFactory = generator.generateFactory()

        println("Farmers: " + farmers.size)
        println()
    }

    fun runSimulation(time :Int){
        for(farmer in farmers){
            print("Priprava ke zpracovani zvirat")
            Request.requestTransportToMeatFactory(farmer, meatFactory, time)
            println("maso zpracovano a pripavano a pripraveno k odvozu")
        }
    }

    fun printStats() {
        println("CURRENT STATE FARMER / MEATFACTORY - CHANNEL")
        for (farmer in farmers) {
            println("farmer: " + farmer.getIdentifier() + " : money : " + farmer.getAmountOfMoney() + " : animals : "
                    + farmer.getNumberOfAnimals() + " : animals to processed : " + farmer.getNumberOfAnimalsToProcess())
        }
        println(
            "MeatFactory: " + meatFactory.getIdentifier() + " : money : " + meatFactory.getAmountOfMoney()
                    + " : resources : " + meatFactory.getMeatResources() + " : prepared : " + meatFactory.getPreparedPorducts()
        )
        println()
    }

    fun getFarmers() : ArrayList<Farmer>{
        return farmers
    }

}