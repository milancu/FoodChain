package cz.cvut.fel.omo.foodchain.Foodchain

class Config {
    companion object params {
        // main config
        const val WEEKS : Int = 52
        const val GROWERS : Int = 2
        const val FARMERS : Int = 2
        const val PROCESSORS : Int = 1
        const val CUSTOMERS : Int = 20
        const val RETAILERS : Int = 1

        const val STANDARD_SHOP_SIZE : Int = 10
        const val VEGAN_SHOP_SIZE : Int = 2
        const val WORKOUT_SHOP_SIZE : Int = 5

        const val SALARY_MIN = 10000
        const val SALARY_MAX = 80000

        const val ANIMALS_MIN = 30
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
        const val IDENTIFIER_MIN = 10000000
        const val IDENTIFIER_MAX = 99999999
        const val NAME_LENGTH = 12;
        const val IDENTIFIER_LENGTH = 8;
        const val LOCATION_LENGTH = 16;
        const val ALPHANUMERIC_REGEX = "[a-zA-Z0-9]+";

        //TODO other global settings

    }
}