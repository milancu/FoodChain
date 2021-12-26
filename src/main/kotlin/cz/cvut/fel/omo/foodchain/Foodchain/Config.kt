package cz.cvut.fel.omo.foodchain.Foodchain

/**
 * Config
 *
 * @constructor Create empty Config
 */
class Config {
    companion object Params {
        // main config
        const val WEEKS : Int = 10
        const val GROWERS : Int = 2
        const val FARMERS : Int = 2
        const val PROCESSORS : Int = 2
        const val CUSTOMERS : Int = 100
        const val RETAILERS : Int = 2

        const val STANDARD_SHOP_SIZE : Int = 10
        const val VEGAN_SHOP_SIZE : Int = 2
        const val WORKOUT_SHOP_SIZE : Int = 5

        const val SALARY_MIN = 10000
        const val SALARY_MAX = 80000

        const val ANIMALS_MIN = 20
        const val ANIMALS_MAX = 50

        const val FIELD_CAPACITY_MIN = 100
        const val FIELD_CAPACITY_MAX = 1000

        const val FLOWER_MAX_AGE = 10

        const val MIN_FIELDS = 2
        const val MAX_FIELDS = 10

        const val MIN_DEAFAULT_CROPTYPES = 5
        const val MAX_DEFAULT_CROPTYPES = 10

        const val MIN_DEFAULT_CROPS = 100
        const val MAX_DEFAULT_CROPS = 1000

        const val FINANCE_MIN = 1000000
        const val FINANCE_MAX = 10000000
        const val NAME_LENGTH = 12
        const val LOCATION_LENGTH = 16

        const val TRANSPORT_TAX = 0.1
    }
}