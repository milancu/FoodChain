package cz.cvut.fel.omo.foodchain.Foodchain.Iterator

import cz.cvut.fel.omo.foodchain.Foodchain.animals.BaseAnimal

interface CustomIterator {
    operator fun hasNext(): Boolean
    operator fun next(): BaseAnimal
}