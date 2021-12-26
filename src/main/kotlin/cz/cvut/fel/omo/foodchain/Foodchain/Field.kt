package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import java.util.*
import kotlin.math.roundToInt

/**
 * Field
 *
 * @constructor Create empty Field
 */
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

    /**
     * Get u u i d
     *
     * @return
     */
    fun getUUID(): UUID {
        return this.uuid
    }

    /**
     * Get capacity
     *
     * @return
     */
    fun getCapacity(): Int {
        return this.capacity
    }

    /**
     * Is raised
     *
     * @return
     */
    fun isRaised(): Boolean {
        return isRaised;
    }

    /**
     * Set raised
     *
     * @param value
     */
    fun setRaised(value: Boolean) {
        isRaised = value;
    }

    /**
     * Decrease production
     *
     */
    fun decreaseProduction() {
        crop.setAmount((crop.getAmount() * 0.8).roundToInt())
    }

    /**
     * Reset field
     *
     */
    fun resetField() {
        var generator = Generator()
        this.crop = generator.generateCrop(1)
    }

    /**
     * Get crop
     *
     * @return
     */
    fun getCrop(): Crop {
        return crop
    }

    /**
     * Grow crop
     *
     */
    fun growCrop() {
        crop.grow()
    }
}