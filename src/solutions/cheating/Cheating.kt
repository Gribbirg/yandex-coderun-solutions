package solutions.cheating

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/cheating">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (studentsCount, pairsCount) = reader.readLine().split(" ").map { it.toInt() }
    val students = List(studentsCount) { i -> Student(i) }
    repeat(pairsCount) {
        val (from, to) = reader.readLine().split(" ").map { it.toInt() - 1 }
        students[from].allis.add(students[to])
        students[to].allis.add(students[from])
    }

    val res = cheating(students)
    writer.println(res.msg)

    reader.close()
    writer.close()
}

private fun cheating(students: List<Student>): Answer {

    val set1 = mutableSetOf<Student>()
    val set2 = mutableSetOf<Student>()

    fun markStudents(student: Student, set: MutableSet<Student>, otherSet: MutableSet<Student>) {
        student.allis.forEach {
            if (set.add(it))
                markStudents(it, otherSet, set)
        }
    }

    students.forEach { student ->
        if (student !in set1 && student !in set2) {
            markStudents(student, set1, set2)
        }
    }

    return Answer.get(!students.any { it in set1 && it in set2 })
}

private data class Student(
    val id: Int,
    val allis: MutableSet<Student> = mutableSetOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        return id == other.id
    }

    override fun hashCode(): Int {
        return id
    }
}

private enum class Answer(val msg: String) {
    TRUE("YES"),
    FALSE("NO"), ;

    companion object {
        fun get(res: Boolean): Answer = when (res) {
            true -> TRUE
            false -> FALSE
        }
    }
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}