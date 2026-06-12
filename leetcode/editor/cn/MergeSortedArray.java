// 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
// 的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// 输出：[1,2,2,3,5,6]
// 解释：需要合并 [1,2,3] 和 [2,5,6] 。
// 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
// 输入：nums1 = [1], m = 1, nums2 = [], n = 0
// 输出：[1]
// 解释：需要合并 [1] 和 [] 。
// 合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
// 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
// 输出：[1]
// 解释：需要合并的数组是 [] 和 [1] 。
// 合并结果是 [1] 。
// 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
//
// Related Topics 数组 双指针 排序 👍 3001 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        solution.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        solution.merge(new int[]{1, 2, 3}, 3, new int[]{}, 0);
        solution.merge(new int[]{1, 2, 3,}, 0, new int[]{2, 5, 6}, 3);
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 双指针从前往后做对比
            // 有个问题 交换覆盖原有数据 会导致非递减顺序改变
            // 逆向双指针（三指针法）：既然 nums1 的前半部分是有效数据，后半部分全是空的（0），那我们完全可以从后往前比较！
            // 每次挑出两个数组中较大的那个数，直接塞进 nums1 的最后面。
            // 这样完美利用了尾部的空闲空间，绝对不会覆盖前面还没比较的有效数据！
            int p1 = m - 1;
            int p2 = n - 1;
            int cur = m + n - 1;
            // 只要 nums2 还有元素没合并完，就一直循环
            // 如果 nums2 合并完了，nums1 原本剩下的元素天然就是有序且在正确位置的，直接结束
            while (p2 >= 0) {
                if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                    nums1[cur--] = nums1[p1--];
                } else {
                    nums1[cur--] = nums2[p2--];
                }
            }

            /*if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
            }
            if (m != 0 && n != 0) {
                int cur = m + n - 1;
                while (m > 0 || n > 0) {
                    if (m <= 0) {
                        nums1[cur--] = nums2[--n];
                    } else if (n <= 0) {
                        break;
                    } else if (nums1[m - 1] >= nums2[n - 1]) {
                        nums1[cur--] = nums1[--m];
                    } else {
                        nums1[cur--] = nums2[--n];
                    }
                }
            }*/
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}