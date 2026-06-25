// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,2,3,4,5]
// 输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
// 输入：head = [1,2]
// 输出：[2,1]
// 
//
// 示例 3： 
//
// 
// 输入：head = []
// 输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 4151 👎 0

package leetcode.editor.cn;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
        public ListNode reverseList(ListNode head) {
            ListNode prev = null; // 指向前一个节点，初始为 null
            ListNode curr = head; // 指向当前节点，初始为头节点

            while (curr != null) {
                // 1. 暂存当前节点的下一个节点，防止链表断裂后找不到路
                ListNode nextTemp = curr.next;
                // 2. 核心操作：当前节点反转指向前一个节点
                curr.next = prev;
                // 3. prev 指针前进一步（注意顺序，必须是 prev 先跟上 curr）
                prev = curr;
                // 4. curr 指针前进一步，准备处理下一个节点
                curr = nextTemp;
            }
            return prev;
        }
        // 递归
        /*public ListNode reverseList(ListNode head) {
            // 递归终止条件：当前节点为空，或者当前节点是最后一个节点
            if (head == null || head.next == null) {
                return head;
            }
            // 递归调用，翻转当前节点之后的所有节点，newHead 始终是原链表的最后一个节点
            ListNode newHead = reverseList(head.next);
            // 将下一个节点（已经被反转后的末尾节点）的 next 指向自己
            head.next.next = head;
            // 将自己的 next 指向 null，防止产生环
            head.next = null;
            return newHead;
        }*/
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