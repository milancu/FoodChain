package cz.cvut.fel.omo.foodchain.Foodchain

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FoodchainApplication

// todo global config

fun main(args: Array<String>) {

	runApplication<FoodchainApplication>(*args)
	val simulation : Simulation = Simulation()

	println("ONE WEEK LATER")
	println()
	simulation.runWeek()

	println("TWO WEEKS LATER")
	println()
	simulation.runWeek()

	println("THREE WEEKS LATER")
	println()
	simulation.runWeek()

	println("FOUR WEEKS LATER")
	println()
	simulation.runWeek()

	println("FIVE WEEKS LATER")
	println()
	simulation.runWeek()

	/*println("#############################################################")
	var generator : Generator = Generator()

	for(i in generator.generateAnimals()){
		var id = i.getOriginId()
		println(Report.getReport(id)!!.get(0))
	}*/
}
