package solutions.pyramid

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/pyramid">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val count = reader.readLine().toInt()
    val blocks = List(count) { reader.readLine().trim().split(" ").map { it.toLong() }.toPair() }

    val res = pyramid(blocks)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun pyramid(blocks: List<Pair<Long, Long>>): Long {
    val map = HashMap<Long, Long>()
    blocks.forEach { block ->
        if ((map[block.first] ?: 0) < block.second) {
            map[block.first] = block.second
        }
    }
    return map.map { it.value }.sum()
}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}

private fun <T> List<T>.toPair(): Pair<T, T> {
    require(size == 2) { "Incorrect size" }
    return Pair(first(), last())
}