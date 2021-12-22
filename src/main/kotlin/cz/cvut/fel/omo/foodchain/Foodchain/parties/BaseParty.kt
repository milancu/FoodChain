package cz.cvut.fel.omo.foodchain.Foodchain.parties

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

    @JvmName("getName")
    fun getSubjectName() : String{
        return subjectName
    }

    @JvmName("getId")
    fun getIdentifier() : Int{
        return identifier
    }

    @JvmName("getLoc")
    fun getLocation() : String{
        return location
    }

    @JvmName("getMoney")
    fun getAmountOfMoney() : Double{
        return amountOfMoney
    }

    fun changeAmountOfMoney(value : Int){
        amountOfMoney += value
    }

    fun takeMoney(value : Double){
        amountOfMoney += value
    }
}