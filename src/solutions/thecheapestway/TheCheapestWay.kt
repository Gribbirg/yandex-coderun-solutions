package solutions.thecheapestway

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @see <a href="https://coderun.yandex.ru/problem/cheapest-way">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val rowsCount = reader.readLine().split(" ")[0].toInt()
    val field = Array(rowsCount) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

    println(theCheapestWay(field))

    reader.close()
}

private fun theCheapestWay(field: Array<IntArray>): Int {
    for (i in 1..field[0].lastIndex) {
        field[0][i] += field[0][i - 1]
    }

    for (i in 1..field.lastIndex) {
        field[i][0] += field[i - 1][0]
        for (j in 1..field[0].lastIndex) {
            field[i][j] += minOf(field[i][j - 1], field[i - 1][j])
        }
    }

    return field.last().last()
}