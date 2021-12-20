package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.enums.AnimalType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FoodchainApplication

fun main(args: Array<String>) {
	runApplication<FoodchainApplication>(*args)

	var generator = Generator()
	var animals = generator.generateAnimals()

	for(i in animals){
		println(i.animalName + ", " + i.weight + "g")
	}

}
