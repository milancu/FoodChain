package cz.cvut.fel.omo.foodchain.Foodchain.Observer

interface Observable {
    val observers: ArrayList<Observer>

    fun add(observer: Observer) {
        observers.add(observer)
    }

    fun remove(observer: Observer) {
        observers.remove(observer)
    }

    fun sendUpdateEvent() {
        observers.forEach { it.update() }
    }

}