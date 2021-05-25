package Tree

/**
 * @author zhangzheng
 * @Date  2021/5/17 下午4:01
 * @ClassName `104.Maximum_Depth_of_Binary_Tree`
 * <p>
 * Desc :二叉树最大深度
 */
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 递归
// 👍 878 👎 0

//深度遍历 时间复杂度O(n) 空间复杂度O(m)--和遍历深度有关
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    return Math.max(left, right) + 1 //这里不知道为什么，用了语法糖反而变慢了
}
