package Tree

/**
 * @author zhangzheng
 * @Date  2021/5/21 上午10:23
 * @ClassName `226.Invert_Binary_Tree`
 * <p>
 * Desc : 反转二叉树
 */
//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树
// 👍 858 👎 0

//前序遍历
//时间复杂度：O(n) 空间复杂度O(m) 和树的深度相关
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    var temp = root.right
    root.right = root.left
    root.left = temp
    temp = null
    invertTree(root.right)
    invertTree(root.left)
    return root
}
