package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Processor
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Transport

class Channel {

    constructor(){
        val generator : Generator = Generator()

        val growers : ArrayList<Grower> = generator.generateGrowers()
        val processor : Processor = generator.generateProcessor()
       /* println(processor.getAmountOfMoney())*/


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
}