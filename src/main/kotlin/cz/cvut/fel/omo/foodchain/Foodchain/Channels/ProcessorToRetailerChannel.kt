package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

class ProcessorToRetailerChannel {

    private var processors : ArrayList<Processor>
    private var retailers : ArrayList<Retailer>

    constructor(processors : ArrayList<Processor>){

        val generator : Generator = Generator()

        this.processors = processors
        retailers = generator.generateRetailers(2)
    }

    fun runSimulation(){

    }

    fun getRetailers() : ArrayList<Retailer>{
        return retailers
    }

    fun addRetailer(retailer: Retailer){
        retailers.add(retailer)
    }
}