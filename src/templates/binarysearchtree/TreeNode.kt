package templates.binarysearchtree

private class BinarySearchTree {
    var root: TreeNode? = null


    fun add(`val`: Int) {

        fun addNode(current: TreeNode?, node: TreeNode): TreeNode = when {
            current == null -> node
            node.`val` <= current.`val` -> addNode(current.left, node)
            else -> addNode(current.right, node)
        }

        addNode(root, TreeNode(`val`))
    }

    class TreeNode(val `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}