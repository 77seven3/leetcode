// 给定一个二叉树，判断它是否是 平衡二叉树
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [1,2,2,3,3,null,null,4,4]
// 输出：false
// 
//
// 示例 3： 
//
// 
// 输入：root = []
// 输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1718 👎 0

package leetcode.editor.cn;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        private int getHeight(TreeNode node) {
            // 边界条件：空节点高度为 0
            if (node == null) {
                return 0;
            }
            // 1. 获取左子树的高度
            int leftHeight = getHeight(node.left);
            // 如果左子树已经不平衡了（收到暗号 -1），直接向上层返回 -1，提前阻断
            if (leftHeight == -1) return -1;

            // 2. 获取右子树的高度
            int rightHeight = getHeight(node.right);
            // 如果右子树不平衡，同理提前阻断
            if (rightHeight == -1) return -1;

            // 3. 处理当前节点：判断左右子树高度差是否大于 1
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1; // 破功了，返回不平衡暗号
            } else {
                // 如果平衡，当前节点的高度等于左右子树最大高度加上自身这一层
                return Math.max(leftHeight, rightHeight) + 1;
            }
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