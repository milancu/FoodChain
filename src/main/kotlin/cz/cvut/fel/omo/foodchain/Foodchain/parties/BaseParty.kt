package cz.cvut.fel.omo.foodchain.Foodchain.parties

import javax.print.attribute.IntegerSyntax

const val NAME_LENGTH = 12;
const val IDENTIFIER_LENGTH = 8;
const val LOCATION_LENGTH = 16;
const val ALPHANUMERIC_REGEX = "[a-zA-Z0-9]+";

open class BaseParty {

    protected val subjectName : String
    protected val identifier : Int // Pro kazdy subjet jina podoba + validace (ICO, rodne cislo)
    protected val location : String
    protected var amountOfMoney : Double

    constructor(subjectName: String, identifier: Int, location: String, amountOfMoney: Double) {
        this.subjectName = subjectName
        this.identifier = identifier
        this.location = location
        this.amountOfMoney = amountOfMoney
    }
}