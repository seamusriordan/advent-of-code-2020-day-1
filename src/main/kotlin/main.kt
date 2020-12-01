import java.io.File

fun main() {
    val inputData: ArrayList<Int> = ArrayList()
    File("src/main/resources/input.txt").forEachLine {
        inputData.add(it.toInt())
    }

    val pair = find2020Sum(inputData)
    println(pair.first*pair.second!!)
}

fun find2020Sum(entries: List<Int>): Pair<Int, Int?> {
    return entries.mapIndexed { index, entry ->
        val matchingPair = find2020PairTo(entry, getRemainingEntriesFrom(entries, index))
        Pair(entry, matchingPair)
    }.first {
        pair -> pair.second != null
    }
}

private fun getRemainingEntriesFrom(entries: List<Int>, index: Int): List<Int> {
    return entries.subList(index + 1, entries.size)
}

private fun find2020PairTo(addend: Int, possiblePairs: List<Int>): Int? {
    return possiblePairs.firstOrNull { trial -> addend + trial == 2020 }
}