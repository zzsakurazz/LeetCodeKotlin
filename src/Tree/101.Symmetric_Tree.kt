package Tree

/**
 * @author zhangzheng
 * @Date  2021/5/19 下午4:28
 * @ClassName `101.Symmetric_Tree`
 * <p>
 * Desc :对称二叉树
 */
//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 1383 👎 0

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    return check(root.left, root.right)
}

//递归
fun check(rootLeft: TreeNode?, rootRight: TreeNode?): Boolean {
    if (rootLeft == null && rootRight == null) {
        return true
    }
    if (rootLeft == null || rootRight == null) {
        return false
    }
    if (rootLeft.`val` != rootRight.`val`) {
        return false
    }
    return check(rootLeft.left, rootRight.right) && check(rootLeft.left, rootRight.right)
}