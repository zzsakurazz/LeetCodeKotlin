package Tree

/**
 * @author zhangzheng
 * @Date  2021/5/17 下午3:42
 * @ClassName TreeNode
 * <p>
 * Desc :
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}