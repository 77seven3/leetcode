// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [1,3,5,6], target = 5
// 输出: 2
// 
//
// 示例 2: 
//
// 
// 输入: nums = [1,3,5,6], target = 2
// 输出: 1
// 
//
// 示例 3: 
//
// 
// 输入: nums = [1,3,5,6], target = 7
// 输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴
// 
//
// Related Topics 数组 二分查找 👍 2697 👎 0

package leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(solution.searchInsert(new int[]{1, 3}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3}, 0));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            /*int first = 0;
            int last = nums.length - 1;
            int index;
            if (nums[0] >= target) {
                return 0;
            }
            if (nums[last] < target) {
                return last + 1;
            }
            while (true) {
                index = (first + last) / 2;
                if (first >= last) {
                    return nums[index] < target ? index + 1 : last;
                }
                if (target == nums[index]) {
                    return index;
                } else if (target > nums[index]) {
                    first = index + 1;
                } else {
                    last = index - 1;
                }
            }*/
            // 经典二分查找：利用数组有序的特性，不断折半缩小查找区间。当查找目标不存在时，循环结束后的左指针（left）所指的位置，天然就是该目标值按顺序插入的位置。
            int left = 0;
            int right = nums.length - 1;
            // 标准二分查找模板：[left, right] 闭区间
            while (left <= right) {
                // 防溢出的中点计算法
                // left + (right - left) / 2。通过计算两者之差的一半再加到基准值上，完美规避了溢出风险。
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid; // 找到了，直接返回索引
                } else if (nums[mid] < target) {
                    left = mid + 1; // 目标在右侧，收缩左边界
                } else {
                    right = mid - 1; // 目标在左侧，收缩右边界
                }
            }
            // 循环结束时，left 必然大于 right
            // 此时 left 指向的位置，恰好是第一个大于 target 的元素位置，即插入位置
            return left;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}