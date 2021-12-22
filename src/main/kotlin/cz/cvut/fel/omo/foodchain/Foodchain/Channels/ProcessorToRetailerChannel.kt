package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Config
import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

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

        fillShops()
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
            Request.requestTransportToWarehouse(processor, retailers.get(0))
            println("Priprava k vytvareni vyrobku")
            processor.processProduct()
            println("Produkty vytvoreny")
        }
    }

    fun fillShops(){
        for(retailer in retailers){
            Request.requestTakeOutToShop(retailer)
            println("Retailer: " + retailer.getIdentifier() + " naskladnil " + retailer.getStockSize() + " produktu.")
        }
    }

    fun getRetailers() : ArrayList<Retailer>{
        return retailers
    }

    fun addRetailer(retailer: Retailer){
        retailers.add(retailer)
    }
}