package solutions.hardestletter

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/hardest-letter">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val line = reader.readLine()
    val times = reader.readLine().split(" ").map { it.toInt() }

    val res = hardestLetter(line, times)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun hardestLetter(line: String, times: List<Int>): Char {
    var sum = 0
    val charTimes = times.map { time -> (time - sum).also { sum += it } }
    return line[charTimes.lastIndexOf(charTimes.max())]
}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}