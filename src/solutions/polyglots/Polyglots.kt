package solutions.polyglots

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/polyglots">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val studentsCount = reader.readLine().toInt()
    val students = List(studentsCount) {
        val count = reader.readLine().toInt()
        List(count) {
            reader.readLine()
        }.toSet()
    }

    val res = polyglots(students)
    writer.println(res.first.size)
    res.first.forEach { writer.println(it) }
    writer.println(res.second.size)
    res.second.forEach { writer.println(it) }

    reader.close()
    writer.close()
}

private fun polyglots(students: List<Set<String>>): Pair<Set<String>, Set<String>> =
    Pair(
        students.reduce { acc, set -> acc intersect set },
        students.reduce { acc, set -> acc union set }
    )

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}