// 编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
// 输入：strs = ["flower","flow","flight"]
// 输出："fl"
// 
//
// 示例 2： 
//
// 
// 输入：strs = ["dog","racecar","car"]
// 输出：""
// 解释：输入不存在公共前缀。
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 如果非空，则仅由小写英文字母组成 
// 
//
// Related Topics 字典树 数组 字符串 👍 3514 👎 0

package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"flower"}));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // 虽然提示说 1 <= strs.length，但养成写防御性代码的习惯是个好规范
            if (strs == null || strs.length == 0) {
                return "";
            }
            // 取第一个字符串作为基准标尺
            String first = strs[0];
            for (int j = 0; j < first.length(); j++) {
                // 拿出第一个字符
                char charAt = first.charAt(j);
                // 比较其余字符
                for (int i = 1; i < strs.length; i++) {
                    // 核心边界：
                    // 1. j == strs[i].length()：说明某个短字符串已经遍历结束了
                    // 2. strs[i].charAt(j) != c：说明在这一列遇到了不匹配的字符
                    if (j == strs[i].length() || charAt != strs[i].charAt(j)) {
                        return first.substring(0, j);
                    }
                }
                // 在 Java 中，String 是不可变的，如果在 for 循环里不断使用 publicStr += first.charAt(j)，底层每次都会创建一个新的 StringBuilder 和 String 对象，这会增加内存开销和时间消耗。
                // publicStr += first.charAt(j);
                // publicStr = first.substring(0, j + 1);
            }
            return first;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}