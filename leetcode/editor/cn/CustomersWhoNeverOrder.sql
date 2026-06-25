#Customers 表： 
#
# 
#+-------------+---------+
#| Column Name | Type    |
#+-------------+---------+
#| id          | int     |
#| name        | varchar |
#+-------------+---------+
#在 SQL 中，id 是该表的主键。
#该表的每一行都表示客户的 ID 和名称。 
#
# Orders 表： 
#
# 
#+-------------+------+
#| Column Name | Type |
#+-------------+------+
#| id          | int  |
#| customerId  | int  |
#+-------------+------+
#在 SQL 中，id 是该表的主键。
#customerId 是 Customers 表中 ID 的外键( Pandas 中的连接键)。
#该表的每一行都表示订单的 ID 和订购该订单的客户的 ID。 
#
# 
#
# 找出所有从不点任何东西的顾客。 
#
# 以 任意顺序 返回结果表。 
#
# 结果格式如下所示。 
#
# 
#
# 示例 1： 
#
# 
#输入：
#Customers table:
#+----+-------+
#| id | name  |
#+----+-------+
#| 1  | Joe   |
#| 2  | Henry |
#| 3  | Sam   |
#| 4  | Max   |
#+----+-------+
#Orders table:
#+----+------------+
#| id | customerId |
#+----+------------+
#| 1  | 3          |
#| 2  | 1          |
#+----+------------+
#输出：
#+-----------+
#| Customers |
#+-----------+
#| Henry     |
#| Max       |
#+-----------+ 
#
# Related Topics 数据库 👍 567 👎 0

package leetcode.editor.cn;

public class CustomersWhoNeverOrder {
    public static void main(String[] args) {
        Solution solution = new CustomersWhoNeverOrder().new Solution();
        // 在这里写测试用例
    }
-- 如果表已存在则删除，方便重复运行脚本
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Customers;

-- 创建 Customers 表
CREATE TABLE Customers (
                           id INT PRIMARY KEY,
                           name VARCHAR(255)
);

-- 创建 Orders 表
CREATE TABLE Orders (
                        id INT PRIMARY KEY,
                        customerId INT
);

-- 向 Customers 表插入示例数据
INSERT INTO Customers (id, name)
VALUES
    (1, 'Joe'),
    (2, 'Henry'),
    (3, 'Sam'),
    (4, 'Max');

-- 向 Orders 表插入示例数据
INSERT INTO Orders (id, customerId)
VALUES
    (1, 3),
    (2, 1);
#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below

    SELECT NAME AS Customers
    FROM
        customers c
            LEFT JOIN Orders o ON c.id = o.customerId
    WHERE
        o.customerId IS NULL

#leetcode submit region end(Prohibit modification and deletion)

}