// 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
// 输入: s = "A man, a plan, a canal: Panama"
// 输出：true
// 解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
// 输入：s = "race a car"
// 输出：false
// 解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
// 输入：s = " "
// 输出：true
// 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
// 由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 886 👎 0

package leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("0P"));
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("  "));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            String lowerCase = s.toLowerCase();
            int left = 0;
            int right = lowerCase.length() - 1;
            while (left < right) {
                // 1. 左指针向右移动，跳过所有非字母数字的字符
                // 注意：内部循环也要保证 left < right，防止越界
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                // 2. 右指针向左移动，跳过所有非字母数字的字符
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }
                // 3. 将左右指针指向的合法字符统一转小写后进行比对
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                // 4. 比对成功，指针继续向中间收缩
                left++;
                right--;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}