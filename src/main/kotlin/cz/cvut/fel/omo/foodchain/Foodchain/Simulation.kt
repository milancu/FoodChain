package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Channels.*

class Simulation {

    private var channelG2P : GrowerToProcessorChannel = GrowerToProcessorChannel()
    private var channelF2P : FarmerToProcessorChannel = FarmerToProcessorChannel()
    private var channelG2F : GrowerToFarmerChannel = GrowerToFarmerChannel(channelG2P.getGrowers(), channelF2P.getFarmers())
    private var channelP2R : ProcessorToRetailerChannel = ProcessorToRetailerChannel(channelG2P.getProcessors())
    private var channelRTC : RetailerToCustomerChannel = RetailerToCustomerChannel(channelP2R.getRetailers())

    fun runWeek(){
        printStats()
        runSimulation()
        Week.acutalWeek++
    }

    private fun printStats(){
        channelG2P.printStats()
        channelP2R.printStats()
        channelP2R.printStats()
        channelRTC.printStats()
    }

    private fun runSimulation(){
        channelG2F.runSimulation()
        channelG2P.runSimulation()
        channelF2P.runSimulation()
        channelP2R.runSimulation()
        channelRTC.runSimulation() //todo
    }

}