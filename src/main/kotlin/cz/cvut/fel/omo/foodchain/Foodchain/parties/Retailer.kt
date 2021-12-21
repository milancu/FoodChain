package cz.cvut.fel.omo.foodchain.Foodchain.parties

class Retailer(subjectName : String, identier : Int, location : String, amountOfMoney : Double)
    : BaseParty(subjectName, identier, location, amountOfMoney) {

        var warehouse : Warehouse = Warehouse()

}

// TODO system slev? :D
