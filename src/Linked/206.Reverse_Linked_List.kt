package Linked

/**
 * @author zhangzheng
 * @Date  2021/3/3 下午5:21
 * @ClassName `206.Reverse_Linked_List`
 * <p>
 * Desc :反转链表
 */
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1544 👎 0


/**
 * 双指针方法
 */
fun reverseList(head: ListNode?): ListNode? {
    var left: ListNode? = null
    var right = head
    while (right != null) {
        val temp = right.next
        right.next = left
        left = right
        right = temp
    }
    return left
}

/**
 * 递归
 */
fun recursion(head: ListNode?): ListNode?{
    if(head?.next==null) return head
    //这里的递归是为了找到最后一个节点
    val last=reverseList(head.next)
    head.next?.next=head
    head.next=null
    return last
}
