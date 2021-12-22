package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Channels.*

class Simulation {

    private var channelG2P : GrowerToProcessorChannel = GrowerToProcessorChannel()
    private var channelF2M : FarmerToMeatFactoryChannel = FarmerToMeatFactoryChannel()
    private var channelG2F : GrowerToFarmerChannel = GrowerToFarmerChannel(channelG2P.getGrowers(), channelF2M.getFarmers())
    private var channelP2R : ProcessorToRetailerChannel = ProcessorToRetailerChannel(channelG2P.getProcessors())
    private var channelM2R : MeatFactoryToRetailerChannel = MeatFactoryToRetailerChannel(channelF2M.getMeatFactory() ,channelP2R.getRetailers())
    private var channelRTC : RetailerToCustomerChannel = RetailerToCustomerChannel(channelP2R.getRetailers())

    fun runWeek(){
        runSimulation()
        printStats()
        Week.acutalWeek++
    }

    private fun printStats(){
        channelG2P.printStats()
        channelF2M.printStats()
        channelP2R.printStats()
        channelP2R.printStats()
        channelM2R.printStats()
        channelRTC.printStats()
    }

    private fun runSimulation(){
        channelG2F.runSimulation()
        channelG2P.runSimulation()
        channelF2M.runSimulation()
        channelP2R.runSimulation()
        channelM2R.runSimulation()
        channelRTC.runSimulation() //todo
    }

}