// 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 1
// 输出：true
// 解释：2⁰ = 1
// 
//
// 示例 2： 
//
// 
// 输入：n = 16
// 输出：true
// 解释：2⁴ = 16
// 
//
// 示例 3： 
//
// 
// 输入：n = 3
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
//
// Related Topics 位运算 递归 数学 👍 811 👎 0

package leetcode.editor.cn;

public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            // 核心解法： 利用 2 的幂次方在二进制表示中有且仅有一个 1 的特性，结合位运算技巧 n & (n - 1) 消除最低位的 1，以空间换时间，在 $O(1)$ 时间内秒杀此题。
            // 如果一个正整数是 2 的幂次方，那么它的二进制表示中，一定只有最高位是 1，其余所有位全是 0。
            // 1. 2的幂必定是正整数，因此小于等于0的直接淘汰
            // 2. 利用 n & (n - 1) 清除最低位的 1。如果清零后结果为 0，说明原本只有一个 1
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}