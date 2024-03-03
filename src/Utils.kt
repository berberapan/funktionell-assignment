import java.io.File

fun dataInts(filePath: String): List<Int> {
    val dataList: MutableList<Int> = mutableListOf()
    File(filePath).forEachLine { dataList.add(it.toInt()) }
    return dataList
}

fun dataText(filePath: String): List<String> {
    val dataList: MutableList<String> = mutableListOf()
    File(filePath).forEachLine { dataList.add(it) }
    return dataList
}

fun dataFull(filePath: String): String {
    return File(filePath).readText()
}