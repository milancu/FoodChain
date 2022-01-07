package cz.cvut.fel.omo.foodchain.Foodchain.visitor

interface Export {
    fun accept(visitor : Visitor)
}