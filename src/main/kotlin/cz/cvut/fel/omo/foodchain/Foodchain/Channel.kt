package cz.cvut.fel.omo.foodchain.Foodchain

import cz.cvut.fel.omo.foodchain.Foodchain.parties.Grower

class Channel {

    val generator : Generator = Generator()

    val grower1 : Grower = generator.generateGrower()
    val grower2 : Grower = generator.generateGrower()
    val grower3 : Grower = generator.generateGrower()
    val grower4 : Grower = generator.generateGrower()



}