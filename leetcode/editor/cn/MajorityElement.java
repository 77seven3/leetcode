// 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [3,2,3]
// 输出：3
//
// 示例 2： 
//
// 
// 输入：nums = [2,2,1,1,1,2,2]
// 输出：2
// 
//
// 
// 提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 输入保证数组中一定有一个多数元素。 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2705 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            /*Map<Integer, Integer> map = new HashMap<>();
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                int key = nums[i];
                int value = map.getOrDefault(key, 0) + 1;
                if (value > length / 2) return key;
                map.put(key, value);
            }
            return 0;*/
            // 使用摩尔投票法（同归于尽消消乐）。把寻找多数元素的过程看作是一场阵地战：
            // 不同的数字两两抵消，因为多数元素的数量大于总数的一半，所以即使所有其他数字都联合起来和它“一换一”，最后活下来的也一定会是它。
            int candidate = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                    count++;
                    continue;
                }
                if (candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return candidate;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}