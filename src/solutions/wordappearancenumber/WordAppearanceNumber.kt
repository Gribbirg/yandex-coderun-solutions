package solutions.wordappearancenumber

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/word-appearance-number">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val text = reader.readText()

    val res = wordAppearanceNumber(text)
    writer.println(res.joinToString(" "))

    reader.close()
    writer.close()
}

private fun wordAppearanceNumber(text: String): List<Int> {
    val res = mutableListOf<Int>()
    val map = mutableMapOf<String, Int>()

    text.replace("\n", " ")
        .split(" ")
        .filter { it.isNotEmpty() }
        .forEach { word ->
            val count = map.getOrDefault(word, 0)
            res.add(count)
            map[word] = count + 1
        }

    return res
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}