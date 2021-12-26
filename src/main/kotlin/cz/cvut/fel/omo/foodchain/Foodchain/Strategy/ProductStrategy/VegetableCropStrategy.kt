package cz.cvut.fel.omo.foodchain.Foodchain.Strategy.ProductStrategy

import cz.cvut.fel.omo.foodchain.Foodchain.Observer.Report
import cz.cvut.fel.omo.foodchain.Foodchain.enums.CropName
import cz.cvut.fel.omo.foodchain.Foodchain.enums.ProductType
import cz.cvut.fel.omo.foodchain.Foodchain.products.Crop
import cz.cvut.fel.omo.foodchain.Foodchain.products.CropProduct
import cz.cvut.fel.omo.foodchain.Foodchain.products.Product

/**
 * Vegetable crop strategy
 *
 * @constructor Create empty Vegetable crop strategy
 */
class VegetableCropStrategy : ProcessorCropStrategy {
    override fun execute(crop: Crop): Product {
        when (crop.getName()) {
            CropName.POTATO -> return createFromPotato(crop)
            CropName.SALAD -> {
                var product = CropProduct(
                    crop.getName().toString(),
                    ProductType.VEGETABLES,
                    crop.getShopPrice() * 1.2,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            CropName.CUCCUMBER -> return createFromCucumber(crop)
            CropName.TOMATO -> return createFromTomato(crop)
            CropName.ONION -> return createFromOnion(crop)
            CropName.SUGARBEAT -> {
                var product = CropProduct(
                    "Suggar",
                    ProductType.BULKINGREDIENTS,
                    crop.getShopPrice() * 1.2,
                    crop.getShopPrice(),
                    (0.65 * crop.getAmount()).toInt(),
                    "kg",
                    crop.getUUID()
                )
                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            else -> throw Exception("Wrong crop name input: " + crop.getName() + "Vegetable strategy")
        }
    }

    /**
     * Create from tomato
     *
     * @param crop
     * @return
     */
    fun createFromTomato(crop: Crop): Product {
        var random: Int = (1..4).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    crop.getName().toString(),
                    ProductType.VEGETABLES,
                    crop.getShopPrice() * 1.2,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            2 -> {
                val product = CropProduct(
                    "Ketchup",
                    ProductType.SAUCE,
                    crop.getShopPrice() * 1.2 + 25,
                    crop.getShopPrice() + 25,
                    (crop.getAmount() * 0.60).toInt(),
                    "l",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            3 -> {
                val product = CropProduct(
                    "Dried tomatoes",
                    ProductType.CANS,
                    crop.getShopPrice() * 1.2 + 15,
                    crop.getShopPrice() + 15,
                    (crop.getAmount() * 0.85).toInt(),
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            else -> {
                val product = CropProduct(
                    "Cropped tomatoes",
                    ProductType.CANS,
                    crop.getShopPrice() * 1.2 + 10,
                    crop.getShopPrice() + 10,
                    (crop.getAmount() * 0.85).toInt(),
                    "kg",
                    crop.getUUID()
                )


                product.attach(Report)
                product.notifyUpdate()
                return product
            }
        }
    }

    /**
     * Create from cucumber
     *
     * @param crop
     * @return
     */
    fun createFromCucumber(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    crop.getName().toString(),
                    ProductType.VEGETABLES,
                    crop.getShopPrice() * 1.2,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            else -> {
                val product = CropProduct(
                    "jar of sour" + crop.getName().toString(),
                    ProductType.VEGETABLES,
                    crop.getShopPrice() * 2.5,
                    crop.getShopPrice() + 20,
                    1,
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
        }
    }

    /**
     * Create from onion
     *
     * @param crop
     * @return
     */
    fun createFromOnion(crop: Crop): Product {
        var random: Int = (1..2).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    crop.getName().toString(),
                    ProductType.VEGETABLES,
                    crop.getShopPrice() * 1.2,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            else -> {
                val product = CropProduct(
                    "Onion rings",
                    ProductType.ICED,
                    crop.getShopPrice() * 2.0,
                    crop.getShopPrice() + 10,
                    (0.9 * crop.getAmount()).toInt(),
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
        }
    }

    /**
     * Create from potato
     *
     * @param crop
     * @return
     */
    fun createFromPotato(crop: Crop): Product {
        var random: Int = (1..3).random()
        when (random) {
            1 -> {
                val product = CropProduct(
                    crop.getName().toString(),
                    ProductType.VEGETABLES,
                    crop.getShopPrice() * 1.2,
                    crop.getShopPrice(),
                    1,
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            2 -> {
                val product = CropProduct(
                    "Chips",
                    ProductType.OTHERS,
                    crop.getShopPrice() * 2.5,
                    crop.getShopPrice() + 15,
                    (0.75 * crop.getAmount()).toInt(),
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
            else -> {
                val product = CropProduct(
                    "French fries",
                    ProductType.OTHERS,
                    crop.getShopPrice() * 1.8,
                    crop.getShopPrice() + 25,
                    (0.65 * crop.getAmount()).toInt(),
                    "kg",
                    crop.getUUID()
                )

                product.attach(Report)
                product.notifyUpdate()
                return product
            }
        }
    }

}