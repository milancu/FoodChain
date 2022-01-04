package cz.cvut.fel.omo.foodchain.Foodchain.iterator

import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal

/**
 * Custom iterator
 *
 * @constructor Create empty Custom iterator
 */
interface CustomIterator {
    /**
     * Has next
     *
     * @return
     */
    operator fun hasNext(): Boolean

    /**
     * Next
     *
     * @return
     */
    operator fun next(): BaseAnimal
}