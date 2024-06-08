package solutions.cupcowcakethrowing

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val results = reader.readLine().split(" ").map { it.toInt() }

    writer.println(cupCowcakeThrowing(results))

    reader.close()
    writer.close()
}

private fun cupCowcakeThrowing(results: List<Int>): Int {
    val max = results.max()
    val maxIndex = results.indexOf(max)
    if (maxIndex == results.lastIndex) return 0

    val maxCandidate = results.subList(maxIndex + 1, results.lastIndex)
        .filterIndexed { index, result -> result % 10 == 5 && results[index + maxIndex + 2] < result }
        .maxOrNull() ?: return 0

    return results.sortedDescending().indexOf(maxCandidate) + 1
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}