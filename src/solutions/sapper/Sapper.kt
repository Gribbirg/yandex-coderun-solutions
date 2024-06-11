package solutions.sapper

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val DIRECTIONS = listOf(
    Pair(1, 0),
    Pair(0, 1),
    Pair(-1, 0),
    Pair(0, -1),
    Pair(1, 1),
    Pair(-1, -1),
    Pair(1, -1),
    Pair(-1, 1),
)

/**
 * @see <a href="https://coderun.yandex.ru/problem/sapper">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (rowsCount, columnsCount, bombsCount) = reader.readLine().split(" ").map { it.toInt() }
    val field = Array(rowsCount) { Array<FieldPoint>(columnsCount) { FieldPoint.NoBomb() } }
    repeat(bombsCount) {
        val (i, j) = reader.readLine().split(" ").map { it.toInt() - 1 }
        field[i][j] = FieldPoint.Bomb()
    }

    val res = sapper(field)
    res.forEach { row ->
        writer.println(row.joinToString(" ") { it.msg })
    }

    reader.close()
    writer.close()
}

private fun sapper(field: Array<Array<FieldPoint>>): Array<Array<FieldPoint>> {
    field.forEachIndexed { i, row ->
        row.forEachIndexed { j, point ->
            if (point is FieldPoint.Bomb) {
                for (direction in DIRECTIONS) {
                    val newI = i + direction.first
                    val newJ = j + direction.second
                    if (newI in field.indices && newJ in row.indices && field[newI][newJ] !is FieldPoint.Bomb) {
                        field[newI][newJ] =
                            FieldPoint.NearBombs(
                                if (field[newI][newJ] is FieldPoint.NoBomb) 1
                                else (field[newI][newJ] as FieldPoint.NearBombs).count + 1
                            )
                    }
                }
            }
        }
    }
    return field
}

private sealed class FieldPoint(val msg: String) {
    class Bomb : FieldPoint("*")
    data class NearBombs(val count: Int) : FieldPoint(count.toString())
    class NoBomb : FieldPoint("0")
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}