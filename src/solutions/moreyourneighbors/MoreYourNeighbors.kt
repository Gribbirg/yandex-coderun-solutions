package solutions.moreyourneighbors

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/more-your-neighbors">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val nums = reader.readLine().trim().split(" ").map { it.toInt() }.toIntArray()

    val res = moreYourNeighbors(nums)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun moreYourNeighbors(nums: IntArray): Int =
    nums.filterIndexed { i, num ->
        i in 1..<nums.lastIndex && num > nums[i - 1] && num > nums[i + 1]
    }.size

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}