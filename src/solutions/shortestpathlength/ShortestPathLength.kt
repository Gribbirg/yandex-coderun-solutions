package solutions.shortestpathlength

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/shortest-path-length">Problem</a>
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

    val res = shortestPathLength(from, to) ?: -1
    writer.println(res)

    reader.close()
    writer.close()
}

private fun shortestPathLength(from: TreeNode, to: TreeNode): Int? {
    if (from == to) {
        return 0
    }
    val queue = ArrayDeque<TreeNode>()
    val visited = mutableSetOf(from)
    queue.add(from)
    var count = 1

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            queue.removeFirst().children.forEach { node ->
                if (node == to) {
                    return count
                }
                if (visited.add(node)) {
                    queue.add(node)
                }
            }
        }
        count++
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