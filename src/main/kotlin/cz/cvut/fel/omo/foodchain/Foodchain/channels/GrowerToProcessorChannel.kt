package cz.cvut.fel.omo.foodchain.Foodchain.channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor

/**
 * Grower to processor channel
 *
 * @constructor Create empty Grower to processor channel
 */
class GrowerToProcessorChannel : Channel{

    private var growers : ArrayList<Grower>
    private var processors : ArrayList<Processor>

    init {
        println("PHASE 1.0 - Growers and processors creation")
        val generator = Generator()
        growers = generator.generateGrowers()
        processors = generator.generateProcessors()
        println("Growers: " + growers.size)
        println("Processors: " + processors.size)
        println()
    }

    override fun printStats(){
        println("CURRENT STATE - GROWER / PROCESSOR - CHANNEL")
        for(grower in growers){
            println("Grover: " + grower.getIdentifier() + " : money : " + grower.getAmountOfMoney() + " : supllies : " + grower.getSupplies().size)
        }
        for(processor in processors){
            println("Processor: " + processor.getIdentifier() + " : money : " + processor.getAmountOfMoney()
                    + " : supplies : " + processor.getStockSuppliesSize() + " : products : " + processor.getStockProductsSize())
            processor.payDebts()
        }
        println()
    }

    override fun runSimulation(){
        for(grower in growers){
            val processor = processors[(0 until processors.size).random()]
            Request.requestTransportToProcessor(grower, processor, grower.getSupplies())
            grower.harvest()
            processor.payDebts()
        }
    }

    /**
     * Add grower
     *
     * @param grower
     */
    fun addGrower(grower : Grower){
        growers.add(grower)
    }

    /**
     * Add proccessor
     *
     * @param processor
     */
    fun addProccessor(processor: Processor){
        processors.add(processor)
    }

    /**
     * Get processors
     *
     * @return
     */
    fun getProcessors() : ArrayList<Processor>{
        return processors
    }

    /**
     * Get growers
     *
     * @return
     */
    fun getGrowers() : ArrayList<Grower>{
        return growers
    }

}