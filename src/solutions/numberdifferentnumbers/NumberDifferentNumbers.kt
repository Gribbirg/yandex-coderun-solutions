package solutions.numberdifferentnumbers

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/number-different-numbers">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val nums = reader.readLine().split(" ").map { it.toInt() }.toIntArray()

    val res = numberDifferentNumbers(nums)
    writer.println(res)

    reader.close()
    writer.close()
}

fun numberDifferentNumbers(nums: IntArray): Int =
    nums.toSet().size

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}