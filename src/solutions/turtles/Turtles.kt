package solutions.turtles

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val count = reader.readLine().trim().toInt()
    val turtles = List(count) {
        reader.readLine()
            .trim()
            .split(" ")
            .map { it.toInt() }
            .let { Pair(it[0], it[1]) }
    }

    val res = turtles(turtles)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun turtles(turtles: List<Pair<Int, Int>>): Int =
    turtles.toSet().count { it.first >= 0 && it.second >= 0 && it.first + it.second == turtles.size - 1 }

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}