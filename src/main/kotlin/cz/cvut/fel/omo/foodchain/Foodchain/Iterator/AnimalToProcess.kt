package cz.cvut.fel.omo.foodchain.Foodchain.Iterator

import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal

class AnimalToProcess() : CustomIterator {

    private var animalList : ArrayList<BaseAnimal>;

    init {
        this.animalList = ArrayList<BaseAnimal>()
    }

    override fun hasNext(): Boolean {
        return !animalList.isEmpty()
    }

    override fun next(): BaseAnimal {
        val animal = animalList[0]
        animalList.drop(0)
        return animal;
    }

    fun add(animal: BaseAnimal) {
        animalList.add(animal)
    }

    fun clearList() {
        animalList = ArrayList<BaseAnimal>();
    }

    @JvmName("getAnimalList1")
    fun getAnimalList(): ArrayList<BaseAnimal> {
        return animalList
    }

    fun getSize(): Int {
        return animalList.size
    }
}