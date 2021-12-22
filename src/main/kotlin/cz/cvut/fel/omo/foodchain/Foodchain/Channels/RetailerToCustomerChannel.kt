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
        payForWarehouse()
        fillShops()
        for(customer in customers){
            var retailer : Retailer = retailers.get( (0..retailers.size-1).random() )
            customer.receiveSalary()
            Request.requestGoShopping(retailer, customer)
            customer.payDebts()
        }
    }

    override fun printStats(){
        println("CURRENT STATE RETAILER / CUSTOMER - CHANNEL")
        for(retailer in retailers){
            println("Retailer: " + retailer.getIdentifier() + " : money : " + retailer.getAmountOfMoney()
                    + " : available products : " + retailer.getStockSize() + " : warehouseProducts : " + retailer.getWarehouseStockSize())
        }
        for(customer in customers){
            println("Customer: " + customer.getIdentifier() + " : money : " + customer.getAmountOfMoney())
        }
        println()
    }

    private fun fillShops(){
        for(retailer in retailers){
            Request.requestTakeOutToShop(retailer)
            println("Retailer: " + retailer.getIdentifier() + " naskladnil " + retailer.getStockSize() + " produktu.")
/*
            println("Warehouse obsahuje " + retailer.getWarehouseStockSize() + " produktu")
*/
        }
    }

    private fun payForWarehouse(){
        for(retailer in retailers){
            retailer.warehouseManagementPayment()
        }
    }

    fun addCustomer(customer : Customer){
        customers.add(customer)
    }

}