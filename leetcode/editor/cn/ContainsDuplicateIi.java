// 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,1], k = 3
// 输出：true
//
// 示例 2： 
//
// 
// 输入：nums = [1,0,1,1], k = 1
// 输出：true
//
// 示例 3： 
//
// 
// 输入：nums = [1,2,3,1,2,3], k = 2
// 输出：false
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 872 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        // 在这里写测试用例
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /*Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int value = map.getOrDefault(nums[i], -1);
                if (value != -1 && Math.abs(value - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;*/

            // Map.put(key, value) 方法本身就有一个非常妙的特性：如果这个 key 之前存在，put 方法会返回它原来的旧 value；如果不存在，则返回 null。
            /*Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer value = map.put(nums[i], i);
                if (value != null && Math.abs(value - i) <= k) return true;
            }
            return false;*/
            
            //（进阶）：维护一个大小限制为 k 的 HashSet 作为“滑动窗口”，窗口内只要出现重复元素即满足条件，以空间换取更高的效率。
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.add(nums[i])) {
                    return true;
                }
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }

            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}