package cz.cvut.fel.omo.foodchain.Foodchain.parties

import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class Warehouse{

    private var storagedProducts : ArrayList<Product> = ArrayList()

    @JvmName("getProducts")
    fun getStoragedProducts() : ArrayList<Product>{
        var toReturn : ArrayList<Product> = storagedProducts
        storagedProducts = ArrayList()
        return toReturn
    }

    fun getSpecificProducts(wantedType : ProductType) : ArrayList<Product>{
        var toReturn : ArrayList<Product> = ArrayList()
        for(product in storagedProducts){
            if(product.getProductType() == wantedType){
                toReturn.add(product)
                storagedProducts.remove(product)
            }
        }
        return toReturn
    }

    fun takeIn(products : ArrayList<Product>) {
        for(product in products){
            takeIn(product)
        }
    }

    fun takeIn(product : Product){
        storagedProducts.add(product)
    }
}