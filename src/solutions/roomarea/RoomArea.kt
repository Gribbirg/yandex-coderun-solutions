package solutions.roomarea

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/room-area">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val size = reader.readLine().toInt()
    val field = List(size) {
        reader
            .readLine()
            .toCharArray()
            .map {
                AreaData.getByChar(it)
            }
    }
    val start = reader.readLine().split(" ").map { it.toInt() - 1 }.let { Pair(it[0], it[1]) }

    val res = roomArea(field, start)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun roomArea(field: List<List<AreaData>>, start: Pair<Int, Int>): Int {
    val calcField = field.map { it.toTypedArray() }.toTypedArray()
    var size = 0

    fun fill(pos: Pair<Int, Int>) {
        if (calcField[pos.first][pos.second] == AreaData.FREE) {
            size++
            calcField[pos.first][pos.second] = AreaData.CALCULATED
            DIRECTIONS.forEach { dir ->
                fill(Pair(pos.first + dir.first, pos.second + dir.second))
            }
        }
    }

    fill(start)
    return size
}

private val DIRECTIONS = listOf(
    Pair(0, 1),
    Pair(1, 0),
    Pair(0, -1),
    Pair(-1, 0),
)

private enum class AreaData(val char: Char) {
    WALL('*'),
    FREE('.'),
    CALCULATED('C'), ;

    companion object {
        fun getByChar(char: Char) = AreaData.entries.first { it.char == char }
    }
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}