package solutions.triangles

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val count = reader.readLine().trim().toInt()
    val points = List(count) {
        reader.readLine()
            .trim()
            .split(" ")
            .map { it.toInt() }
            .let { Pair(it[0], it[1]) }
    }

    val res = triangles(points)
    writer.println(res)

    reader.close()
    writer.close()
}

fun triangles(points: List<Pair<Int, Int>>) = points.sumOf { point1 ->
    var count = 0
    val map = mutableMapOf<Double, MutableList<Pair<Int, Int>>>()
    points.forEach { point2 ->
        val distance = (point1.first - point2.first).toDouble().pow(2) +
                (point1.second - point2.second).toDouble().pow(2)

        if (map.containsKey(distance)) {

            map[distance]!!.forEach { point3 ->
                if ((point3.second - point1.second) * (point2.first - point1.first) !=
                    (point3.first - point1.first) * (point2.second - point1.second)
                ) {
                    count++
                }
            }

            map[distance]!!.add(point2)
        } else {
            map[distance] = mutableListOf(point2)
        }
    }
    return@sumOf count
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}