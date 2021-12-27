package cz.cvut.fel.omo.foodchain.Foodchain.State

import java.util.*

class SoldState(context: Context, code : UUID) : State(context, code) {
    override fun changeToNextState() : State {
        return SoldState(context, code)
    }
}