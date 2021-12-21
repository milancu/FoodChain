package cz.cvut.fel.omo.foodchain.Foodchain.Observer

import jdk.internal.org.jline.keymap.KeyMap.key
import java.util.*


object Report : Observer {

    var reports = hashMapOf<UUID, ArrayList<String>>()

    init {
        println("Singleton class invoked.")
    }

    fun getReport(uuid: UUID): ArrayList<String>? {
        return reports.get(uuid)
    }


    override fun update(uuid: UUID, report: String) {
        if (!reports.containsKey(uuid)) {
            var newReport: ArrayList<String> = ArrayList<String>()
            newReport.add(report)
            reports.put(uuid, newReport)
        } else {

            var set: ArrayList<String> = reports.get(uuid)!!
            set.add(report)
            reports.put(uuid, set);
        }
    }
}