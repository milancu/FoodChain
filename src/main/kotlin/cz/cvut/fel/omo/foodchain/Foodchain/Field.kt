package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import java.util.*
import kotlin.math.roundToInt

class Field {


    private var crop: Crop
    private val capacity: Int
    private var isRaised: Boolean = true
    private var uuid: UUID

    constructor(crop: Crop, capacity: Int) {
        this.crop = crop
        this.capacity = capacity
        this.uuid = UUID.randomUUID()
    }

    fun getUUID(): UUID {
        return this.uuid
    }

    fun getCapacity(): Int {
        return this.capacity
    }

    fun isRaised(): Boolean {
        return isRaised;
    }

    fun setRaised(value: Boolean) {
        isRaised = value;
    }

    fun decreaseProduction() {
        crop.setAmount((crop.getAmount() * 0.8).roundToInt())
    }

    fun resetField() {
        crop.resetCrop()
        crop.setAmount(capacity)
    }

    fun getCrop(): Crop {
        return crop
    }

    fun growCrop() {
        crop.grow()
    }
}