package cz.cvut.fel.omo.foodchain.Foodchain.visitor

import cz.cvut.fel.omo.foodchain.Foodchain.observer.Report

interface Visitor {
    fun visit(export : Report)
}