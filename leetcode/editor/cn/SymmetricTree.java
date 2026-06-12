// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,2,2,3,4,4,3]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [1,2,2,null,3,null,3]
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 3154 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        // 在这里写测试用例
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            /*if (root == null) return true;
            TreeNode leftTree = root.left;
            TreeNode rightTree = root.right;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(leftTree);
            queue.offer(rightTree);
            while (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                // 两个都为空，没问题，跳过这轮去查后面的
                if (left == null && right == null) continue;
                // 一个空一个不空，结构不同
                if (left == null || right == null) return false;
                // 值不同
                if (left.val != right.val) return false;
                // 注意入队的顺序，必须成双成对！
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;*/

            if (root == null) return true;
            // 将大问题化解为：左子树和右子树是否互为镜像？
            return check(root.left, root.right);
        }

        // 辅助递归函数：判断两棵树是否镜像对称
        private boolean check(TreeNode left, TreeNode right) {
            // 完美套用你的三道防线！
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            // 核心镜像逻辑：
            // 左树的外侧 (left.left) 对比 右树的外侧 (right.right)
            // 左树的内侧 (left.right) 对比 右树的内侧 (right.left)
            return check(left.left, right.right) && check(left.right, right.left);
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}