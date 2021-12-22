package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
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
        for(customer in customers){
            /*var retailer : Retailer = retailers.get( (0..retailers.size-1).random() )*/
            customer.receiveSalary()
            Request.requestGoShopping(retailers.get(0), customer)
        }
    }

    override fun printStats(){
        //TODO
    }

    fun addCustomer(customer : Customer){
        customers.add(customer)
    }

}