package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Butcher
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer

class FarmerToProcessorChannel {

    private var farmers : ArrayList<Farmer>
    //private var butcher : ArrayList<Butcher> //TODO get(0) - udelat typciska jako solo pro svy farmare / odsud pak odstranit
    //private var meatFactory : ArrayList<MeatFactory> //TODO get(0) / generator add
    val butcher : Butcher
    val meatFactory : MeatFactory

    constructor(){
        println("PHASE 1.1 - Farmers, buthcers and meaaFactory creation")
        val generator : Generator = Generator()
        this.farmers = generator.generateFarmers(2)
        this.butcher = Butcher()
        this.meatFactory = MeatFactory()

        println("Farmers: " + farmers.size)
        println()
    }

    fun runSimulation(){ // todo copypaste
        for(farmer in farmers){
            Request.requestTransportToMeatFactory(farmer, meatFactory)
            println("Priprava k vytvareni vyrobku")
            processor.processProduct()
            println("Produkty vytvoreny")
        }
    }




}