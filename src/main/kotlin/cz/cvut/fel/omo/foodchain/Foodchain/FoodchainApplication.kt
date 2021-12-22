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
/*<<<<<<< HEAD
=======*/

	/*var generator = Generator()

	generator.generateAnimals()
>>>>>>> 7b473f66a356e0fe848bc070448b93ade7420904

	Report.export()
	println("####################")
*/

	/*println("#############################################################")
	var generator : Generator = Generator()

	for(i in generator.generateAnimals()){
		var id = i.getOriginId()
		println(Report.getReport(id)!!.get(0))
	}*/
}
