package solutions.woods

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/woods">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val height = reader.readLine().split(" ").first().toInt()
    val woods = reader.readLine().split(" ").map { it.toInt() }

    val res = woods(height, woods)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun woods(height: Int, woods: List<Int>): Int {
    var left = 0
    var right = Int.MAX_VALUE
    while (left < right) {
        val medium = (left + right + 1) / 2
        if (check(woods, height, medium)) {
            left = medium
        } else {
            right = medium - 1
        }
    }
    return left
}

private fun check(woods: List<Int>, height: Int, width: Int): Boolean {
    var i = 0

    repeat(height) {
        var currentWidth = 0
        while (currentWidth < width) {
            if (i > woods.lastIndex) {
                return false
            }
            currentWidth += woods[i++]
        }
    }

    return true
}

// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}

