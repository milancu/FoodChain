package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

/**
 * Meat factory to retailer channel
 *
 * @constructor Create empty Meat factory to retailer channel
 */
class MeatFactoryToRetailerChannel : Channel{
    private var retailers : ArrayList<Retailer>
    private var meatFactory : MeatFactory

    constructor(meatFactory: MeatFactory, retailers: ArrayList<Retailer>) {
        this.retailers = retailers
        this.meatFactory = meatFactory
    }

    override fun runSimulation(){
        var retailer : Retailer = retailers.get( (0..retailers.size-1).random() )
        println("CURRENT STATE MEATFACTORY / RETAILER - CHANNEL")
        println("Zahajeni zpracovani masnych produktu : " + meatFactory.getPreparedPorducts() + " zasoby: " + meatFactory.getMeatResources())
        Request.requestProccessMeat(meatFactory)
        println("Masne produkty pripraveny : " + meatFactory.getPreparedPorducts() + " zasoby: " + meatFactory.getMeatResources())
        Request.requestTransportToWarehouse(meatFactory, retailer) // TODO not get 0, to samy u process
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