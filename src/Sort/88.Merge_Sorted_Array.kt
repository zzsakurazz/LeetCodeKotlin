package Sort

/**
 * @author zhangzheng
 * @Date  2021/4/4 上午11:26
 * @ClassName `88.Merge_Sorted_Array`
 * <p>
 * Desc :合并两个有序数组
 */
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 819 👎 0


/**
 * 合并两个有序数组
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var t1 = m - 1
    var t2 = n - 1
    var t = n + m - 1
    while (t1 >= 0 && t2 >= 0)
        nums1[t--] = if (nums1[t1] >= nums2[t2]) nums1[t1--] else nums2[t2--]
    while (t2 >= 0) nums1[t--] = nums2[t2--]
}
