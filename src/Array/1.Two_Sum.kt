/**
 * @author zhangzheng
 * @Date  2021/2/20 下午3:30
 * @ClassName `1.Two_Sum`
 * <p>
 * Desc :两数之和
 */
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 10312 👎 0

/**
 * 一旦题目中明确元素不重复并且是要找到某个元素就可以考虑使用哈希来查找，更方便
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashtable = HashMap<Int, Int>()
    nums.forEachIndexed { index, i ->
        hashtable[i] = index
    }
    var i = 0
    while (i < nums.size) {
        if (hashtable.containsKey(target - nums[i])) {
            hashtable[target - nums[i]]?.also {
                if(i!=it){
                    return intArrayOf(i, it)
                }
            }
        }
        i++
    }
    return intArrayOf(0, 0)
}