package Linked

/**
 * @author zhangzheng
 * @Date  2021/4/2 下午10:17
 * @ClassName `92.Reverse_Linked_List_2`
 * <p>
 * Desc :反转指定位置的链表
 */
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//
// 进阶： 你可以使用一趟扫描完成反转吗？
// Related Topics 链表
// 👍 844 👎 0

//时间复杂度：O(n) 空间复杂度：O(1)
fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    val dummp=ListNode(-1)
    dummp.next=head
    var preNode:ListNode?=dummp
    val leftNode: ListNode?
    var rightNode: ListNode?
    val currNode: ListNode?
    //找到最左边的pre节点
    for(i in 0 until left-1){
        preNode= preNode?.next
    }
    leftNode=preNode?.next
    rightNode=preNode?.next
    //找到最右边的curr节点
    for (i in 0 until(right-left)){
        rightNode=rightNode?.next
    }
    //将left和right之间的链表截取下来并通过reverseLinkedList进行反转
    currNode=rightNode?.next
    rightNode?.next=null
    reverseLinkedList(leftNode)
    //反转结束后在链接上pre节点和curr节点
    preNode?.next=rightNode
    leftNode?.next=currNode
    return dummp.next
}

fun reverseLinkedList(head: ListNode?) {
    var pre: ListNode? = null
    var cur: ListNode? = head
    while (cur != null) {
        val next: ListNode? = cur.next
        cur.next = pre
        pre = cur
        cur = next
    }
}