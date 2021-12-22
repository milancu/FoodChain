package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FoodchainApplication


fun main(args: Array<String>) {

	runApplication<FoodchainApplication>(*args)
	val simulation : Simulation = Simulation()

	for(i in (1..Config.WEEKS)){
		println(i.toString() + ". WEEK")
		println()
		simulation.runWeek()
	}

	/*Report.export()*/
}
