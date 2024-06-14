package solutions.allpathsleadtorome

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/all-paths-lead-to-rome">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (verticesCount, edgesCount) = reader.readLine().split(" ").map { it.toInt() }
    val vertices = List(verticesCount) { Vertex(it) }
    repeat(edgesCount) {
        val (from, to) = reader.readLine().split(" ").map { it.toInt() - 1 }
        vertices[from].from.add(vertices[to])
        vertices[to].to.add(vertices[from])
    }

    val res = allPathsLeadToRome(vertices)
    writer.println(res?.`val`?.plus(1) ?: -1)

    reader.close()
    writer.close()
}

private fun allPathsLeadToRome(vertices: List<Vertex>): Vertex? =
    vertices.filter {
        it.from.isEmpty() && it.to.size == vertices.size - 1
                || it.from.size == 1 && it.from.first() == it && it.to.size == vertices.size
    }.let { if (it.size == 1) it.first() else null }

private data class Vertex(
    val `val`: Int,
    val from: MutableSet<Vertex> = mutableSetOf(),
    val to: MutableSet<Vertex> = mutableSetOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vertex

        return `val` == other.`val`
    }

    override fun hashCode(): Int {
        return `val`
    }
}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}

