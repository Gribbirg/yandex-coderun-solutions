package solutions.rletest

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/rle-test">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val code = reader.readLine()

    val res = rleTest(code)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun rleTest(code: String): Int =
    code.split(*('A'..'Z').toList().toCharArray()).sumOf { if (it.isEmpty()) 1 else it.toInt() } - 1


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}