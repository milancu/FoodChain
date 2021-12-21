package cz.cvut.fel.omo.foodchain.Foodchain.Observer

import java.util.*

interface Observer {
    fun update(uuid: UUID, report: String)
}