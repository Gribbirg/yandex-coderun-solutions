package solutions.summofthevarious

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/summ-of-the-various">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val nums = reader.readLine().split(" ").map { it.toLong() }

    val res = summOfTheVarious(nums)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun summOfTheVarious(nums: List<Long>): Long =
    nums.toSet().sum()


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}