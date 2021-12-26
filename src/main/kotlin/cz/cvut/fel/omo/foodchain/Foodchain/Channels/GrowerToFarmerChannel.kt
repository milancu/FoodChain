package cz.cvut.fel.omo.foodchain.Foodchain.Channels

import cz.cvut.fel.omo.foodchain.Foodchain.Request
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropType
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Farmer
import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop

/**
 * Grower to farmer channel
 *
 * @constructor Create empty Grower to farmer channel
 */
class GrowerToFarmerChannel(private var growers: ArrayList<Grower>, private var farmers: ArrayList<Farmer>) : Channel{

    // run simulation musi byt pred porcesorem
    override fun runSimulation(){
        for(farmer in farmers){
            if(farmer.needResource()){
                Request.requestFarmerBuyCrops(farmer, findCorrectSupplier())
            }
            farmer.payDebts()
        }
    }

    override fun printStats() {
        // Zde se neaktualizuji podstatne statistiky, jednalo by se o redundanci
    }

    /**
     * Find correct supplier
     *
     * @return
     */
    fun findCorrectSupplier() : Grower{
        for(grower in growers){
            for(crop in grower.getSupplies()){
                if(crop.getType() == CropType.CEREAL){
                    return grower
                }
            }
        }
        println("Nedostatek vhodnych dodavatelu v CR")
        val exoticGrower = Grower("sosGrower", "Exotica", 0.0)
        val exoticCrop = Crop(CropName.WHEET, CropType.CEREAL, 50, 0)
        exoticGrower.addEmergencyCrop(exoticCrop)
        return exoticGrower
    }
}