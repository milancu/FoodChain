package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Channels.FarmerToProcessorChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.GrowerToProcessorChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.ProcessorToRetailerChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Channels.RetailerToCustomerChannel
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
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

	// TODO TIMER, aby nebylo nutny spoustet vsechny run zvlast

	channelG2P.printStats()
	channelP2R.printStats()
	channelP2R.printStats()
	channelRTC.printStats()

	println("ONE WEEK LATER")
	println()

	// poskoceni o tyden
	channelG2P.runSimulation()
	channelF2P.runSimulation()
	channelP2R.runSimulation()
	channelRTC.runSimulation() //todo

	channelG2P.printStats()
	channelF2P.printStats()
	channelP2R.printStats()
	channelRTC.printStats() //todo


	println("TWO WEEKS LATER")
	println()

	channelP2R.runSimulation()
	channelF2P.runSimulation()
	channelP2R.printStats()
	channelRTC.runSimulation() //todo

	channelG2P.printStats()
	channelF2P.printStats()
	channelP2R.printStats()
	channelRTC.printStats() //todo

	/*println("#############################################################")
	var generator : Generator = Generator()

	for(i in generator.generateAnimals()){
		var id = i.getOriginId()
		println(Report.getReport(id)!!.get(0))
	}*/

}
