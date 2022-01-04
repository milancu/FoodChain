package cz.cvut.fel.omo.foodchain.Foodchain.channels

import cz.cvut.fel.omo.foodchain.Foodchain.factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

/**
 * Meat factory to retailer channel
 *
 * @constructor Create empty Meat factory to retailer channel
 */
class MeatFactoryToRetailerChannel(private var meatFactory: MeatFactory, private var retailers: ArrayList<Retailer>) : Channel{

    override fun runSimulation(){
        val retailer : Retailer = retailers[(0 until retailers.size).random()]
        println("CURRENT STATE MEATFACTORY / RETAILER - CHANNEL")
        println("Zahajeni zpracovani masnych produktu : " + meatFactory.getPreparedPorducts() + " zasoby: " + meatFactory.getMeatResources())
        Request.requestProccessMeat(meatFactory)
        println("Masne produkty pripraveny : " + meatFactory.getPreparedPorducts() + " zasoby: " + meatFactory.getMeatResources())
        Request.requestTransportToWarehouse(meatFactory, retailer)
        println("Masne produkty prevezeny do prodeje, aktualni stav produktu : " + meatFactory.getPreparedPorducts())
        println()
        retailer.payDebts()
    }

    override fun printStats() {
        println("MeatFactory: " + meatFactory.getIdentifier() + " : money : " + meatFactory.getAmountOfMoney()
                + " : supplies : " + meatFactory.getMeatResources() + " : products : " + meatFactory.getPreparedPorducts())
        for(retailer in retailers){
            println("Retailer: " + retailer.getIdentifier() + " : money : " + retailer.getAmountOfMoney()
                    + " : available products : " + retailer.getStockSize() + " : warehouseProducts : " + retailer.getWarehouseStockSize())
        }
        println()
    }
}