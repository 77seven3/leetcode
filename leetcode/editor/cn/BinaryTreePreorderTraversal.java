// 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
//
// 
// 输入：root = [1,null,2,3] 
// 
//
// 输出：[1,2,3] 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9] 
// 
//
// 输出：[1,2,4,5,6,7,3,8,9] 
//
// 解释： 
//
// 
//
// 示例 3： 
//
// 
// 输入：root = [] 
// 
//
// 输出：[] 
//
// 示例 4： 
//
// 
// 输入：root = [1] 
// 
//
// 输出：[1] 
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1406 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        /*public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            return check(root, res);
        }
        private List<Integer> check(TreeNode root, List<Integer> res) {
            if(root != null){
                res.add(root.val);
            }else {
                return res;
            }
            if(root.left != null){
                check(root.left, res);
            }
            if(root.right != null){
                check(root.right, res);
            }
            return res;
        }*/
        // 在工程实践中，如果树的深度极其深，递归可能会导致栈溢出 (StackOverflowError)。
        // 将递归转为迭代，也就是我们自己在内存里维护一个栈，是非常重要的基本功。
        // 利用栈 (Stack) 后进先出 (LIFO) 的特性来模拟系统底层的递归调用栈。
        // 遍历时先记录当前节点，然后将右子节点压栈，再将左子节点压栈（保证左子节点先出栈），从而实现 $O(N)$ 的迭代版前序遍历。
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
            // 初始化 将根节点压入栈中
            stack.push(root);
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                // 因为栈是后进先出 (LIFO)，所以必须先压右节点，再压左节点！
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return res;
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