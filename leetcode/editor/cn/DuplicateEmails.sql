#
# 
#
# 表: Person 
#
# 
#+-------------+---------+
#| Column Name | Type    |
#+-------------+---------+
#| id          | int     |
#| email       | varchar |
#+-------------+---------+
#id 是该表的主键（具有唯一值的列）。
#此表的每一行都包含一封电子邮件。电子邮件不包含大写字母。
# 
#
# 
#
# 编写解决方案来报告所有重复的电子邮件。 请注意，可以保证电子邮件字段不为 NULL。
#
# 以 任意顺序 返回结果表。
#
# 结果格式如下例。
#
# 
#
# 示例 1: 
#
# 
#输入: 
#Person 表:
#+----+---------+
#| id | email   |
#+----+---------+
#| 1  | a@b.com |
#| 2  | c@d.com |
#| 3  | a@b.com |
#+----+---------+
#输出: 
#+---------+
#| Email   |
#+---------+
#| a@b.com |
#+---------+
#解释: a@b.com 出现了两次。
#
# Related Topics 数据库 👍 552 👎 0

package leetcode.editor.cn;

public class DuplicateEmails {
    public static void main(String[] args) {
        Solution solution = new DuplicateEmails().new Solution();
        // 在这里写测试用例
    }
-- 如果表已存在则删除，方便重复运行脚本
DROP TABLE IF EXISTS Person;

-- 创建 Person 表
CREATE TABLE Person (
    id INT PRIMARY KEY,
    email VARCHAR(255)
);

-- 向 Person 表插入示例数据
INSERT INTO Person (id, email)
VALUES
    (1, 'a@b.com'),
    (2, 'c@d.com'),
    (3, 'a@b.com');

#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below

    SELECT
        email Email
    FROM
        Person
    GROUP BY
        email
    HAVING
        count( email ) >1

#leetcode submit region end(Prohibit modification and deletion)

}