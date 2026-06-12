// 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：p = [1,2,3], q = [1,2,3]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：p = [1,2], q = [1,null,2]
// 输出：false
// 
//
// 示例 3： 
// 
// 
// 输入：p = [1,2,1], q = [1,1,2]
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1303 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            // 使用单队列同步压入成对节点
            /*Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                // 两个都为空，没问题，跳过这轮去查后面的
                if (node1 == null && node2 == null) continue;
                // 一个空一个不空，结构不同
                if (node1 == null || node2 == null) return false;
                // 值不同
                if (node1.val != node2.val) return false;
                // 注意入队的顺序，必须成双成对！
                // 把两棵树的左孩子排在一起
                queue.offer(node1.left);
                queue.offer(node2.left);
                // 把两棵树的右孩子排在一起
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            return true;*/

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