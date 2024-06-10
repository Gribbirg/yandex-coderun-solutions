package solutions.frequentword

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val text = reader.readText()

    val res = frequentWord(text)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun frequentWord(text: String): String {
    val words = text.replace("\n", " ").trim().split(" ").filter { it.isNotEmpty() }
    val map = mutableMapOf<String, Int>()
    words.forEach { word ->
        map[word] = map.getOrDefault(word, 0) + 1
    }
    return map.entries.maxWith { o1, o2 ->
        if (o1.value != o2.value) o1.value.compareTo(o2.value)
        else o2.key.compareTo(o1.key)
    }.key
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}