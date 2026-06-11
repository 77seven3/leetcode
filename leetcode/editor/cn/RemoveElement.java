// 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元
// 素的数量。
//
// 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作： 
//
// 
// 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。 
// 返回 k。 
// 
//
// 用户评测： 
//
// 评测机将使用以下代码测试您的解决方案： 
//
// 
// int[] nums = [...]; // 输入数组
// int val = ...; // 要移除的值
// int[] expectedNums = [...]; // 长度正确的预期答案。
//                            // 它以不等于 val 的值排序。
//
// int k = removeElement(nums, val); // 调用你的实现
//
// assert k == expectedNums.length;
// sort(nums, 0, k); // 排序 nums 的前 k 个元素
// for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//} 
//
// 如果所有的断言都通过，你的解决方案将会 通过。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [3,2,2,3], val = 3
// 输出：2, nums = [2,2,_,_]
// 解释：你的函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
// 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
//
// 示例 2： 
//
// 
// 输入：nums = [0,1,2,2,3,0,4,2], val = 2
// 输出：5, nums = [0,1,4,0,3,_,_,_]
// 解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
// 注意这五个元素可以任意顺序返回。
// 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
//
// Related Topics 数组 双指针 👍 2717 👎 0

package leetcode.editor.cn;

public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // 在这里写测试用例
        System.out.println(solution.removeElement(new int[]{3, 3, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 快慢双指针（同向）：用慢指针指向即将“安全着陆”的合法位置，用快指针向后扫描整个数组；遇到不需要删除的元素，就把它“搬运”到慢指针处，跳过需要删除的元素。
            /*int updateIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[updateIndex++] = nums[i];
                }
            }
            return updateIndex;*/
            // 相向双指针 左指针从前往后找“需要移除的元素”，右指针从后往前提供“填补空缺的元素”；一旦左指针撞上 val，就把右指针的值覆盖过来并收缩右边界，直到两指针交错。
            int left = 0;
            int right = nums.length - 1;
            // 当 left 和 right 错开时，代表所有元素已经全部过滤完毕
            while (left <= right) {
                if (nums[left] == val) {
                    nums[left] = nums[right--];
                    // 核心关键：新移过来的值还没检查，使用 continue 阻止左指针前进
                    continue;
                }
                left++;
            }
            return left;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}