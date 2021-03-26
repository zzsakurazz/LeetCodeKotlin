package Stack

/**
 * @author zhangzheng
 * @Date  2021/3/26 下午5:34
 * @ClassName `20.Valid_Parentheses`
 * <p>
 * Desc :有效的括号
 */
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2276 👎 0
/**
 * 通过栈来实现
 */
fun isValid(s: String): Boolean {
    val strArray=s.toCharArray()
    val size=strArray.size
    if(size%2!=0){
        return false
    }
    val map= hashMapOf<Char,Char>()
    map[")".single()]="(".single()
    map["]".single()]="[".single()
    map["}".single()]="{".single()
    val stack= MyLinkedStack<Char>()
    for (c in strArray) {
        if(map.containsKey(c)){
            if(stack.isEmpty()||(stack.peek())!=map[c]){
                return false
            }else{
                stack.pop()
            }
        }else{
            stack.push(c)
        }
    }
    return stack.isEmpty()
}