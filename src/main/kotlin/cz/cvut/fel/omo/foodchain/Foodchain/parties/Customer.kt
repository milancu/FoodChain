package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Config

class Customer(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    var salary: Double = (Config.SALARY_MIN..Config.SALARY_MAX).random().toDouble()

    fun receiveSalary() {
        this.amountOfMoney += salary
    }

}


