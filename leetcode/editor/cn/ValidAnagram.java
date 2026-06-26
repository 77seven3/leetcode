// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
//
// 
//
// 示例 1: 
//
// 
// 输入: s = "anagram", t = "nagaram"
// 输出: true
// 
//
// 示例 2: 
//
// 
// 输入: s = "rat", t = "car"
// 输出: false
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 1110 👎 0

package leetcode.editor.cn;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("anagram", "naagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            /*Map<Integer, Integer> map = new HashMap<>();
            int length1 = s.length();
            int length2 = t.length();
            if (length1 != length2) return false;
            for (int i = 0; i < length1; i++) {
                int key1 = s.charAt(i);
                int value1 = map.getOrDefault(key1, 0);
                map.put(key1, value1 + 1);
                int key2 = t.charAt(i);
                int value2 = map.getOrDefault(key2, 0);
                map.put(key2, value2 - 1);
            }

            for (int count : map.values()) {
                if (count != 0) {
                    return false;
                }
            }
            return true;*/
            //核心解法： 因为小写字母只有 26 个，我们可以直接使用一个大小为 26 的整型数组作为“简易哈希表”，记录每个字符出现的频次差值，以 $O(1)$ 的空间换取极高的执行效率。
            int[] list = new int[26];
            int length1 = s.length();
            int length2 = t.length();
            if (length1 != length2) return false;
            for (int i = 0; i < length1; i++) {
                list[s.charAt(i)-'a']++;
                list[t.charAt(i)-'a']--;

            }
            for (int count : list) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}