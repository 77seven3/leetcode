// 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
//
// 例如： 
//
// 
// A -> 1
// B -> 2
// C -> 3
//...
// Z -> 26
// AA -> 27
// AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：columnNumber = 1
// 输出："A"
// 
//
// 示例 2： 
//
// 
// 输入：columnNumber = 28
// 输出："AB"
// 
//
// 示例 3： 
//
// 
// 输入：columnNumber = 701
// 输出："ZY"
// 
//
// 示例 4： 
//
// 
// 输入：columnNumber = 2147483647
// 输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics 数学 字符串 👍 751 👎 0

package leetcode.editor.cn;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        // 在这里写测试用例
        System.out.println(solution.convertToTitle(2));
        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(52));
        System.out.println(solution.convertToTitle(701));
        System.out.println(solution.convertToTitle(888));
        System.out.println(solution.convertToTitle(2147483647));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 这是一个没有数字 0 的“伪 26 进制”转换。
        // 核心破解之法是：在每次进行取模（%）和整除（/）之前，先将 columnNumber 减 1，以此将其强行拉回包含 0 的标准 26 进制世界。
        public String convertToTitle(int columnNumber) {
            // 使用 StringBuilder 提高字符串拼接性能
            StringBuilder sb = new StringBuilder();
            while (columnNumber > 0) {
                // 核心技巧：每次操作前先减 1，将 1~26 映射到 0~25
                columnNumber--;
                // 计算当前最低位的字符，0 对应 A，25 对应 Z
                char c = (char) ('A' + columnNumber % 26);
                sb.append(c);
                // 推进到下一位
                columnNumber /= 26;
            }
            // 因为是从低位到高位计算的，最后需要把字符串反转
            return sb.reverse().toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}