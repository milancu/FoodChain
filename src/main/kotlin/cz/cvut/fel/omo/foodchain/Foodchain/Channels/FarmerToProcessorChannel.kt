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

    fun runSimulation(){ // todo copypaste
        for(farmer in farmers){
            print("Priprava ke zpracovani zvirat")
            Request.requestTransportToMeatFactory(farmer, meatFactory)
            println("maso zpracovano a pripavano a pripraveno k odvozu")
        }
    }




}