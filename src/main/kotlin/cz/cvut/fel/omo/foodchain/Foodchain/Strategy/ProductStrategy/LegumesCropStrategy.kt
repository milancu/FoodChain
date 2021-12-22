package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.ProductStrategy

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.CropProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

class LegumesCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product =  CropProduct(
                    "Raw" + crop.getName().toString(),
                    ProductType.LEGUMES,
                    crop.getShopPrice() * 1.2,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getUUID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                product.notifyUpdate(crop.getUUID(), "NEW PRODUCT " + product.getProductType() + ", Name: " + product.getName() + ", Amount: " + product.getAmount())

                return product
            }
            else -> {
                val product =  CropProduct(
                    "Can of " + crop.getName().toString(),
                    ProductType.CANS,
                    crop.getShopPrice() * 1.4,
                    crop.getShopPrice() + 5,
                    1,
                    "kg",
                    crop.getUUID()
                )
                product.attach(Report)
                crop.notifyCropWasExecuted()
                product.notifyUpdate(crop.getUUID(), "NEW PRODUCT " + product.getProductType() + ", Name: " + product.getName() + ", Amount: " + product.getAmount())

                return product
            }
        }
    }
}