package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

class GrowerToFarmerChannel : Channel{
    private var farmers : ArrayList<Farmer>
    private var growers : ArrayList<Grower>

    constructor(growers: ArrayList<Grower>, farmers: ArrayList<Farmer>) {
        this.farmers = farmers
        this.growers = growers
    }

    // run simulation musi byt pred porcesorem
    override fun runSimulation(){
        for(farmer in farmers){
            if(farmer.needResource()){
                Request.requestFarmerBuyCrops(farmer, findCorrectSupplier(), 1) //todo ooprava
            }
            farmer.payDebts()
        }
    }

    override fun printStats() {
        // Zde se neaktualizuji podstatne statistiky, jednalo by se o redundanci
    }

    fun findCorrectSupplier() : Grower{
        for(grower in growers){
            for(crop in grower.getSupplies()){
                if(crop.getType() == CropType.CEREAL){
                    return grower
                }
            }
        }
        println("Nedostatek vhodnych dodavatelu v CR")
        var exoticGrower : Grower = Grower("sosGrower", "Exotica", 0.0)
        var exoticCrop : Crop = Crop(CropName.WHEET, CropType.CEREAL, 50, 0)
        exoticGrower.addEmergencyCrop(exoticCrop)
        return exoticGrower
    }
}