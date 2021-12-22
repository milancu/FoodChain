package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower

class GrowerToFarmerChannel {
    private var farmers : ArrayList<Farmer>
    private var growers : ArrayList<Grower>

    constructor(growers: ArrayList<Grower>, farmers: ArrayList<Farmer>) {
        this.farmers = farmers
        this.growers = growers
    }
}