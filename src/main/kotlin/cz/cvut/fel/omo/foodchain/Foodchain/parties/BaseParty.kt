package cz.cvut.fel.omo.foodchain.Foodchain.parties

/**
 * Base party
 *
 * @constructor Create empty Base party
 */
open class BaseParty {

    protected val subjectName : String
    protected val identifier : Int // Pro kazdy subjet jina podoba + validace (ICO, rodne cislo)
    protected val location : String
    protected var amountOfMoney : Double

    constructor(subjectName: String, location: String, amountOfMoney: Double) {
        this.subjectName = subjectName
        this.identifier = (10000000..99999999).random()
        this.location = location
        this.amountOfMoney = amountOfMoney
    }

    /**
     * Get subject name
     *
     * @return
     */
    @JvmName("getName")
    fun getSubjectName() : String{
        return subjectName
    }

    /**
     * Get identifier
     *
     * @return
     */
    @JvmName("getId")
    fun getIdentifier() : Int{
        return identifier
    }

    /**
     * Get location
     *
     * @return
     */
    @JvmName("getLoc")
    fun getLocation() : String{
        return location
    }

    /**
     * Get amount of money
     *
     * @return
     */
    @JvmName("getMoney")
    fun getAmountOfMoney() : Double{
        return amountOfMoney
    }

    /**
     * Change amount of money
     *
     * @param value
     */
    fun changeAmountOfMoney(value : Double){
        amountOfMoney += value
    }

    /**
     * Take money
     *
     * @param value
     */
    fun takeMoney(value : Double){
        amountOfMoney += value
    }
}