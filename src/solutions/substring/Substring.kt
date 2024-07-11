package solutions.substring

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/substring">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val maxCount = reader.readLine().trim().split(" ").last().toInt()
    val s = reader.readLine()

    val res = substring(s, maxCount)
    writer.println("${res.first} ${res.second + 1}")

    reader.close()
    writer.close()
}

private fun substring(s: String, maxCount: Int): Pair<Int, Int> {
    var maxSubstr = Pair(0, 0)
    val chars = mutableMapOf<Char, Int>()
    var start = 0

    s.forEachIndexed { end, char ->
        chars[char] = (chars[char] ?: 0) + 1
        while (chars[char]!! > maxCount) {
            val startChar = s[start++]
            chars[startChar] = chars[startChar]!! - 1
        }

        val len = end - start + 1
        if (len > maxSubstr.first) {
            maxSubstr = Pair(len, start)
        }
    }

    return maxSubstr
}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}