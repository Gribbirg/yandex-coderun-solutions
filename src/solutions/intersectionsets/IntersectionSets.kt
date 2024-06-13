package solutions.intersectionsets

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/intersection-sets">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val set1 = reader.readLine().trim().split(" ").map { it.toInt() }.toSet()
    val set2 = reader.readLine().trim().split(" ").map { it.toInt() }.toSet()

    val res = intersectionSets(set1, set2)
    writer.println(res.joinToString(separator = " "))

    reader.close()
    writer.close()
}

private fun intersectionSets(set1: Set<Int>, set2: Set<Int>): Set<Int> =
    (set1 intersect set2).toSortedSet()


// Template functions
private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}

private fun <T> List<T>.toPair(): Pair<T, T> {
    require(size == 2) { "Incorrect size" }
    return Pair(first(), last())
}