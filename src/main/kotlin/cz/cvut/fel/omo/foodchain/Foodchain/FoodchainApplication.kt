package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FoodchainApplication

fun main(args: Array<String>) {
	runApplication<FoodchainApplication>(*args)

	var channel : Channel = Channel()

}
