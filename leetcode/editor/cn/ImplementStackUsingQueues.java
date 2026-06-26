// 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
// 输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
// 输出：
//[null, null, null, 2, 2, false]
//
// 解释：
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.top(); // 返回 2
// myStack.pop(); // 返回 2
// myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否仅用一个队列来实现栈。 
//
// Related Topics 栈 设计 队列 👍 1001 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    // 核心解法： 使用单个队列模拟栈，每次 push 新元素后，将队列中原有的旧元素依次出队并重新入队到队尾，从而把最新加入的元素“顶”到队头，完美实现“后入先出（LIFO）”。
    // leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            // 1. 记录当前队列的长度（也就是我们要翻转的旧元素个数）
            int size = queue.size();

            // 2. 将新元素加入队尾
            queue.offer(x);

            // 3. 将前面的所有旧元素依次出队，并重新排到队尾
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            // 因为我们在 push 时已经保证最后进来的元素在队头，直接 poll 即可
            return queue.poll();
        }

        public int top() {
            // 直接查看队头元素
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)

}