package cz.cvut.fel.omo.foodchain.Foodchain.Observer

import java.util.*
import kotlin.collections.ArrayList

class Report : Observer{

    var reports = hashMapOf<UUID, ArrayList<String>>()

    init {
        println("Singleton class invoked.")
    }

    fun getReport(uuid: UUID) : ArrayList<String>? {
        return reports.get(uuid)
    }

    override fun update(uuid: UUID, report: String) {
        if(!reports.containsKey(uuid)){
            var newReport = ArrayList<String>()
            newReport.add(report)
            reports.put(uuid, newReport)
        } else {
            var existingReport = reports.get(uuid)
            if (existingReport != null) {
                existingReport.add(report)
            }
            if (existingReport != null) {
                reports.put(uuid, existingReport)
            };
        }
    }
}