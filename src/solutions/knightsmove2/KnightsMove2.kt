package solutions.knightsmove2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (rowsCount, columnCount) = reader.readLine().split(" ").map { it.toInt() }

    writer.println(knightsMove(rowsCount, columnCount))

    reader.close()
    writer.close()
}

private fun knightsMove(rowsCount: Int, columnCount: Int): BigInteger {
    val field = Array(rowsCount) { arrayOfNulls<BigInteger?>(columnCount) }

    field[0][0] = BigInteger.ONE

    fun find(i: Int, j: Int): BigInteger =
        STEPS.sumOf { step ->
            val newI = i + step.first
            val newJ = j + step.second
            return@sumOf if (newI in field.indices && newJ in field[newI].indices)
                field[newI][newJ] ?: find(newI, newJ) else BigInteger.ZERO
        }.also { field[i][j] = it }

    return find(rowsCount - 1, columnCount - 1)
}

private val STEPS = listOf(
    Pair(-2, -1),
    Pair(-1, -2),
    Pair(1, -2),
    Pair(-2, 1),
)

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}