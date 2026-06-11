// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 示例 5： 
//
// 
// 输入：s = "([)]" 
// 
//
// 输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4979 👎 0

package leetcode.editor.cn;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));     // 预期: true
        System.out.println(solution.isValid("()[]{}")); // 预期: true
        System.out.println(solution.isValid("(]"));     // 预期: false
        System.out.println(solution.isValid("([)]"));   // 预期: false
        System.out.println(solution.isValid("]"));      // 预期: false (防越界测试)
        System.out.println(solution.isValid("["));      // 预期: false (防残留测试)
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            // 剪枝：如果长度是奇数，绝对不可能成对闭合
            if (s.length() % 2 != 0) {
                return false;
            }
            char[] leftChars = new char[s.length()];
            int leftLastIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                if (leftChar(s.charAt(i))) {
                    leftChars[leftLastIndex++] = s.charAt(i);
                } else {
                    // 遇到右括号，但此时栈已经是空的，说明没有对应的左括号（例如字符串以 ']' 开头）
                    if (leftLastIndex == 0) {
                        return false;
                    }
                    if (!isMatch(leftChars[--leftLastIndex], s.charAt(i))) {
                        return false;
                    }
                }
            }
            // 遍历结束后，如果栈是空的 (top == 0)，说明所有括号都完美闭合了
            // 如果 top > 0，说明还有多余的左括号没有闭合（例如 s = "((" ）
            return leftLastIndex == 0;
        }

        public boolean leftChar(char c) {
            return c == '(' || c == '[' || c == '{';
        }

        public boolean isMatch(char c1, char c2) {
            return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}