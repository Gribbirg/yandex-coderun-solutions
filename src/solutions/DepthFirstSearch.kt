package solutions

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (nodesCount, edgesCount) = reader.readLine().split(" ").map { it.toInt() }
    val nodes = List(nodesCount) { TreeNode(it + 1) }
    repeat(edgesCount) {
        val (node1val, node2val) = reader.readLine().split(" ").map { it.toInt() - 1 }
        nodes[node1val].children.add(nodes[node2val])
        nodes[node2val].children.add(nodes[node1val])
    }

    val res = depthFirstSearch(nodes)
    writer.write(res.size.toString())
    writer.newLine()
    writer.write(res.joinToString(separator = " ") { it.`val`.toString() })

    reader.close()
    writer.close()
}

private fun depthFirstSearch(nodes: List<TreeNode>): List<TreeNode> {
    val visited = mutableSetOf<TreeNode>()

    fun dfs(node: TreeNode) {
        visited.add(node)
        node.children.forEach {
            if (it !in visited) {
                dfs(it)
            }
        }
    }

    dfs(nodes[0])
    return visited.sortedBy { it.`val` }.toList()
}

private data class TreeNode(val `val`: Int) {
    val children = mutableListOf<TreeNode>()
}