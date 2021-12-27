package cz.cvut.fel.omo.foodchain.Foodchain.State

import java.util.*

class AnimalState(context: Context, code : UUID) : State(context, code) {
    override fun changeToNextState() : State {
        context.setState(MeatState(context, code))
        return MeatState(context, code)
    }
}