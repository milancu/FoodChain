package cz.cvut.fel.omo.foodchain.Foodchain

class Config {
    companion object params {
        // main config
        const val WEEKS : Int = 5
        const val GROWERS : Int = 2
        const val FARMERS : Int = 2
        const val PROCESSORS : Int = 2
        const val CUSTOMERS : Int = 20
        const val RETAILERS : Int = 2


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