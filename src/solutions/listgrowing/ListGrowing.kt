package solutions.listgrowing

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/list-growing">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    val res = listGrowing(nums)
    writer.println(Answer.get(res))

    reader.close()
    writer.close()
}

private fun listGrowing(nums: List<Int>): Boolean = (1..nums.lastIndex).all { nums[it] > nums[it - 1] }

private enum class Answer {
    YES, NO;

    companion object {
        fun get(ans: Boolean) =
            if (ans) YES else NO
    }
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}