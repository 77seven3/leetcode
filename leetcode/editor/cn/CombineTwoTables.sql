#表: Person 
#
# 
#+-------------+---------+
#| 列名         | 类型     |
#+-------------+---------+
#| PersonId    | int     |
#| FirstName   | varchar |
#| LastName    | varchar |
#+-------------+---------+
#personId 是该表的主键（具有唯一值的列）。
#该表包含一些人的 ID 和他们的姓和名的信息。
# 
#
# 
#
# 表: Address 
#
# 
#+-------------+---------+
#| 列名         | 类型    |
#+-------------+---------+
#| AddressId   | int     |
#| PersonId    | int     |
#| City        | varchar |
#| State       | varchar |
#+-------------+---------+
#addressId 是该表的主键（具有唯一值的列）。
#该表的每一行都包含一个 ID = PersonId 的人的城市和州的信息。
# 
#
# 
#
# 编写解决方案，报告 Person 表中每个人的姓、名、城市和州。如果 personId 的地址不在 Address 表中，则报告为 null 。 
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
#Person表:
#+----------+----------+-----------+
#| personId | lastName | firstName |
#+----------+----------+-----------+
#| 1        | Wang     | Allen     |
#| 2        | Alice    | Bob       |
#+----------+----------+-----------+
#Address表:
#+-----------+----------+---------------+------------+
#| addressId | personId | city          | state      |
#+-----------+----------+---------------+------------+
#| 1         | 2        | New York City | New York   |
#| 2         | 3        | Leetcode      | California |
#+-----------+----------+---------------+------------+
#输出: 
#+-----------+----------+---------------+----------+
#| firstName | lastName | city          | state    |
#+-----------+----------+---------------+----------+
#| Allen     | Wang     | Null          | Null     |
#| Bob       | Alice    | New York City | New York |
#+-----------+----------+---------------+----------+
#解释: 
#地址表中没有 personId = 1 的地址，所以它们的城市和州返回 null。
#addressId = 1 包含了 personId = 2 的地址信息。 
#
# Related Topics 数据库 👍 1644 👎 0

package leetcode.editor.cn;

public class CombineTwoTables {
    public static void main(String[] args) {
        Solution solution = new CombineTwoTables().new Solution();
        // 在这里写测试用例
    }
-- 如果表已存在则删除，方便重复运行脚本
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Person;

-- 创建 Person 表
CREATE TABLE Person (
                        PersonId INT PRIMARY KEY,
                        FirstName VARCHAR(255),
                        LastName VARCHAR(255)
);

-- 创建 Address 表
CREATE TABLE Address (
                         AddressId INT PRIMARY KEY,
                         PersonId INT,
                         City VARCHAR(255),
                         State VARCHAR(255)
);
-- 向 Person 表插入数据
INSERT INTO Person (PersonId, LastName, FirstName)
VALUES
    (1, 'Wang', 'Allen'),
    (2, 'Alice', 'Bob');

-- 向 Address 表插入数据
INSERT INTO Address (AddressId, PersonId, City, State)
VALUES
    (1, 2, 'New York City', 'New York'),
    (2, 3, 'Leetcode', 'California');
#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below

SELECT
    firstName,
    lastName,
    city,
    state
FROM
    Person p
    LEFT JOIN Address a ON p.personId = a.personId;

#leetcode submit region end(Prohibit modification and deletion)

}