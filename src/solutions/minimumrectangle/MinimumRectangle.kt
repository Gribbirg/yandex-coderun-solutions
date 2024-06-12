package solutions.minimumrectangle

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/minimum-rectangle">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val count = reader.readLine().trim().toInt()
    val points = List(count) {
        reader.readLine().trim().split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) }
    }

    val res = minimumRectangle(points)
    writer.println("${res.first.first} ${res.first.second} ${res.second.first} ${res.second.second}")

    reader.close()
    writer.close()
}

private fun minimumRectangle(points: List<Pair<Int, Int>>) =
    Pair(
        Pair(
            points.minOf { it.first },
            points.minOf { it.second }
        ),
        Pair(
            points.maxOf { it.first },
            points.maxOf { it.second }
        )
    )

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}