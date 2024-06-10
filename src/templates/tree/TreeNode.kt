package templates.tree

private data class TreeNode(val `val`: Int) {
    val children = mutableListOf<TreeNode>()
}