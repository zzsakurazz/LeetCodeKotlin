package Linked

/**
 * @author zhangzheng
 * @Date  2021/3/3 下午3:13
 * @ClassName Remove_Linked_List_Elements
 * <p>
 * Desc :移除链表元素
 */
//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
// 👍 541 👎 0

/**
 * 双指针的方式
 */
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    //添加哨兵节点
    val prev = ListNode(-1)
    prev.next = head
    var left = prev
    var right = prev.next
    while (right != null) {
        if (right.`val` == `val`) {
            left.next = right.next
        } else {
            left = right
        }
        right = right.next
    }
    return prev.next
}

/**
 * 递归的方式(不推荐)
 */
fun removeElementsForRecursion(head: ListNode?, `val`: Int): ListNode? {
    return if (head == null) {
        null
    } else {
        head.next = removeElementsForRecursion(head.next, `val`)
        if (head.`val` == `val`) {
            head.next
        } else {
            head
        }
    }
}

