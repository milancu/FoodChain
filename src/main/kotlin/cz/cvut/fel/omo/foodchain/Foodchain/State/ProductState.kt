package cz.cvut.fel.omo.foodchain.Foodchain.State

import java.util.*

class ProductState(context: Context, code : UUID) : State(context, code) {
    override fun changeToNextState() : State {
        context.setState(SoldState(context, code))
        return SoldState(context, code)
    }
}