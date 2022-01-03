package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Generator
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Customer
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

/**
 * Retailer to customer channel
 *
 * @constructor Create empty Retailer to customer channel
 */
class RetailerToCustomerChannel(private var retailers: ArrayList<Retailer>) : Channel{

    private var customers : ArrayList<Customer>
    private var generator : Generator = Generator()

    init {
        this.customers = generator.generateCustomers()
    }

    override fun runSimulation(){
        payForWarehouse()
        fillShops()
        for(customer in customers){
            val retailer : Retailer = retailers[(0 until retailers.size).random()]
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
        }
    }

    private fun payForWarehouse(){
        for(retailer in retailers){
            retailer.warehouseManagementPayment()
        }
    }

    /**
     * Add customer
     *
     * @param customer
     */
    fun addCustomer(customer : Customer){
        customers.add(customer)
    }

}