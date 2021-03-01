import kotlin.math.log

/**
 * @author zhangzheng
 * @Date  2021/1/10 下午4:29
 * @ClassName LeetCode
 * <p>
 * Desc :测试
 */


fun main() {
    test()
}

fun test() {
    val nums = intArrayOf(0,1,2,2,3,0,4,2)
    print(removeElement(nums,2))
}
fun removeElement(nums: IntArray, `val`: Int): Int {
    var left=0
    var right=nums.size-1
    while (left<=right){
        if(nums[left]==`val`){
            if(nums[right]!=`val`){
                nums[left]=nums[right]
                left++
                right--
            }else{
                right--
            }
        }else{
            left++
        }
    }
    return left
}