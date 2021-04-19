package Linked

/**
 * @author zhangzheng
 * @Date  2021/4/19 上午11:36
 * @ClassName `19`
 * <p>
 * Desc :删除链表的倒数第N个节点
 */
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1323 👎 0

//双指针解法，一边循环即可
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    //哨兵节点
    val dummy = ListNode(-1)
    dummy.next = head
    //快指针
    var fast = head
    //慢指针
    var slow: ListNode? = dummy
    var index = 0
    while (fast != null) {
        //这里是为了能让慢指针
        if (index < n) {
            index++
        } else {
            slow = slow?.next
        }
        fast = fast.next
    }
    //如果index找到了目标节点的上一个元素
    if (index == n) {
        slow?.next = slow?.next?.next
    }
    return dummy.next
}