// 给定一个 无重复元素 的 有序 整数数组 nums 。
//
// 区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 
// nums 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [0,1,2,4,5,7]
// 输出：["0->2","4->5","7"]
// 解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
// 输入：nums = [0,2,3,4,6,8,9]
// 输出：["0","2->4","6","8->9"]
// 解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// Related Topics 数组 👍 488 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new SummaryRanges().new Solution();
        System.out.println(solution.summaryRanges(new int[]{1}));
        System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            /*List<String> res = new ArrayList<>();
            int length = nums.length;
            if (length == 0) return res;
            if (length == 1) res.add(String.valueOf(nums[0]));
            int end = 0; // 结束
            int start = 0;// 开始
            for (int i = 1; i < length; i++) {
                if (nums[i] - nums[end] == 1) {
                    end++;
                } else {
                    if (start == end) {
                        res.add(String.valueOf(nums[start]));
                    } else {
                        res.add(nums[start] + "->" + nums[end]);
                    }
                    start = end = i;
                }
                if (i == length - 1) {
                    if (start == end) {
                        res.add(String.valueOf(nums[start]));
                    } else {
                        res.add(nums[start] + "->" + nums[end]);
                    }
                }
            }
            return res;*/
            List<String> res = new ArrayList<>();
            int length = nums.length;
            if (length == 0) return res;
            for (int i = 0; i < length; i++) {
                int start = i;
                while (i + 1 < length && nums[i] + 1 == nums[i + 1]) {
                    i++;
                }
                if (start == i) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    res.add(nums[start] + "->" + nums[i]);
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}