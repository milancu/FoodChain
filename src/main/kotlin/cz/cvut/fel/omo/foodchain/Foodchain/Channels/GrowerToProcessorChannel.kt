package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor

class GrowerToProcessorChannel {

    private var growers : ArrayList<Grower>
    private var processors : ArrayList<Processor>

    constructor(){
        println("PHASE 1.0 - Growers and processors creation")

        val generator : Generator = Generator()

        growers = generator.generateGrowers(2)
        processors = generator.generateProcessors(2)
        // TODO jak rozhodovat, jakej processor se vybere

        println("Growers: " + growers.size)
        println("Processors: " + processors.size)
        println()
    }

    fun printStats(){
        println("CURRENT STATE - GROWER / PROCESSOR - CHANNEL")
        for(grower in growers){
            println("Grover: " + grower.getIdentifier() + " : money : " + grower.getAmountOfMoney() + " : supllies : " + grower.getSupplies().size)
        }
        for(processor in processors){
            println("Processor: " + processor.getIdentifier() + " : money : " + processor.getAmountOfMoney()
                    + " : supplies : " + processor.getStockSuppliesSize() + " : products : " + processor.getStockProductsSize())
        }
        println()
    }

    fun runSimulation(){
        for(grower in growers){
            Request.requestTransportToProcessor(grower, processors.get(0), grower.getSupplies())
            grower.harvest();
        }
    }

    fun addGrower(grower : Grower){
        growers.add(grower)
    }

    fun addProccessor(processor: Processor){
        processors.add(processor)
    }

    fun getProcessors() : ArrayList<Processor>{
        return processors
    }

}