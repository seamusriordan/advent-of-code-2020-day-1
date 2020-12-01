import java.security.InvalidParameterException

fun main() {
    println("Hello World!")
}

fun find2020Sum(entries: List<Int>): Pair<Int, Int> {
    for (i in entries.indices) {
        for (j in i+1 until entries.size) {
            if (entries[i] + entries[j] == 2020)
                return Pair(entries[i], entries[j])
        }
    }
    throw InvalidParameterException()
}