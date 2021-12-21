package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

class ProcessorToRetailerChannel {

    private var processors : ArrayList<Processor>
    private var retailers : ArrayList<Retailer>

    constructor(processors : ArrayList<Processor>){
        println("PHASE 2.0 - Retailers creation")

        val generator : Generator = Generator()

        this.processors = processors
        retailers = generator.generateRetailers(2)

        println("Processors: " + processors.size)
        println("Retailers: " + retailers.size)
        println()
    }

    fun printStats(){
        println("CURRENT STATE")
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

    fun runSimulation(){
        for(processor in processors){
            Request.requestTransportToWarehouse(processor, retailers.get(0))
            processor.processProduct()
        }
    }

    fun getRetailers() : ArrayList<Retailer>{
        return retailers
    }

    fun addRetailer(retailer: Retailer){
        retailers.add(retailer)
    }
}