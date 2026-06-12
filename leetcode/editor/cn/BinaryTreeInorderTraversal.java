// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1：
// 
// 
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
// 输入：root = []
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：root = [1]
// 输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2439 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            // 递归
            /*List<Integer> res = new ArrayList<>();
            dfs(root,  res);
            return res;*/

            // 迭代
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                // 1. 一路向左冲，把路径上的所有节点都压入“备忘录”栈中
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    // 2. 撞到南墙（cur 为 null）了，说明左边走完了
                    // 从备忘录中弹出一个节点，这个节点绝对是当前最左下角的节点
                    cur = stack.pop();
                    // 中序遍历的核心：左边处理完了，现在处理“中”（也就是节点本身）
                    res.add(cur.val);
                    // 3. 准备去右子树重复相同的故事
                    cur = cur.right;
                }
            }
            return res;
        }

        public void dfs(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
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