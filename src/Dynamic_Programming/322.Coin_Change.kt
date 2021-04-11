package Dynamic_Programming

/**
 * @author zhangzheng
 * @Date  2021/4/11 下午7:47
 * @ClassName `322.Coin_Change`
 * <p>
 * Desc :零钱兑换
 */
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
//
//输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
//
//输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 1195 👎 0

//暴利递归
import kotlin.math.min
class Solution {
    var i = Int.MAX_VALUE
    fun coinChange1(coins: IntArray, amount: Int): Int {
        val sun = 0
        if (coins.isEmpty()) return -1
        coinChangeHelper1(coins, amount, sun)
        if (i == Int.MAX_VALUE) return -1
        return i
    }

    fun coinChangeHelper1(coins: IntArray, amount: Int, sun: Int) {
        val sun1 = sun + 1
        if (amount < 0) return
        if (amount == 0) {
            i = min(i, sun)
        }
        for (coin in coins) {
            coinChangeHelper1(coins, amount - coin, sun1)
        }
    }
}

//备忘录 时间复杂度：O(Sn)-- S 是金额，n 是面额数
fun coinChange2(coins: IntArray, amount: Int): Int {
    val memo = IntArray(amount + 1)
    if (coins.isEmpty()) return -1
    return coinChangeHelper2(coins, amount, memo)
}
fun coinChangeHelper2(coins: IntArray, amount: Int, momo: IntArray): Int {
    //确定 base case
    //说明这个硬币组合无法满足amount要求
    if (amount < 0) return -1
    //如果amount是0就返回0
    if (amount == 0) return 0
    //查找备忘录
    if (momo[amount] != 0) {
        return momo[amount]
    }
    var res = Int.MAX_VALUE
    for (coin in coins) {
        val count = coinChangeHelper2(coins, amount - coin, momo)
        if (count == -1) {
            continue
        }
        res = min(res, count + 1)
    }
    momo[amount] = if (res == Int.MAX_VALUE) -1 else res
    return momo[amount]
}

//自底而上的动态规划  我们可以从0开始依次求出coins的最小硬币数
//该方法的时间复杂度：O(Sn)-- S 是金额，n 是面额数
fun coinChange3(coins: IntArray, amount: Int): Int {
    if (coins.isEmpty()) {
        return -1
    }
    val memo = IntArray(amount + 1)
    if (coins.isEmpty()) return -1
    memo[0] = 0
    for (i in 1..amount) {
        var res = Int.MAX_VALUE
        for (coin in coins) {
            //这里比较难，需要好好想一想
            //首先判断当前的金额减去当前的硬币是否是小于0，如果是的话就代表这个硬币不能用
            //然后去判断当前目标值减去当前硬币值后的信目标值是不是最小的，如果是就使用它
            /*
             *  举个例子：coins-->【1，2，5】
             *          i-->6
             *          我们需要的是找到下面三种情况那个需要的硬币数最：
             *              ①凑成面值为5的最小面值数+面值为1的硬币
             *              ②凑成面值为4的最小面值数+面值为2的硬币
             *              ③凑成面值为1的最小面值数+面值为5的硬币
             *          找到之后再将这个最小的硬币数量放入memo中，这就是当前i的最少的硬笔数
             */
            if (i - coin >= 0 && memo[i - coin] < res) {
                res = memo[i - coin] + 1//这里的+1代表的是加一个硬币，而不是加一元硬币
            }
        }
        memo[i] = res
    }
    return if (memo[amount] == Int.MAX_VALUE) -1 else memo[amount]
}