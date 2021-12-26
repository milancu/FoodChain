package cz.cvut.fel.omo.foodchain.Foodchain.Iterator

import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal

/**
 * Animal to process
 *
 * @constructor Create empty Animal to process
 */
class AnimalToProcess : CustomIterator {

    private var animalList : ArrayList<BaseAnimal>;

    constructor() {
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

    /**
     * Add
     *
     * @param animal
     */
    fun add(animal: BaseAnimal) {
        animalList.add(animal)
    }

    /**
     * Clear list
     *
     */
    fun clearList() {
        animalList = ArrayList<BaseAnimal>();
    }

    /**
     * Get animal list
     *
     * @return
     */
    @JvmName("getAnimalList1")
    fun getAnimalList(): ArrayList<BaseAnimal> {
        return animalList
    }

    /**
     * Get size
     *
     * @return
     */
    fun getSize(): Int {
        return animalList.size
    }
}