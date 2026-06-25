// 给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "egg", t = "add" 
// 
//
// 输出：true 
//
// 解释： 
//
// 字符串 s 和 t 可以通过以下方式变得相同： 
//
// 
// 将 'e' 映射为 'a'。 
// 将 'g' 映射为 'd'。 
// 
//
// 示例 2： 
//
// 
// 输入：s = "f11", t = "b23" 
// 
//
// 输出：false 
//
// 解释： 
//
// 字符串 s 和 t 无法变得相同，因为 '1' 需要同时映射到 '2' 和 '3'。 
//
// 示例 3： 
//
// 
// 输入：s = "paper", t = "title" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 833 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        System.out.println(solution.isIsomorphic("bbbaaaba", "aaabbbba"));
        System.out.println(solution.isIsomorphic("f11", "b23"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        // 在这里写测试用例
    }

    // bbbaaaba
    // aaabbbba
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            int length1 = s.length();
            int length2 = t.length();
            if (length1 != length2) return false;
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int i = 0; i < length1; i++) {
                int key1 = s.charAt(i);
                int key2 = t.charAt(i);
                int value1 = map1.getOrDefault(key1, -1);
                int value2 = map2.getOrDefault(key2, -1);
                if (value1 != value2) return false;
                //记录字符“上一次出现的位置”
                map1.put(key1, i);
                map2.put(key2, i);
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}