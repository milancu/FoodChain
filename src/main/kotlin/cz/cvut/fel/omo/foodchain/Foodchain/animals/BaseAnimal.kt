package cz.cvut.fel.omo.foodchain.Foodchain.animals

import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

open class BaseAnimal {
    private var weight : Double
    private var feed : List<Crop>
    private var age : Int

    constructor(weight: Double, feed: List<Crop>, age: Int) {
        this.weight = weight
        this.feed = feed
        this.age = age
    }

    // funkce eat
}