package cz.cvut.fel.omo.foodchain.Foodchain.State

import java.util.*

abstract class State(protected var context: Context, protected var code: UUID) {

    abstract fun changeToNextState() : State
}