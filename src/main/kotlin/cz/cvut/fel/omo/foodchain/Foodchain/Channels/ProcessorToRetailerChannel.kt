package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Config
import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

/**
 * Processor to retailer channel
 *
 * @constructor Create empty Processor to retailer channel
 */
class ProcessorToRetailerChannel : Channel{

    private var processors : ArrayList<Processor>
    private var retailers : ArrayList<Retailer>

    constructor(processors : ArrayList<Processor>){
        println("PHASE 2.0 - Retailers creation")

        val generator : Generator = Generator()

        this.processors = processors
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
            var retailer : Retailer = retailers.get( (0..retailers.size-1).random() )
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