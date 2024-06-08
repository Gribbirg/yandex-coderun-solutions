package solutions.connectivitycomponents

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

    val res = connectivityComponents(nodes)
    writer.println(res.size)
    res.forEach {
        writer.println(it.size)
        writer.println(it.joinToString(" ") { node -> node.`val`.toString() })
    }

    reader.close()
    writer.close()
}

private fun connectivityComponents(nodes: List<TreeNode>): List<List<TreeNode>> {
    val notVisited = nodes.toMutableSet()
    val components = mutableListOf<MutableList<TreeNode>>()

    fun dfs(node: TreeNode) {
        notVisited.remove(node)
        components.last().add(node)
        node.children.forEach {
            if (it in notVisited) {
                dfs(it)
            }
        }
    }

    while (notVisited.isNotEmpty()) {
        components.add(mutableListOf())
        dfs(notVisited.first())
    }

    return components.map { it.sortedBy { node -> node.`val` } }
}

private data class TreeNode(val `val`: Int) {
    val children = mutableListOf<TreeNode>()
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}