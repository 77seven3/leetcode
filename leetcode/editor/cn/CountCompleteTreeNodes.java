// 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
// 为第 h 层（从第 0 层开始），则该层包含 1~ 2ʰ 个节点。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,2,3,4,5,6]
// 输出：6
// 
//
// 示例 2： 
//
// 
// 输入：root = []
// 输出：0
// 
//
// 示例 3： 
//
// 
// 输入：root = [1]
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1321 👎 0

package leetcode.editor.cn;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
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
        /*public int countNodes(TreeNode root) {
            if (root == null) return 0;
            Stack<TreeNode> stack = new Stack<>();
            int count = 0;
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    count++;
                } else {
                    continue;
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return count;
        }*/
        // 利用完全二叉树的性质，如果一直向左走到底的深度等于一直向右走到底的深度，说明这是一棵“满二叉树”，可以直接通过公式 $2^h - 1$ 计算节点数，从而将时间复杂度从 $O(N)$ 降至 $O(\log^2 N)$。
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            // 统计最左侧路径的深度（包含自身节点）
            int leftDepth = 0;
            TreeNode leftNode = root;
            while (leftNode != null) {
                leftDepth++;
                leftNode = leftNode.left;
            }
            // 统计最右侧路径的深度（包含自身节点）
            int rightDepth = 0;
            TreeNode rightNode = root;
            while (rightNode != null) {
                rightDepth++;
                rightNode = rightNode.right;
            }
            // 如果左右深度相同，说明这是一棵满二叉树
            // 满二叉树节点数公式：2^h - 1。在 Java 中可以用移位运算 1 << depth 来高效计算 2^h
            if (leftDepth == rightDepth) {
                return (1 << leftDepth) - 1;
            }

            // 如果不相同，按普通二叉树逻辑往下递归
            // 但神奇的是，因为完全二叉树的性质，下一次递归必定有一边会触发满二叉树的条件并直接返回！
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        /*
        初始调用：countNodes(节点 1)
        最左深度（1->2->4）: leftDepth = 3
        最右深度（1->3）: rightDepth = 2
        不相等。返回 1 + countNodes(节点 2) + countNodes(节点 3)。
        递归执行：countNodes(节点 2)
        最左深度（2->4）: leftDepth = 2
        最右深度（2->5）: rightDepth = 2
        相等！这是一棵满二叉树。直接利用公式：$2^2 - 1 = 3$。节点 4 和节点 5 被直接跳过了！返回 3。
        递归执行：countNodes(节点 3)
        最左深度（3->6）: leftDepth = 2
        最右深度（3->null）: rightDepth = 1不相等。
        返回 1 + countNodes(节点 6) + countNodes(null)。
        递归执行：countNodes(节点 6)左右深度均为 1。返回 $2^1 - 1 = 1$。
        递归执行：countNodes(null)根为空，返回 0。
         */
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