package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Customer
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

class RetailerToCustomerChannel : Channel{

    private var retailers : ArrayList<Retailer>
    private var customers : ArrayList<Customer>
    var generator : Generator = Generator()

    constructor(retailers : ArrayList<Retailer>){
        this.retailers = retailers
        this.customers = generator.generateCustomers()
    }

    override fun runSimulation(){
        //TODO() // nezapomen na
    }

    override fun printStats(){
        //TODO
    }

    fun addCustomer(customer : Customer){
        customers.add(customer)
    }

}