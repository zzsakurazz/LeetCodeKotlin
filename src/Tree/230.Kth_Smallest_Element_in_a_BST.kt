package Tree

/**
 * @author zhangzheng
 * @Date  2021/6/10 下午3:27
 * @ClassName '230. Kth Smallest Element in a BST'
 * <p>
 * Desc :二叉搜索树中第K小的元素
 *///给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
//
//
//
//
//
// 提示：
//
//
// 树中的节点数为 n 。
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
//
//
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
// Related Topics 树 二分查找
// 👍 400 👎 0


var tempK=0
var res=0
fun kthSmallest(root: TreeNode?, k: Int): Int {
    if(root==null) return -1
    kthSmallest(root.left,k)
    if(++tempK==k){
        res=root.`val`
    }
    kthSmallest(root.right,k)
    return res
}
