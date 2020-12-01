import java.io.File

fun main() {
    val inputData: ArrayList<Int> = ArrayList()
    File("src/main/resources/input.txt").forEachLine {
        inputData.add(it.toInt())
    }

    val pair = find2020SumPair(inputData)
    println(pair.first * pair.second!!)

    val triple = find2020SumTriple(inputData)!!
    println(triple.first * triple.second * triple.third)
}

fun find2020SumPair(entries: List<Int>): Pair<Int, Int?> {
    return findPairThatSumsTo(2020, entries)!!
}

fun findPairThatSumsTo(sum: Int, entries: List<Int>): Pair<Int, Int>? {
    val pair = entries.mapIndexed { index, entry ->
        val matchingPair = findMatchingSumPair(sum, entry, getRemainingEntriesFrom(entries, index))
        Pair(entry, matchingPair)
    }.firstOrNull { pair ->
        pair.second != null
    } ?: return null
    return Pair(pair.first, pair.second!!)
}

private fun getRemainingEntriesFrom(entries: List<Int>, index: Int): List<Int> {
    return entries.subList(index + 1, entries.size)
}

private fun findMatchingSumPair(sum: Int, addend: Int, possiblePairs: List<Int>): Int? {
    return possiblePairs.firstOrNull { trial -> addend + trial == sum }
}

fun find2020SumTriple(entries: List<Int>): Triple<Int, Int, Int>? {
    val triple = entries.mapIndexed { index, entry ->
        val remaining = getRemainingEntriesFrom(entries, index)
        val pair = findPairThatSumsTo(2020 - entry, remaining)
        Triple(entry, pair?.first, pair?.second)
    }.firstOrNull { triple ->
        triple.second != null && triple.third != null
    } ?: return null
    return Triple(triple.first, triple.second!!, triple.third!!)
}