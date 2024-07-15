package solutions.wires

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/wires">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (startCount, endCount) = reader.readLine().split(" ").map { it.toInt() }
    val wires = List(startCount) { reader.readLine().trim().toInt() }

    val res = wires(wires, endCount)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun wires(wires: List<Int>, count: Int): Int {
    var left = 0
    var right = 10_000_000

    while (left < right) {
        val mid = (left + right + 1) / 2

        if (isPossible(wires, count, mid)) {
            left = mid
        } else {
            right = mid - 1
        }
    }

    return left
}

private fun isPossible(wires: List<Int>, count: Int, len: Int): Boolean =
    wires.sumOf { it / len } >= count


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}
