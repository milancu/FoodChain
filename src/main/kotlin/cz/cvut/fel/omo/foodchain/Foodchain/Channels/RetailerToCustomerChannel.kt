package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.parties.Customer
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

class RetailerToCustomerChannel : Channel{

    private var retailers : ArrayList<Retailer>
    private var customers : ArrayList<Customer>

    constructor(retailers : ArrayList<Retailer>){
        this.retailers = retailers
        this.customers = ArrayList()
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