package Linked

/**
 * @author zhangzheng
 * @Date  2021/5/14 上午10:42
 * @ClassName `2.Add_Two_Numbers`
 * <p>
 * Desc :两数之和
 */
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 6184 👎 0

//时间复杂度：O(n) 空间复杂度：O(1)
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy =ListNode(-1)
    var hand =dummy
    var cursorL1 = l1
    var cursorL2 = l2
    var carry = 0
    while (cursorL1 != null || cursorL2 != null) {
        //可以优化
        if(cursorL1!=null&& cursorL2 != null){
            var sun=carry+ (cursorL1.`val` +cursorL2.`val`)
            if(sun>9){
                sun -= 10
                carry=1
            }else{
                carry=0
            }
            hand.next=ListNode(sun)
            cursorL2= cursorL2.next
            cursorL1= cursorL1.next
        } else if (cursorL1 == null&&cursorL2!=null) {
            val sun=carry+ (cursorL2.`val`)
            if(sun>9){
                carry=1
                hand.next=ListNode(0)
            }else{
                carry=0
                hand.next=ListNode(sun)
            }
            cursorL2= cursorL2.next
        } else if (cursorL2 == null&&cursorL1!=null) {
            val sun=carry+ (cursorL1.`val` )
            if(sun>9){
                carry=1
                hand.next=ListNode(0)
            }else{
                carry=0
                hand.next=ListNode(sun)
            }
            cursorL1= cursorL1.next
        }
        hand= hand.next!!
    }
    if(carry>0){
        hand.next=ListNode(1)
        hand= hand.next!!
    }
    return dummy.next
}