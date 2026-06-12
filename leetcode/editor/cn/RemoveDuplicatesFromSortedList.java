// 给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,1,2]
// 输出：[1,2]
// 
//
// 示例 2： 
// 
// 
// 输入：head = [1,1,2,3,3]
// 输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 1265 👎 0

package leetcode.editor.cn;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        // 在这里写测试用例
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 单指针遍历与“跳位”拼接：使用一个游标指针 cur 遍历链表。如果发现 cur.val == cur.next.val，直接把 cur.next 指向 cur.next.next（跨过重复节点，将其“孤立”淘汰）；
            // 否则，游标指针正常后移一步。
            if (head == null) {
                return null;
            }

            // 使用一个游标 cur 来代替 head 遍历链表，以免丢失原本的头节点位置
            ListNode cur = head;
            while (cur.next != null) {
                ListNode next = null;
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}