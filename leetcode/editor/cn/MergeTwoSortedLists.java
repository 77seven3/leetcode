// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
// 
// 
// 输入：l1 = [1,2,4], l2 = [1,3,4]
// 输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
// 输入：l1 = [], l2 = []
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：l1 = [], l2 = [0]
// 输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 4067 👎 0

package leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // Solution solution = new MergeTwoSortedLists().new Solution();
        // 在这里写测试用例

        // 1. 实例化外部类和 Solution 类
        MergeTwoSortedLists outer = new MergeTwoSortedLists();
        Solution solution = outer.new Solution();

        // 2. 构造测试链表 l1: [1, 2, 4]
        ListNode l1 = outer.new ListNode(1);
        l1.next = outer.new ListNode(2);
        l1.next.next = outer.new ListNode(4);

        // 3. 构造测试链表 l2: [1, 3, 4]
        ListNode l2 = outer.new ListNode(1);
        l2.next = outer.new ListNode(3);
        l2.next.next = outer.new ListNode(4);

        // 4. 调用你的解法
        ListNode mergedList = solution.mergeTwoLists(l1, l2);

        // 5. 打印结果，预期输出: [1, 1, 2, 3, 4, 4]
        printList(mergedList);

    }

    // 辅助方法：用来将链表打印成数组的格式，方便对比结果
    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 递归解法
            /*if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }*/
            // 虽然递归写法极其简洁优雅，但它有一个隐患：栈溢出。如果链表非常长（比如几万个节点），递归调用栈也会达到几万层，导致内存崩溃。
            // 为了在工程上达到极致的安全和性能，我们通常使用迭代法（循环）。
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            // 当两个链表都还有节点时，进行比较
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;    // 把 l1 接上去
                    list1 = list1.next;  // l1 指针后移
                } else {
                    cur.next = list2;    // 把 l2 接上去
                    list2 = list2.next;  // l2 指针后移
                }
                cur = cur.next;          // 游标始终走到最新拼接的节点上
            }
            // 循环结束后，肯定最多只有一个链表还没遍历完，直接把剩下的全部接上去即可
            cur.next = (list1 != null) ? list1 : list2;
            return dummy.next;
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