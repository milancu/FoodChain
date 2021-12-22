package cz.cvut.fel.omo.foodchain.Foodchain.Observer


import java.io.File
import java.util.*
import kotlin.collections.ArrayList


object Report : Observer {

    fun export() {
        val fileName = "src/main/resources/exportFoodChain.txt"
        var file = File(fileName)

        file.printWriter().use { out ->
            reports.forEach { (key) ->
                out.println(key)
                var reportList : ArrayList<String> = reports.get(key)!!
                for (j in reportList) {
                    out.println(j)
                }
                out.println("##############################################")
            }
        }

        println("Writed to file")
    }


    var reports = hashMapOf<UUID, ArrayList<String>>()

    fun getReport(uuid: UUID): ArrayList<String>? {
        return reports.get(uuid)
    }


    override fun update(uuid: UUID, report: String) {
        if (!reports.containsKey(uuid)) {
            var newReport: ArrayList<String> = ArrayList<String>()
            newReport.add(report)
            reports.put(uuid, newReport)
        } else if(reports.containsKey(uuid)) {
            reports.get(uuid)?.add(report)
        }
    }
}