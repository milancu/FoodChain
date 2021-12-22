package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.Config
import cz.cvut.fel.omo.foodchain.Foodchain.Invoice
import cz.cvut.fel.omo.foodchain.Foodchain.Strategy.CustomerSategy.*
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Customer(subjectName: String, location: String, amountOfMoney: Double) :
    BaseParty(subjectName, location, amountOfMoney) {

    private val basicStrategy : BasicStrategy = BasicStrategy()
    private val easterEggStrategy : EasterEggStrategy = EasterEggStrategy()
    private val meatLoverStrategy : MeatLoverStrategy = MeatLoverStrategy()
    private val randomStrategy : RandomStrategy = RandomStrategy()
    private val veganStrategy : VeganStrategy = VeganStrategy()

    private var salary: Double = (Config.SALARY_MIN..Config.SALARY_MAX).random().toDouble()
    private var context : CustomerContext = chooseStrategy()
    private var creditCardDebts : ArrayList<Invoice> = ArrayList()

    private fun chooseStrategy() : CustomerContext{
        val context : CustomerContext
        val random : Int = (1..5).random()
        when(random){
            1 -> {
                context = CustomerContext(basicStrategy)
                return context
            }
            2 -> {
                context = CustomerContext(easterEggStrategy)
                return context
            }
            3 -> {
                context = CustomerContext(meatLoverStrategy)
                return context
            }
            4 -> {
                context = CustomerContext(randomStrategy)
                return context
            }
            else -> {
                context = CustomerContext(veganStrategy)
                return context
            }
        }
    }

    fun receiveSalary() {
        this.amountOfMoney += salary
    }

    // Produkty nebudeme ukladat, budou vyrazeny z obehu, stejne by se nezpracovavaly, nebo resetovaly
    fun buyProducts(products : ArrayList<Product>) : Double {
        val spendedMoney : Double = context.goShopping(products)
        return spendedMoney
    }

    fun payForShopping(recipe : Invoice){
        if(recipe.getPrice() <= this.amountOfMoney){
            amountOfMoney -= recipe.getPrice()
            recipe.getContractor().takeMoney(recipe.getPrice())
        } else {
            creditCardDebts.add(recipe)
            println("Vznika dluh na kreditni karte v castce " + recipe.getPrice())
        }
    }

    fun payDebts(){
        var toRemove : ArrayList<Invoice> = ArrayList()
        for(invoice in creditCardDebts){
            if(amountOfMoney >= invoice.getPrice()){
                toRemove.add(invoice)
                invoice.payInvoice()
                invoice.notifyPaid()
                amountOfMoney -= invoice.getPrice()
            }
        }
        for(invoice in toRemove){
            println("Penize za " + invoice.getCode() + " splaceny")
            creditCardDebts.remove(invoice)
        }
    }


}


