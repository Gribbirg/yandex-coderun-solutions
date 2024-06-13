package solutions.numberwordstext

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/number-words-text">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val text = reader.readText()

    val res = numberWordsText(text)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun numberWordsText(text: String): Int =
    text.split(" ", "\n").filter { it.isNotEmpty() }.toSet().size


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}

private fun <T> List<T>.toPair(): Pair<T, T> {
    require(size == 2) { "Incorrect size" }
    return Pair(first(), last())
}