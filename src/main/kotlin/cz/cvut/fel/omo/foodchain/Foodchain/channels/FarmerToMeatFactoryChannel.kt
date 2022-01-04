package cz.cvut.fel.omo.foodchain.Foodchain.channels

import cz.cvut.fel.omo.foodchain.Foodchain.factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer

/**
 * Farmer to meat factory channel
 *
 * @constructor Create empty Farmer to meat factory channel
 */
class FarmerToMeatFactoryChannel : Channel{

    private var farmers : ArrayList<Farmer>
    private val meatFactory : MeatFactory

    init {
        println("PHASE 1.1 - Farmers, buthcers and meaaFactory creation")
        val generator = Generator()
        this.farmers = generator.generateFarmers()
        this.meatFactory = generator.generateFactory()
        println("Farmers: " + farmers.size)
        println()
    }

    override fun runSimulation(){
        for(farmer in farmers){
            print("Priprava ke zpracovani zvirat")
            Request.requestTransportToMeatFactory(farmer, meatFactory)

            println("maso zpracovano a pripavano a pripraveno k odvozu")
            farmer.feedAnimal()
            farmer.growAnimals()
            meatFactory.payDebts()
        }
    }

    override fun printStats() {
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

    /**
     * Get farmers
     *
     * @return
     */
    fun getFarmers() : ArrayList<Farmer>{
        return farmers
    }

    /**
     * Get meat factory
     *
     * @return
     */
    fun getMeatFactory() : MeatFactory{
        return meatFactory
    }

}