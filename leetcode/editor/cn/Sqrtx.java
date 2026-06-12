// 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：x = 4
// 输出：2
// 
//
// 示例 2： 
//
// 
// 输入：x = 8
// 输出：2
// 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1776 👎 0

package leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        // 在这里写测试用例
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            // 在标准的二分查找中，我们是找一个“恰好等于”目标值的数。但这里，如果没有恰好等于的情况（比如 $x=8$），我们要的是最后一个平方小于等于 $x$ 的数。
            // 所以，当 mid * mid <= x 时，这个 mid 极有可能就是最终答案！我们用一个变量 ans 把此时的 mid 记下来，然后让左指针向右移（left = mid + 1），去看看还有没有更大的数能满足条件。
            int ans = 0;
            int left = 1, right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 注意这里必须强转为 long，防止大数相乘时整型溢出
                if ((long) mid * mid < x) {
                    left = mid + 1;
                    // 如果满足条件，说明 mid 可能是答案。我们先记录下来！
                    ans = mid;
                } else if ((long) mid * mid > x) {
                    right = mid - 1;
                } else {
                    return (int) mid;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}