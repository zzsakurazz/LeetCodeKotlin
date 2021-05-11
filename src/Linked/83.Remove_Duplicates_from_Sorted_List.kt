package Linked

/**
 * @author zhangzheng
 * @Date  2021/5/7 下午5:36
 * @ClassName `83.Remove_Duplicates_from_Sorted_List`
 * <p>
 * Desc :删除链表中重复的元素
 */
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
// 返回同样按升序排列的结果链表。
//
//
//
// 示例 1：
//
//
//输入：head = [1,1,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序排列
//
// Related Topics 链表
// 👍 570 👎 0

//一边循环
fun deleteDuplicates(head: ListNode?): ListNode? {
    var curr=head
    while (curr?.next!=null){
        if(curr.next?.`val`== curr.`val`){
            curr.next=curr.next?.next
        }else{
            curr=curr.next
        }
    }
    return head
}
