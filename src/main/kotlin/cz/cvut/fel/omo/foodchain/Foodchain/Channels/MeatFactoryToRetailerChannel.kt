package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Factory.MeatFactory
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Retailer

class MeatFactoryToRetailerChannel {
    private var retailers : ArrayList<Retailer>
    private var meatFactory : MeatFactory

    constructor(meatFactory: MeatFactory, retailers: ArrayList<Retailer>) {
        this.retailers = retailers
        this.meatFactory = meatFactory
    }
}