package solutions.metro

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private const val ON_PLATFORM_TIME = 1

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val interval1 = reader.readLine().toInt()
    val interval2 = reader.readLine().toInt()
    val count1 = reader.readLine().toInt()
    val count2 = reader.readLine().toInt()

    val res = metro(interval1, interval2, count1, count2)
    writer.println(res?.let { "${res.first} ${res.second}" } ?: -1)

    reader.close()
    writer.close()
}

private fun metro(interval1: Int, interval2: Int, count1: Int, count2: Int): Pair<Int, Int>? {
    val minTime1 = interval1 * (count1 - 1) + ON_PLATFORM_TIME * count1
    val maxTime1 = minTime1 + interval1 * 2
    val minTime2 = interval2 * (count2 - 1) + ON_PLATFORM_TIME * count2
    val maxTime2 = minTime2 + interval2 * 2

    return if (minTime1 > maxTime2 || maxTime1 < minTime2)
        null
    else
        Pair(maxOf(minTime1, minTime2), minOf(maxTime1, maxTime2))
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}