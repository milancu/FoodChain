package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class FoodchainApplication {

    @GetMapping("/start")
    fun start() {

    }
}


fun main(args: Array<String>) {
    runApplication<FoodchainApplication>(*args)
}

//val simulation: Simulation = Simulation()
//
//for (i in (1..Config.WEEKS)) {
//    println(i.toString() + ". WEEK")
//    println()
//    simulation.runWeek()
//}
//
//Report.export()
