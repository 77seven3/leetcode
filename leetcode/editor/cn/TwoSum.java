//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 21068 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
        // 在这里写测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 暴力循环
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }*/
            // 使用Map
            // 初始化哈希表，Key 为具体的数字，Value 为该数字在数组中的下标
            Map<Integer, Integer> map = new HashMap<>();

            // 只需要遍历一次数组
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i]; // 计算当前数字的“另一半”

                // 检查哈希表中是否已经存在我们需要的“另一半”
                if (map.containsKey(complement)) {
                    // 如果存在，直接提取其下标，并与当前下标 i 组合返回
                    return new int[]{map.get(complement), i};
                }

                // 如果不存在，将当前数字及其下标存入哈希表，供后续数字查找
                map.put(nums[i], i);
            }

            // 如果没有找到满足条件的两个数（题目通常保证有解，所以此处为兜底返回）
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}