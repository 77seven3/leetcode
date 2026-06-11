//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2582 👎 0

package leetcode.editor.cn;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        // 在这里写测试用例
        System.out.println(solution.strStr("asdsadbutsad", "sad"));
        System.out.println(solution.strStr("sadbutsad", "sad"));
        System.out.println(solution.strStr("leetcode", "sad"));
        System.out.println(solution.strStr("a", "sad"));
        System.out.println(solution.strStr("mississippi", "issipi"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        // 字符串方法
        // return haystack.indexOf(needle);

        if(needle.length() > haystack.length()) return -1;
        char needleFirst = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            // 防止越界 i + needle.length() <= haystack.length()
            if (haystack.charAt(i) == needleFirst && i + needle.length() <= haystack.length()) {
                for (int j = 0; j < needle.length(); j++){
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                    if (j == needle.length() - 1) return i;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}