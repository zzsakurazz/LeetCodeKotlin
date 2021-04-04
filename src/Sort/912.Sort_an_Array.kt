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

/**
 * 归并排序 时间复杂度：O(nlogN) ，平均空间复杂度：O(n)
 */
fun mergeSort(arr: IntArray, startIndex: Int, endIndex: Int) {
    if (startIndex >= endIndex) return
    //当心这里可能会溢出
    val mid = startIndex+(endIndex - startIndex) / 2
    mergeSort(arr, startIndex, mid)
    mergeSort(arr, mid + 1, endIndex)
    merge(arr, startIndex, mid, endIndex)
}

fun merge(arr: IntArray, startIndex: Int, mid: Int, endIndex: Int) {
    println("${arr.size}+$mid+$startIndex+$endIndex")
    val tempArray = arrayOfNulls<Int>((endIndex - startIndex )+ 1)
    var i = startIndex
    var j = mid + 1
    var k = 0
    //合并两者相同长度部分
    while (i <= mid && j <= endIndex) {
        if (arr[i] <= arr[j]) {
            tempArray[k++] = arr[i++]
        } else {
            tempArray[k++] = arr[j++]
        }
    }
    //如果左边的数组还有剩余就直接添加到temp数组后面
    while (i <= mid) {
        tempArray[k++] = arr[i++]
    }
    while (j <= endIndex) {
        tempArray[k++] = arr[j++]
    }
    for (a in tempArray.indices) {
        arr[startIndex + a] = tempArray[a]!!
    }
}
