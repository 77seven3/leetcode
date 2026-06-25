// 给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 11
// 输出：3
// 解释：输入的二进制串 1011 中，共有 3 个设置位。
// 
//
// 示例 2： 
//
// 
// 输入：n = 128
// 输出：1
// 解释：输入的二进制串 10000000 中，共有 1 个设置位。
// 
//
// 示例 3： 
//
// 
// 输入：n = 2147483645
// 输出：30
// 解释：输入的二进制串 1111111111111111111111111111101 中，共有 30 个设置位。
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 如果多次调用这个函数，你将如何优化你的算法？ 
// 
//
// Related Topics 位运算 分治 👍 712 👎 0

package leetcode.editor.cn;

public class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new NumberOf1Bits().new Solution();
        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hammingWeight(128));
        System.out.println(solution.hammingWeight(2147483645));
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingWeight(int n) {
            /*int res = 0;
            while (n > 0) {
                int remainder = n % 2;
                if (remainder == 1) res++;
                n = n / 2;
            }
            return res;*/
            // 使用 n & (n - 1) 的位运算技巧，每次直接消除二进制表示中最低位的那个 1，消了几次就代表有几个 1，实现跳过 0 的极致优化。
            // 因为 n - 1 的本质是：把最低位的 1 变成 0，并把这个 1 右边所有的 0 都变成 1。
            // 此时再把它和原数字 n 做一次 & (按位与)，最低位的 1 和右边的部分就全部被抹零了。
            int res = 0;
            // 当 n 中不再包含 1（即 n 变为 0）时结束循环
            while (n > 0) {
                // 核心神之一手：消除 n 二进制中最右侧的 1
                n &= (n - 1);
                // 每次成功消除一个 1，计数器加 1
                res++;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}