// 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//
// 
//
// 示例 1： 
//
// 
// 输入:a = "11", b = "1"
// 输出："100"
//
// 示例 2： 
//
// 
// 输入：a = "1010", b = "1011"
// 输出："10101"
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1390 👎 0

package leetcode.editor.cn;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
        // 在这里写测试用例
    }
    // 101
    //   1
    // 1010

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            // 双指针 + 进位器（Carry）：从后往前同时遍历两个字符串，把字符转换成数字（0 或 1）相加，并加上上一轮的进位。
            // 如果某个字符串提前遍历完了，就当成 0 来加。只要还有未处理的字符或者进位不为 0，循环就继续，完美解决连续进位的问题！
            // 在循环中直接使用 result = "1" + result 会导致每次都创建一个新的字符串对象，极其拖慢速度。我们应该使用 StringBuilder.append() 追加到末尾，最后再 reverse() 反转过来。
            StringBuilder sb = new StringBuilder();
            int ai = a.length() - 1;
            int bi = b.length() - 1;
            int carry = 0;
            while (ai >= 0 || bi >= 0 || carry > 0) {
                int aNum = ai >= 0 ? a.charAt(ai) - '0' : 0;
                int bNum = bi >= 0 ? b.charAt(bi) - '0' : 0;
                int sum = aNum + bNum + carry;
                // 追加当前位的结果（对 2 取余）
                sb.append(sum % 2);

                // 计算下一次的进位（对 2 取商）
                carry = sum / 2;

                // 指针前移
                ai--;
                bi--;
            }
            // 因为我们是从后往前追加的，最后一定要把结果反转过来
            return sb.reverse().toString();
            /*int aLength = a.length();
            int bLength = b.length();
            int shortLength = Math.min(aLength, bLength);
            // int shortLength = aLength>bLength ? bLength : aLength;
            char remainder = '0';
            String result = "";
            for (int i = 1; i <= shortLength; i++) {
                if (a.charAt(aLength - i) == '1' && b.charAt(bLength - i) == '1') {
                    if (remainder == '1') {
                        result = "1" + result;
                    } else {
                        result = "0" + result;
                    }
                    remainder = '1';
                } else if (a.charAt(aLength - i) == '0' && b.charAt(bLength - i) == '0') {
                    if (remainder == '1') {
                        result = remainder + result;
                    } else {
                        result = remainder + result;
                    }
                    remainder = '0';
                } else {
                    if (remainder == '1') {
                        result = "0" + result;
                    } else {
                        result = "1" + result;
                    }
                    remainder = '1';
                }
            }
            String prefix = aLength > bLength ? a : b;
            if (remainder == '1') {
                if (prefix.charAt(prefix.length() - shortLength - 1) == '1') {

                }
            }
            result = prefix.substring(0, prefix.length() - shortLength) + result;
            return result;*/
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}