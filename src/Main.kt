import Linked.ListNode


/**
 * @author zhangzheng
 * @Date  2021/4/11 下午10:41
 * @ClassName Main
 * <p>
 * Desc :
 */

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)
    val node7 = ListNode(7)
    val node8 = ListNode(8)
    val node9 = ListNode(9)
    val node10 = ListNode(10)
    val node11 = ListNode(11)
    node1.next=node2
    node2.next=node3
    node3.next=node4
    node4.next=node5
    node5.next=node6
    node6.next=node7
    node7.next=node8
    node8.next=node9
    node9.next=node10
    node10.next=node11
    println("${kthToLast(node1,2)}")
}


fun kthToLast(head: ListNode?, k: Int): Int {

    var fast=head
    var slow=head
    var index=0
    while (fast!=null){
        if(index>=k){
            slow=slow?.next
        }
        fast=fast.next
        index++
    }
    return slow?.`val`?:-1
}