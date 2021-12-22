package cz.cvut.fel.omo.foodchain.Foodchain.parties

class Customer(subjectName : String, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, location, amountOfMoney) {

    var salary : Double = (15000..80000).random().toDouble()

    fun receiveSalary(){
        this.amountOfMoney += salary
    }

    }


