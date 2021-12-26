package cz.cvut.fel.omo.foodchain.Foodchain.parties

// TODO odstranit nebo pouzit na na State? Visitor? bUHVICO? :D

/**
 * Regulator
 *
 * @constructor
 *
 * @param subjectName
 * @param location
 * @param amountOfMoney
 */
class Regulator(subjectName : String, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, location, amountOfMoney)