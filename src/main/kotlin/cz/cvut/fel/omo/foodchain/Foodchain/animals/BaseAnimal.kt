package cz.cvut.fel.omo.foodchain.Foodchain.animals

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

open class BaseAnimal {
    private var weight : Double // TODO val podle toho, jestli budeme pracovat s vyvojem zvirete
    private val feed : List<Crop>
    private var age : Int
    private var price : Int

    constructor(weight: Double, feed: List<Crop>, age: Int, price : Int) {
        this.weight = weight
        this.feed = feed
        this.age = age
        this.price = price
    }

    // funkce eat
}