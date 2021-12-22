package cz.cvut.fel.omo.foodchain.Foodchain.Observer

import java.util.*

interface Subject {
    fun attach(o: Observer)
    fun detach(o: Observer)
    fun notifyUpdate()
}