package Linked

/**
 * @author zhangzheng
 * @Date  2021/5/12 下午2:08
 * @ClassName Kth_Node_From_End_of_List_LCCI
 * <p>
 * Desc :面试题02.02 返回倒数第 k 个节点
 */
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动
//
// 示例：
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4
//
// 说明：
//
// 给定的 k 保证是有效的。
// Related Topics 链表 双指针
// 👍 68 👎 0

//快慢指针 时间复杂度：O(n) 空间复杂度：O(1)
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

//TODO 递归