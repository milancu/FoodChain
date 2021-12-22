package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Channels.FarmerToProcessorChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.GrowerToProcessorChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.ProcessorToRetailerChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.RetailerToCustomerChannel

class Simulation {

    private var time : Int = 1
    private var channelG2P : GrowerToProcessorChannel = GrowerToProcessorChannel()
    private var channelF2P : FarmerToProcessorChannel = FarmerToProcessorChannel()
    private var channelP2R : ProcessorToRetailerChannel = ProcessorToRetailerChannel(channelG2P.getProcessors())
    private var channelRTC : RetailerToCustomerChannel = RetailerToCustomerChannel(channelP2R.getRetailers())

    fun runWeek(){
        printStats()
        runSimulation()
        time++
    }

    private fun printStats(){
        channelG2P.printStats()
        channelP2R.printStats()
        channelP2R.printStats()
        channelRTC.printStats()
    }

    private fun runSimulation(){
        channelG2P.runSimulation()
        channelF2P.runSimulation()
        channelP2R.runSimulation()
        channelRTC.runSimulation() //todo
    }

}