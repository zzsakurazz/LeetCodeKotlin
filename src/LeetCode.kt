import Array.removeElement
import Linked_List.ListNode
import Linked_List.removeElements
import Linked_List.removeElementsForRecursion

/**
 * @author zhangzheng
 * @Date  2021/1/10 下午4:29
 * @ClassName LeetCode
 * <p>
 * Desc :测试
 */

fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(6)
    val l4 = ListNode(5)
    val l5 = ListNode(4)
    val l6 = ListNode(6)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l6
    l6.next = null
    removeElementsForRecursion(l1, 6)
}



