/**
 * @author zhangzheng
 * @Date  2021/2/20 下午1:32
 * @ClassName `283.Move_Zeroes`
 * <p>
 * Desc :移动零
 */
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 955 👎 0

/**
 * 双指针
 */
fun moveZeroes(nums: IntArray) {
    var a = 0
    var b = 0
    while (b < nums.size) {
        if (nums[a] == 0) {
            if (nums[b] == 0) {
                b++
            } else {
                nums[a] = nums[b]
                nums[b] = 0
                a++
            }
        } else {
            a++
            if (a >= b) {
                b++
            }
        }
    }
    print(nums.toString())
}
