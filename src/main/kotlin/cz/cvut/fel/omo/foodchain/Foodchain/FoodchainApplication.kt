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
    fun sayHello(
        @RequestParam(value = "WEEKS") WEEKS: Int,
        @RequestParam(value = "GROWERS") GROWERS: Int,
        @RequestParam(value = "FARMERS") FARMERS: Int,
        @RequestParam(value = "PROCESSORS") PROCESSORS: Int,
        @RequestParam(value = "CUSTOMERS") CUSTOMERS: Int,
        @RequestParam(value = "RETAILERS") RETAILERS: Int,
        @RequestParam(value = "STANDARD_SHOP_SIZE") STANDARD_SHOP_SIZE: Int,
        @RequestParam(value = "VEGAN_SHOP_SIZE") VEGAN_SHOP_SIZE: Int,
        @RequestParam(value = "WORKOUT_SHOP_SIZE") WORKOUT_SHOP_SIZE: Int
    ) {
        
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
