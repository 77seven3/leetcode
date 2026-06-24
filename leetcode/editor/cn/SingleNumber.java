// 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
// 输入：nums = [2,2,1] 
// 
//
// 输出：1 
//
// 示例 2 ： 
//
// 
// 输入：nums = [4,1,2,1,2] 
// 
//
// 输出：4 
//
// 示例 3 ： 
//
// 
// 输入：nums = [1] 
// 
//
// 输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// Related Topics 位运算 数组 👍 3496 👎 0

package leetcode.editor.cn;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 使用位运算中的异或（XOR, ^）操作，利用“两个相同的数异或结果为 0”的“消消乐”特性，将所有数字异或一遍，最终剩下的必然是那个只出现一次的数字。
        // 为什么能想到用“异或”呢？这要从异或运算的三条神奇定律说起：
        // 归零律： 任何数和它自己做异或运算，结果为 0。
        // 恒等律： 任何数和 0 做异或运算，结果还是它自己。
        // 交换律与结合律： 异或运算无视计算顺序。
        // 题目明确指出：除了一个元素只出现一次外，其余每个元素均出现两次。
        // 如果我们把数组里的所有数字全都异或起来，由于交换律，那些成对出现的数字，无论它们隔得有多远，最终都会两两结合，变成 0（归零律）。
        // 最后，一堆 0 和那个“落单的数字”进行异或，结果就是那个数字本身（恒等律）。

        public int singleNumber(int[] nums) {
            // 初始化结果为 0，因为 0 异或任何数等于那个数本身
            int ans = 0;

            // 遍历数组中的每一个数字
            for (int num : nums) {
                // 将当前数字与 ans 进行异或运算，并更新 ans
                ans ^= num;
            }

            // 遍历结束后，成对的数字相互抵消为 0，ans 中留下的就是只出现一次的数字
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}