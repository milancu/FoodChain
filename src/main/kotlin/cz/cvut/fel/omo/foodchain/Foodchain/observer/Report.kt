package cz.cvut.fel.omo.foodchain.Foodchain.observer


import cz.cvut.fel.omo.foodchain.Foodchain.visitor.Export
import cz.cvut.fel.omo.foodchain.Foodchain.visitor.ExportVisitor
import cz.cvut.fel.omo.foodchain.Foodchain.visitor.Visitor
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


object Report : Observer, Export {

    private val visitor = ExportVisitor()

    override fun accept(visitor: Visitor) = visitor.visit(export = this)

    /*fun export() {
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
    }*/

    fun prepareForExport() {
        accept(visitor)
    }


    private var reports = hashMapOf<UUID, ArrayList<String>>()


    override fun update(uuid: UUID, report: String) {
        if (!reports.containsKey(uuid)) {
            val newReport: ArrayList<String> = ArrayList()
            newReport.add(report)
            reports[uuid] = newReport
        } else if(reports.containsKey(uuid)) {
            reports[uuid]?.add(report)
        }
    }

    fun getReports(): HashMap<UUID, ArrayList<String>> {
        return reports;
    }
}