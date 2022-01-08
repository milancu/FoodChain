package cz.cvut.fel.omo.foodchain.Foodchain.iterator

import cz.cvut.fel.omo.foodchain.Foodchain.animals.Animal

class AnimalToProcess : CustomIterator {

    private var animalList : ArrayList<Animal>;

    constructor() {
        this.animalList = ArrayList<Animal>()
    }

    override fun hasNext(): Boolean {
        return !animalList.isEmpty()
    }

    override fun next(): Animal {
        val animal = animalList[0]
        animalList.removeAt(0)
        return animal;
    }

    fun add(animal: Animal) {
        animalList.add(animal)
    }

    fun clearList() {
        animalList = ArrayList<Animal>();
    }

    @JvmName("getAnimalList1")
    fun getAnimalList(): ArrayList<Animal> {
        return animalList
    }

    fun getSize(): Int {
        return animalList.size
    }
}