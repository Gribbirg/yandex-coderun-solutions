package solutions.fleas

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val STEPS = listOf(
    Pair(2, 1),
    Pair(2, -1),
    Pair(-2, -1),
    Pair(-2, 1),
    Pair(1, 2),
    Pair(1, -2),
    Pair(-1, -2),
    Pair(-1, 2),
)

private const val NO_ANS = -1

/**
 * @see <a href="https://coderun.yandex.ru/problem/fleas">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (rowsCount, columnsCount, finishRow, finishColumn, fleasCount) =
        reader.readLine().split(" ").map { it.toInt() }
    val fleas = List(fleasCount) {
        reader.readLine().split(" ").map { it.toInt() - 1 }.toPair()
    }

    val res = fleas(Pair(rowsCount, columnsCount), Pair(finishRow - 1, finishColumn - 1), fleas)
    writer.println(res ?: NO_ANS)

    reader.close()
    writer.close()
}

private fun fleas(size: Pair<Int, Int>, finish: Pair<Int, Int>, fleas: List<Pair<Int, Int>>): Int? {
    val field = buildField(size, finish)
    return fleas.sumOf { field[it.first][it.second] ?: return null }
}

private fun buildField(size: Pair<Int, Int>, start: Pair<Int, Int>): List<List<Int?>> {
    val field = List(size.first) { Array<Int?>(size.second) { null } }
    val queue = ArrayDeque<Pair<Int, Int>>().also { it.add(start) }
    val visited = mutableSetOf(start)
    var count = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val pos = queue.removeFirst()
            field[pos.first][pos.second] = count
            STEPS.forEach { step ->
                val newPos = Pair(pos.first + step.first, pos.second + step.second)
                if (newPos.first in field.indices
                    && newPos.second in field[newPos.first].indices
                    && newPos !in visited
                ) {
                    queue.add(newPos)
                    visited.add(newPos)
                }
            }
        }
        count++
    }

    return field.map { it.toList() }
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}

private fun <T> List<T>.toPair(): Pair<T, T> {
    require(size == 2) { "Incorrect size" }
    return Pair(first(), last())
}