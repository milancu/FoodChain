package cz.cvut.fel.omo.foodchain.Foodchain

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodchainApplication

fun main(args: Array<String>) {
	runApplication<FoodchainApplication>(*args)
}
