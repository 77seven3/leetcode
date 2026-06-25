#表：Employee 
#
# 
#+-------------+---------+
#| Column Name | Type    |
#+-------------+---------+
#| id          | int     |
#| name        | varchar |
#| salary      | int     |
#| managerId   | int     |
#+-------------+---------+
#id 是该表的主键（具有唯一值的列）。
#该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
# 
#
# 
#
# 编写解决方案，找出收入比经理高的员工。 
#
# 以 任意顺序 返回结果表。 
#
# 结果格式如下所示。 
#
# 
#
# 示例 1: 
#
# 
#输入: 
#Employee 表:
#+----+-------+--------+-----------+
#| id | name  | salary | managerId |
#+----+-------+--------+-----------+
#| 1  | Joe   | 70000  | 3         |
#| 2  | Henry | 80000  | 4         |
#| 3  | Sam   | 60000  | Null      |
#| 4  | Max   | 90000  | Null      |
#+----+-------+--------+-----------+
#输出: 
#+----------+
#| Employee |
#+----------+
#| Joe      |
#+----------+
#解释: Joe 是唯一挣得比经理多的雇员。 
#
# Related Topics 数据库 👍 801 👎 0

package leetcode.editor.cn;

public class EmployeesEarningMoreThanTheirManagers {
    public static void main(String[] args) {
        Solution solution = new EmployeesEarningMoreThanTheirManagers().new Solution();
        // 在这里写测试用例
    }

-- 如果表已存在则删除，方便重复运行脚本
DROP TABLE IF EXISTS Employee;

-- 创建 Employee 表
CREATE TABLE Employee (
      id INT PRIMARY KEY,
      name VARCHAR(255),
      salary INT,
      managerId INT
);

-- 向 Employee 表插入示例数据
INSERT INTO Employee (id, name, salary, managerId)
VALUES
    (1, 'Joe', 70000, 3),
    (2, 'Henry', 80000, 4),
    (3, 'Sam', 60000, NULL),
    (4, 'Max', 90000, NULL);

#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below

    SELECT
        e1.NAME Employee
    FROM
        Employee e1
        LEFT JOIN Employee e2 ON e1.managerId = e2.id
    WHERE
        e1.salary > e2.salary

#leetcode submit region end(Prohibit modification and deletion)

}