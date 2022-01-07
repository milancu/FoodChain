package cz.cvut.fel.omo.foodchain.Foodchain.channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.statics.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

/**
 * Processor to retailer channel
 *
 * @constructor Create empty Processor to retailer channel
 */
class ProcessorToRetailerChannel(private var processors: ArrayList<Processor>) : Channel{

    private var retailers : ArrayList<Retailer>

    init {
        println("PHASE 2.0 - Retailers creation")
        val generator = Generator()
        this.retailers = generator.generateRetailers()
        println("Processors: " + processors.size)
        println("Retailers: " + retailers.size)
        println()
    }

    override fun printStats(){
        println("CURRENT STATE PROCESSOR / RETAILER - CHANNEL")
        for(processor in processors){
            println("Processor: " + processor.getIdentifier() + " : money : " + processor.getAmountOfMoney()
                    + " : supplies : " + processor.getStockSuppliesSize() + " : products : " + processor.getStockProductsSize())
        }
        for(retailer in retailers){
            println("Retailer: " + retailer.getIdentifier() + " : money : " + retailer.getAmountOfMoney()
                    + " : available products : " + retailer.getStockSize() + " : warehouseProducts : " + retailer.getWarehouseStockSize())
        }
        println()
    }

    override fun runSimulation(){
        for(processor in processors){
            val retailer : Retailer = retailers[(0 until retailers.size).random()]
            Request.requestTransportToWarehouse(processor, retailer)
            println("Priprava k vytvareni vyrobku")
            processor.processProduct()
            println("Produkty vytvoreny")
            retailer.payDebts()
        }
    }


    /**
     * Get retailers
     *
     * @return
     */
    fun getRetailers() : ArrayList<Retailer>{
        return retailers
    }

    /**
     * Add retailer
     *
     * @param retailer
     */
    fun addRetailer(retailer: Retailer){
        retailers.add(retailer)
    }
}