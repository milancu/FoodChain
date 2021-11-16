package cz.cvut.fel.omo.foodchain.Foodchain.parties

import javax.print.attribute.IntegerSyntax

open class BaseParty {
    private val subjectName : String
    private val identifier : Int // Pro kazdy subjet jina podoba + validace (ICO, rodne cislo)
    private var location : String // TODO povolime zmeny?
    // private var numberOfEmployees : Int // pouze pro firmy
    private var amountOfMoney : Int

    constructor(subjectName: String, identifier: Int, location: String, amountOfMoney: Int) {
        this.subjectName = subjectName
        this.identifier = identifier
        this.location = location
        this.amountOfMoney = amountOfMoney
    }
}