package Dynamic_Programming

/**
 * @author zhangzheng
 * @Date  2021/4/11 下午7:07
 * @ClassName `70`
 * <p>
 * Desc :爬楼梯
 */
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1593 👎 0

//动态规划---斐波那契数列
//时间复杂度：O(n)  空间复杂度：O(1)
fun climbStairs(n: Int): Int {
    if (n <= 1) return 1
    var a = 1
    var b = 1
    var sun = 0
    for (i in 2..n) {
        sun = a + b
        a = b
        b = sun
    }
    return sun
}