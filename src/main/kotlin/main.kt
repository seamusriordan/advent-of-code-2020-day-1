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
    val pair = entries.indices.map { index ->
        formPossiblePairs(entries, index, sum)
    }.firstOrNull { pair ->
        !doesPairHaveNull(pair)
    } ?: return null
    return Pair(pair.first, pair.second!!)
}

fun find2020SumTriple(entries: List<Int>): Triple<Int, Int, Int>? {
    val triple = entries.indices.map { index ->
        formPossible2020Triples(entries, index)
    }.firstOrNull { triple ->
        !doesTripleHaveNull(triple)
    } ?: return null
    return Triple(triple.first, triple.second!!, triple.third!!)
}

private fun formPossiblePairs(entries: List<Int>, index: Int, sum: Int): Pair<Int, Int?> {
    val entry = entries[index]
    val remaining = getRemainingEntriesFrom(entries, index)
    val matchingPair = findMatchingSumPair(sum, entry, remaining)
    return Pair(entry, matchingPair)
}

private fun getRemainingEntriesFrom(entries: List<Int>, index: Int): List<Int> {
    return entries.subList(index + 1, entries.size)
}

private fun findMatchingSumPair(sum: Int, addend: Int, possiblePairs: List<Int>): Int? {
    return possiblePairs.firstOrNull { trial -> addend + trial == sum }
}

private fun formPossible2020Triples(entries: List<Int>, index: Int): Triple<Int, Int?, Int?> {
    return formPossibleTriplesForSum(entries, index, 2020)
}

private fun formPossibleTriplesForSum(entries: List<Int>, index: Int, sum: Int): Triple<Int, Int?, Int?> {
    val entry = entries[index]
    val remaining = getRemainingEntriesFrom(entries, index)
    val remainder = sum - entry
    val pair = findPairThatSumsTo(remainder, remaining)
    return Triple(entry, pair?.first, pair?.second)
}

private fun doesPairHaveNull(pair: Pair<Int, Int?>): Boolean {
    return pair.second == null
}

private fun doesTripleHaveNull(triple: Triple<Int, Int?, Int?>): Boolean {
    return triple.second == null || triple.third == null
}