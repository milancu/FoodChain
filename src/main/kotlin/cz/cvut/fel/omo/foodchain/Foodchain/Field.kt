package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Observer
import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Subject
import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import java.util.*
import kotlin.math.roundToInt

class Field : Subject{

    companion object {
        private var observers: ArrayList<Observer> = ArrayList()
    }

    private var crop : Crop
    private val capacity : Int
    private var isRaised : Boolean = true
    private var uuid : UUID

    constructor(crop: Crop, capacity: Int) {
        this.crop = crop
        this.capacity = capacity
        this.uuid = UUID.randomUUID()
        notifyUpdate(this.uuid, "crop type: " + this.crop.getType().toString() + " , capacity " + this.capacity.toString())
    }

    fun isRaised() : Boolean{
        return isRaised;
    }

    fun setRaised(value : Boolean){
        isRaised = value;
    }

    fun decreaseProduction(){
        crop.setAmount((crop.getAmount() * 0.8).roundToInt())
    }

    fun resetField(){
        crop.resetCrop()
        crop.setAmount(capacity)
    }

    fun getCrop() : Crop{
       return crop
    }

    fun growCrop(){
        crop.grow()
    }

    override fun attach(o: Observer) {
        Field.observers.add(o)
    }

    override fun detach(o: Observer) {
        Field.observers.remove(o)
    }

    override fun notifyUpdate(uuid: UUID, report: String) {
        for(i in Field.observers){
            i.update(uuid, report)
        }
    }
}