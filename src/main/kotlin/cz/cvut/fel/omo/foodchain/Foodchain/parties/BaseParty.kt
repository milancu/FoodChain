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

    // TODO nezapomen ze customers maj jako identifikator rodne cislo a ma se prepsat, mozno nepouzit tenhle generator na customera
    fun generateNewParty() : BaseParty{
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z')

        val generatedName = (1..NAME_LENGTH)
            .map{ i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString { "" };
        val generatedIdentifier = (10000000..99999999).random()
        val generatedLocation = (1..LOCATION_LENGTH)
        .map{ i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString { "" } + ", " + (1000..9999).random();
        val generatedMoney = (10000..1000000).random().toDouble();

        return BaseParty(generatedName, generatedIdentifier, generatedLocation, generatedMoney)
    }



}