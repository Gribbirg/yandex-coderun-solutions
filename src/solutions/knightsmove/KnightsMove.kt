package solutions.knightsmove

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (rowsCount, columnCount) = reader.readLine().split(" ").map { it.toInt() }

    writer.write(knightsMove(rowsCount, columnCount).toString())

    reader.close()
    writer.close()
}

private fun knightsMove(rowsCount: Int, columnCount: Int): Int {
    val field = Array(rowsCount) { IntArray(columnCount) }

    field[0][0] = 1

    for (i in field.indices) {
        for (j in field[i].indices) {
            for (step in STEPS) {
                if (i + step.first < rowsCount && j + step.second < columnCount) {
                    field[i + step.first][j + step.second] += field[i][j]
                }
            }
        }
    }

    return field.last().last()
}

private val STEPS = listOf(
    Pair(2, 1),
    Pair(1, 2),
)