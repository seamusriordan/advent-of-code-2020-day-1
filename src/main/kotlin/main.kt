import java.util.stream.IntStream.range

fun main() {
    println("Hello World!")
}

fun find2020Sum(entries: List<Int>): Pair<Int, Int> {
    val sumIndex = entries.indices
        .first{ i -> entries[i] + entries[i+1] == 2020 }
    return Pair(entries[sumIndex], entries[sumIndex+1])
}