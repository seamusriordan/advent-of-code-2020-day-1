import java.security.InvalidParameterException

fun main() {
    println("Hello World!")
}

fun find2020Sum(entries: List<Int>): Pair<Int, Int> {
    for (i in entries.indices) {
        val pair2020 = find2020PairTo(entries[i], entries.subList(i+1, entries.size))

        if (pair2020 != null)
            return Pair(entries[i], pair2020)
    }
    throw InvalidParameterException()
}

fun find2020PairTo(addend: Int, possiblePairs: List<Int>): Int? {
    return possiblePairs.firstOrNull { trial -> addend + trial == 2020 }
}