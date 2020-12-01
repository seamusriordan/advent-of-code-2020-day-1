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
    return findPairThatSums(2020, entries)
}

fun findPairThatSums(sum: Int, entries: List<Int>): Pair<Int, Int?> {
    return entries.mapIndexed { index, entry ->
        val matchingPair = findPairTo(sum, entry, getRemainingEntriesFrom(entries, index))
        Pair(entry, matchingPair)
    }.first {
            pair -> pair.second != null
    }
}

private fun getRemainingEntriesFrom(entries: List<Int>, index: Int): List<Int> {
    return entries.subList(index + 1, entries.size)
}

private fun findPairTo(sum: Int, addend: Int, possiblePairs: List<Int>): Int? {
    return possiblePairs.firstOrNull { trial -> addend + trial == sum }
}

fun find2020Triple(entries: List<Int>): Triple<Int, Int, Int> {
    val sublist = getRemainingEntriesFrom(entries, entries.size-4)
    return Triple(sublist[0], sublist[1], sublist[2])
}