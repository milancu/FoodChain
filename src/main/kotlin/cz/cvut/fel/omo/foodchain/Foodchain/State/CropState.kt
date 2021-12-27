package cz.cvut.fel.omo.foodchain.Foodchain.State

import cz.cvut.fel.omo.foodchain.Foodchain.products.Product
import java.util.*

class CropState(context: Context, code : UUID) : State(context, code) {
    override fun changeToNextState() : State {
        context.setState(ProductState(context, code))
        return ProductState(context, code)
    }
}