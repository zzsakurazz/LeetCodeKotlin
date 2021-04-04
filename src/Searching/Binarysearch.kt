package Searching

/**
 * @author zhangzheng
 * @Date  2021/4/4 上午11:15
 * @ClassName Binarysearch
 * <p>
 * Desc :两种二分查找
 */

/**
 * 递归
 */
fun recursiveToBinarySearch(letters: IntArray, target: Int, left: Int, right: Int): Int {
    if (left >= right) return -1
    val min = left + (right - left) / 2
    when {
        letters[min] > target -> {
            return recursiveToBinarySearch(letters, target, min + 1, right)
        }
        letters[min] < target -> {
            return recursiveToBinarySearch(letters, target, left, min - 1)
        }
        letters[min] == target -> {
            return min
        }
    }
    return -1
}

/**
 * 非递归
 */
fun binarySearch(letters: IntArray, target: Int): Int {
    var left = 0
    var right = letters.size - 1
    while (left <= right) {
        val min = left + (right - left) / 2
        when {
            letters[min] == target -> {
                return min
            }
            letters[min] > target -> {
                right = min - 1
            }
            else -> {
                left = min + 1
            }
        }
    }
    return -1
}