package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Channels.FarmerToProcessorChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.GrowerToProcessorChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.ProcessorToRetailerChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.RetailerToCustomerChannel
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FoodchainApplication

fun main(args: Array<String>) {
	runApplication<FoodchainApplication>(*args)

	var channelG2P : GrowerToProcessorChannel = GrowerToProcessorChannel()
	var channelF2P : FarmerToProcessorChannel = FarmerToProcessorChannel()
	var channelP2R : ProcessorToRetailerChannel = ProcessorToRetailerChannel(channelG2P.getProcessors())
	var channelRTC : RetailerToCustomerChannel = RetailerToCustomerChannel(channelP2R.getRetailers())







}
