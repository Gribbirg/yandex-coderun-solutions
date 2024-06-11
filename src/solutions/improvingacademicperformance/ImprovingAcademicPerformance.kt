package solutions.improvingacademicperformance

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private const val TARGET = 4
private const val MAX_VALUE = 10000000000000000L


/**
 * @see <a href="https://coderun.yandex.ru/problem/improving-academic-performance">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val count2 = reader.readLine().toLong()
    val count3 = reader.readLine().toLong()
    val count4 = reader.readLine().toLong()

    val res = improvingAcademicPerformance(count2, count3, count4)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun improvingAcademicPerformance(count2: Long, count3: Long, count4: Long): Long {
    var left = 0L
    var right = MAX_VALUE

    while (left < right) {
        val medium = (left + right) / 2
        if (checkMark(count2, count3, count4, medium)) {
            right = medium
        } else {
            left = medium + 1
        }
    }

    return left
}

private fun checkMark(count2: Long, count3: Long, count4: Long, count5: Long): Boolean =
    2 * (count2 * 2 + count3 * 3 + count4 * 4 + count5 * 5) >= (TARGET * 2 - 1) * (count2 + count3 + count4 + count5)

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}