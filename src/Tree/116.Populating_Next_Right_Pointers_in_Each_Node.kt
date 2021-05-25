package Tree

/**
 * @author zhangzheng
 * @Date  2021/5/21 上午11:23
 * @ClassName `116.Populating_Next_Right_Pointers_in_Each_Node`
 * <p>
 * Desc :填充每个节点的下一个右侧节点指针
 */
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
//next 指针连接，'#' 标志着每一层的结束。
//
//
//
//
// 提示：
//
//
// 树中节点的数量少于 4096
// -1000 <= node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 463 👎 0

//前序遍历递归
//时间复杂度O(n) 空间复杂度O(m) 和树的深度相关

fun connect(root: Node?): Node? {
    if (root == null) return null
    //将root的左右连接起来
    if (root.left != null) {
        root.left?.next = root.right
    }
    //利用上一层的next将root的右与root的相邻节点的left连接起来
    if (root.next != null && root.right != null) {
        root.right?.next = root.next?.left
    }
    //递归循环
    connect(root.left)
    connect(root.right)
    return root
}
