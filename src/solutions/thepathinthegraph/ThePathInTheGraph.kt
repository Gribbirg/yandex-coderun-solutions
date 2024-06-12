package solutions.thepathinthegraph

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/the-path-in-the-graph">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val count = reader.readLine().trim().toInt()
    val nodes = List(count) { TreeNode(it) }
    repeat(count) { from ->
        reader.readLine()
            .trim()
            .split(" ")
            .map { it.toInt() }
            .forEachIndexed { to, value ->
                if (value == TreeNode.IS_EDGE) {
                    nodes[from].children.add(nodes[to])
                }
            }
    }
    val (from, to) = reader.readLine().trim().split(" ").map { nodes[it.toInt() - 1] }

    val res = thePathInTheGraph(from, to)
    if (res == null) {
        writer.println(-1)
    } else {
        writer.println(maxOf(res.size - 1, 0))
        writer.println(res.joinToString(separator = " ") { (it.`val` + 1).toString() })
    }

    reader.close()
    writer.close()
}

private fun thePathInTheGraph(from: TreeNode, to: TreeNode): List<TreeNode>? {
    if (from == to) {
        return listOf()
    }
    val queue = ArrayDeque<MutableList<TreeNode>>()
    val visited = mutableSetOf(from)
    queue.add(mutableListOf(from))

    while (queue.isNotEmpty()) {
        val way = queue.removeFirst()
        way.last().children.forEach { node ->
            val newWay = (way + mutableListOf(node)).toMutableList()
            if (node == to) {
                return newWay
            }
            if (visited.add(node)) {
                queue.add(newWay)
            }
        }
    }
    return null
}

private data class TreeNode(val `val`: Int) {
    val children = mutableListOf<TreeNode>()

    companion object {
        const val IS_EDGE = 1
    }
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}