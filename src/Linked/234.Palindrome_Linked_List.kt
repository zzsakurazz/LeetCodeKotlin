package Linked

/**
 * @author zhangzheng
 * @Date  2021/5/11 下午5:58
 * @ClassName `234.Palindrome_Linked_List`
 * <p>
 * Desc :回文链表
 */
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 971 👎 0

// 左侧指针
var left: ListNode? = null

fun isPalindrome(head: ListNode?): Boolean {
    left = head
    return traverse(head)
}

//递归的方式来解决
fun traverse(right: ListNode?): Boolean {
    if (right == null) return true
    var res = traverse(right.next)
    // 后序遍历代码
    res = res && right.`val` == left!!.`val`
    left = left!!.next
    return res
}