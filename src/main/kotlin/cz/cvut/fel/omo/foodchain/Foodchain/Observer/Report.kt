package cz.cvut.fel.omo.foodchain.Foodchain.Observer


import java.io.File
import java.util.*
import kotlin.collections.ArrayList


object Report : Observer {

    fun export() {
        val fileName = "src/main/resources/exportFoodChain.txt"
        val file = File(fileName)

        file.printWriter().use { out ->
            reports.forEach { (key) ->
                with(out) { println("UUID: $key") }
                val reportList : ArrayList<String> = reports[key]!!
                for (j in reportList) {
                    out.println(j)
                }
                out.println("##############################################")
                out.println("\n")
            }
        }

        println("Writed to file")
    }


    private var reports = hashMapOf<UUID, ArrayList<String>>()

    // TODO je k necemu?
    fun getReport(uuid: UUID): ArrayList<String>? {
        return reports[uuid]
    }


    override fun update(uuid: UUID, report: String) {
        if (!reports.containsKey(uuid)) {
            val newReport: ArrayList<String> = ArrayList()
            newReport.add(report)
            reports[uuid] = newReport
        } else if(reports.containsKey(uuid)) {
            reports[uuid]?.add(report)
        }
    }
}