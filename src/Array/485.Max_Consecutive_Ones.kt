/**
 * @author zhangzheng
 * @Date  2021/2/19 下午2:00
 * @ClassName `485.Max_Consecutive_Ones`
 * <p>
 * Desc :最大连续 1 的个数
 */
//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
//
//
// 示例：
//
//
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//
//
//
// 提示：
//
//
// 输入的数组只包含 0 和 1 。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组
// 👍 202 👎 0

/**
 * 循环计算
 */
fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var max = 0
    var count = 0
    for (element in nums) {
        if (element == 0) {
            max = max.coerceAtLeast(count)
            count = 0
        } else {
            count++
        }
    }
    return max.coerceAtLeast(count)
}