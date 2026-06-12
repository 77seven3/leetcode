// 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
//
// 
//
// 示例 1： 
// 
// 
// 输入：nums = [-10,-3,0,5,9]
// 输出：[0,-3,9,-10,null,5]
// 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
// 输入：nums = [1,3]
// 输出：[3,1]
// 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1813 👎 0

package leetcode.editor.cn;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
        // 二叉搜索树 (BST)： 必须满足“左边的数字 < 根节点的数字 < 右边的数字”。
        // 平衡 (Balanced)： 任何一个节点的左子树和右子树的“高度差”不能超过 1。
        // 为了让树“平衡”，我们通常会选择升序数组的中间那个数作为根节点。因为中间的数能把剩下的数字平分到左子树和右子树，这样两边的高度自然就差不多了。
        // 一旦遇到长度为偶数的片段（比如剩 2 个数，或者剩 4 个数），你取“靠左的数”还是“靠右的数”作为中间节点都是完全符合题目要求的。
        public TreeNode sortedArrayToBST(int[] nums) {
            return builderTree(nums, 0, nums.length - 1);
        }

        // 根据数组的 [left, right] 区间构建并返回 BST 的根节点
        private TreeNode builderTree(int[] nums, int left, int right) {
            // 基线条件：区间非法（没有元素了），返回空节点
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = builderTree(nums, left, mid - 1);
            root.right = builderTree(nums, mid + 1, right);
            return root;
        }
        /*public TreeNode sortedArrayToBST(int[] nums) {
            TreeNode treeNode = new TreeNode();

            builderTree(treeNode.left, 0, nums.length, nums);
            builderTree(treeNode.right, (nums.length - 1) / 2 + 1, nums.length, nums);
            return treeNode;
        }

        private void builderTree(TreeNode treeNode, int start, int len, int[] nums) {
            int length = (len - 1) / 2;
            treeNode.val = nums[length];
            if (len <= 1) return;
            builderTree(treeNode.left, start, length, nums);
            builderTree(treeNode.right, start + length + 1, length, nums);
        }*/
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