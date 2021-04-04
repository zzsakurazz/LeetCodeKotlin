package Sort

import Linked.ListNode

/**
 * @author zhangzheng
 * @Date  2021/4/4 下午11:37
 * @ClassName `21`
 * <p>
 * Desc :合并两个有序链表
 */
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1639 👎 0
/**
 * 迭代
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val p = ListNode(-1)
    var pp=p
    var pL1 = l1
    var pL2 = l2
    while (pL1 != null && pL2 != null) {
        if (pL1.`val` <= pL2.`val`) {
            pp.next = pL1
            pp= pp.next!!
            pL1 = pL1.next
        } else {
            pp.next = pL2
            pp= pp.next!!
            pL2 = pL2.next
        }
    }
    while (pL1 != null) {
        pp.next = pL1
        pp= pp.next!!
        pL1 = pL1.next
    }
    while (pL2 != null) {
        pp.next = pL2
        pp= pp.next!!
        pL2 = pL2.next
    }
    return p.next
}
