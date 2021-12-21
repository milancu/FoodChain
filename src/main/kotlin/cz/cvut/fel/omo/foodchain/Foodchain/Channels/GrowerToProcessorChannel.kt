package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor

class GrowerToProcessorChannel {

    private var growers : ArrayList<Grower>
    private var processors : ArrayList<Processor>

    constructor(){
        val generator : Generator = Generator()

        growers = generator.generateGrowers(2)
        processors = generator.generateProcessors(2)
        val processor : Processor = generator.generateProcessor() // TODO jak rozhodovat, jakej processor se vybere

        // TODO
       /* println(processor.getSubjectName())
        println(processor.getLocation())*/


        // REQUEST - STATIKA
        // TRANSPORT - STATIKA

        for(grower in growers){
            Request.requestTransportToProcessor(grower, processor, grower.getSupplies())
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