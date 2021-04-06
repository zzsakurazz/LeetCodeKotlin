package Dynamic_Programming

/**
 * @author zhangzheng
 * @Date  2021/4/6 下午5:13
 * @ClassName `509.Fibonacci_Number`
 * <p>
 * Desc :斐波那契数列
 */

//递归 时间复杂度：O(2^n) 空间复杂度：O(1)
fun fib1(n: Int): Int {
    if (n == 0) return 0
    if (n == 1 || n == 2) return 1
    return fib1(n - 1) + (n - 2)
}
//动态规划-备忘录 时间复杂度：O(n) 空间复杂度：O(1)--map占用的大小与n相关
//利用一个hashmap来记录递归过程中重复的操作，减少计算
//备忘录
fun memoFib(n: Int): Int {
    if (n < 1) return 0
    val memoMap = mutableMapOf<Int, Int>()
    memoMap[0] = 0
    return helper(memoMap, n)

}
fun helper(memoList: MutableMap<Int, Int>, n: Int): Int {
    if (n == 1 || n == 2) return 1
    //在hashmap中记录已经计算过的结果，在后面可以直接取出防止重复计算
    if (memoList.containsKey(n)) return memoList[n] ?: 0
    memoList[n] = helper(memoList, n - 1) + helper(memoList, n - 2)
    return memoList[n] ?: 0
}


//动态规划-DP Table 时间复杂度：O(n) 空间复杂度：O(1)
//通过自底而上的方式解决
fun tpFib(n: Int): Int {
    if (n < 1) return 0
    if (n == 1 || n == 2) return 1
    var prev=1
    var curr=1
    var sun=0
    for (i in 3..n) {
        sun=prev+curr
        prev=curr
        curr=sun
    }
    return sun
}