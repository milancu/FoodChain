package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Foodchain application
 *
 * @constructor Create empty Foodchain application
 */
@SpringBootApplication
open class FoodchainApplication


/**
 * Main
 *
 * @param args
 */
fun main(args: Array<String>) {

	runApplication<FoodchainApplication>(*args)
	val simulation : Simulation = Simulation()

	for(i in (1..Config.WEEKS)){
		println(i.toString() + ". WEEK")
		println()
		simulation.runWeek()
	}

	Report.export()
}
