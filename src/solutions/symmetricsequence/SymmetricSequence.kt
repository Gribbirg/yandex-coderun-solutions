package solutions.symmetricsequence

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/symmetric-sequence">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val nums = reader.readLine().trim().split(" ").map { it.toInt() }.toIntArray()

    val res = symmetricSequence(nums)
    writer.println(res.size)
    writer.println(res.joinToString(" "))

    reader.close()
    writer.close()
}

private fun symmetricSequence(nums: IntArray): IntArray {
    val seq = mutableListOf(*nums.toTypedArray())
    val size = nums.size
    var count = 0
    while (!isPalindromic(seq)) {
        seq.add(size, nums[count])
        count++
    }
    return seq.subList(nums.size, seq.size).toIntArray()
}

private fun isPalindromic(list: List<Int>) = list == list.reversed()

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}