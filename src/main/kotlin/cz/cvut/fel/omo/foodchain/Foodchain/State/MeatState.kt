package cz.cvut.fel.omo.foodchain.Foodchain.State

import java.util.*


class MeatState(context: Context, code : UUID) : State(context, code) {
    override fun changeToNextState() : State {
        context.setState(ProductState(context, code))
        return ProductState(context, code)
    }
}