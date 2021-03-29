package Hash

/**
 * @author zhangzheng
 * @Date  2021/3/29 下午2:49
 * @ClassName `389.Find_the_Difference`
 * <p>
 * Desc :找不同
 */
//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
// 输入：s = "", t = "y"
//输出："y"
//
//
// 示例 3：
//
// 输入：s = "a", t = "aa"
//输出："a"
//
//
// 示例 4：
//
// 输入：s = "ae", t = "aea"
//输出："a"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
//
// Related Topics 位运算 哈希表
// 👍 239 👎 0

/**
 * 通过HashSet解决
 */
fun findTheDifference(s: String, t: String): Char {
    val set= hashSetOf<Char>()
    val chars=(s+t).toCharArray()
    for (char in chars) {
        if(set.contains(char)){
            set.remove(char)
        }else{
            set.add(char)
        }
    }
    return set.first()
}