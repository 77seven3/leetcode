//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 3190 👎 0

package leetcode.editor.cn;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        boolean palindrome = solution.isPalindrome(123454321);
        System.out.println(palindrome);
        // 在这里写测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            /*String str = String.valueOf(x);
            int length = str.length();
            for(int i = 0; i < length / 2; i++){
                if(str.charAt(i) != str.charAt(length - i - 1)){
                    return false;
                }
            }
            return true;*/
            // 不转字符串
            // 边界情况 1：如果是负数，直接返回 false
            // 边界情况 2：如果数字最后一位是 0，为了使它成为回文，第一位也必须是 0
            // 只有 0 本身满足这个条件，其他如 10, 120 等都不可能是回文
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int revertedNumber = 0;
            // 当原数 x 小于等于反转的数字时，意味着我们已经处理了一半的位数
            while (revertedNumber < x) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x = x / 10;
            }
            // 当数字长度为偶数时，x 和 revertedNumber 完全相等，例如 1221 -> x = 12, revertedNumber = 12
            // 当数字长度为奇数时，中间的数字会跑到 revertedNumber 的最后一位，例如 121 -> x = 1, revertedNumber = 12
            // 我们通过 revertedNumber / 10 去掉中间的数字后再进行比较
            return revertedNumber == x || revertedNumber / 10 == x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}