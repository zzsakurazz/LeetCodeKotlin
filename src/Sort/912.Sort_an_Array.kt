package Sort

/**
 * @author zhangzheng
 * @Date  2021/4/3 下午7:35
 * @ClassName `912.Sort_an_Array`
 * <p>
 * Desc :排序数组
 */
//给你一个整数数组 nums，请你将该数组升序排列。
//
// 示例 1：
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//
// 示例 2：
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
// 1 <= nums.length <= 50000
// -50000 <= nums[i] <= 50000
//
// 👍 259 👎 0

/**
 * 插入排序 时间复杂度：O(n^2) 空间复杂度 O(1)
 */
fun insertionSort(nums: IntArray): IntArray {
    //如果只有一个元素，那几直接返回
    if (nums.size >= 2) {
        for (i in 1 until nums.size) {
            var j = i - 1
            while (j >= 0) {
                if (nums[j] > nums[j + 1]) {
                    val temp = nums[j + 1]
                    nums[j + 1] = nums[j]
                    nums[j] = temp
                }
                j--
            }
        }
    }
    return nums
}

/**
 * 快速排序 时间复杂度：O(n^2)，平均时间复杂度：O(nlogN) 空间复杂度：O(n)，平均空间复杂度：O(logN)
 */
fun quickSort(arr: IntArray,  startIndex: Int, endIndex: Int):IntArray {
    if (startIndex > endIndex) return arr
    val pivot = arr[startIndex]
    //找到左右两个指针
    var l = startIndex
    var r = endIndex
    while (l < r) {
        while (pivot <= arr[r] && l < r) r--
        //找到了右侧需要交换的指针
        if (l < r) {
            arr[l] = arr[r]
        }
        while (pivot >= arr[l] && l < r) l++
        if (l < r) {
            arr[r] = arr[l]
        }
    }
    //将pivot放到两个指针重合的地方
    if(l==r){
        arr[r]=pivot
    }
    //递归左右两边的数组，重复上述操作
    quickSort(arr,startIndex,l-1)
    quickSort(arr,r+1,endIndex)
    return arr
}