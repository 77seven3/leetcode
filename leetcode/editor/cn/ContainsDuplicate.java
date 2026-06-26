//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,1] 
// 
//
// 输出：true 
//
// 解释： 
//
// 元素 1 在下标 0 和 3 出现。 
//
// 示例 2： 
//
//

// 输入：nums = [1,2,3,4] 
// 
//
// 输出：false 
//
// 解释： 
//
// 所有元素都不同。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,1,1,3,3,4,3,2,4,2] 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 👍 1170 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        // 在这里写测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.getOrDefault(nums[i], 0);
            if(val > 0) return true;
            map.put(nums[i], 1);
        }
        return false;*/
        //使用 HashSet（哈希集合）替代 HashMap 来记录遍历过的数字，利用其底层自动去重的特性，用更少的代码和内存实现 $O(N)$ 复杂度的快速判重。
        Set<Integer> set = new HashSet<>();
        /*for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }*/
        for (int num : nums) {
            // set.add(num) 如果元素已经存在，会返回 false
            // 取反后变为 true，说明找到了重复元素，直接返回
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}