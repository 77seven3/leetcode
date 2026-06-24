// 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
// 输入: rowIndex = 3
// 输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
// 输入: rowIndex = 0
// 输出: [1]
// 
//
// 示例 3: 
//
// 
// 输入: rowIndex = 1
// 输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 616 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(3));
        // 在这里写测试用例
        /*
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
         */
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            // 滚动数组
            /*List<Integer> upRow = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                res = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        res.add(1);
                    } else {
                        res.add(upRow.get(j - 1) + upRow.get(j));
                    }
                }
                upRow = res;
            }
            return res;*/
            // 单行滚动数组
            List<Integer> res = new ArrayList<>();
            // 初始第 0 行
            res.add(1);
            for (int i = 1; i <= rowIndex; i++) {
                res.add(0);
                for (int j = i; j > 0; j--) {
                    res.set(j, res.get(j) + res.get(j - 1));
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}