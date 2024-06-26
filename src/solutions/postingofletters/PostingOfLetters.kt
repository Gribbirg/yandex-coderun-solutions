package solutions.postingofletters

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/posting-of-letters">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val start = reader.readLine().split(" ")[0].toLong()
    val adr = reader.readLine().split(" ").map { it.toLong() }.toLongArray()

    val res = postingOfLetters(adr, start)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun postingOfLetters(adr: LongArray, start: Long): Long {
    val min = minOf(start, adr.min())
    val max = maxOf(start, adr.max())

    return max - min + minOf(max - start, start - min)
}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}