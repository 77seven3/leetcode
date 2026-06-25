#
# 
# 表： Weather 
# 
# 
#
# 
#+---------------+---------+
#| Column Name   | Type    |
#+---------------+---------+
#| id            | int     |
#| recordDate    | date    |
#| temperature   | int     |
#+---------------+---------+
#id 是该表具有唯一值的列。
#没有具有相同 recordDate 的不同行。
#该表包含特定日期的温度信息 
#
# 
#
# 编写解决方案，找出与之前（昨天的）日期相比温度更高的所有日期的 id 。 
#
# 返回结果 无顺序要求 。 
#
# 结果格式如下例子所示。 
#
# 
#
# 示例 1： 
#
# 
#输入：
#Weather 表：
#+----+------------+-------------+
#| id | recordDate | Temperature |
#+----+------------+-------------+
#| 1  | 2015-01-01 | 10          |
#| 2  | 2015-01-02 | 25          |
#| 3  | 2015-01-03 | 20          |
#| 4  | 2015-01-04 | 30          |
#+----+------------+-------------+
#输出：
#+----+
#| id |
#+----+
#| 2  |
#| 4  |
#+----+
#解释：
#2015-01-02 的温度比前一天高（10 -> 25）
#2015-01-04 的温度比前一天高（20 -> 30） 
#
#
# Related Topics 数据库 👍 750 👎 0

package leetcode.editor.cn;

public class RisingTemperature {
    public static void main(String[] args) {
        Solution solution = new RisingTemperature().new Solution();
        // 在这里写测试用例
    }
-- 1. 如果表已存在则删除（方便重复测试）
DROP TABLE IF EXISTS Weather;

-- 2. 创建表结构
CREATE TABLE Weather (
     id INT PRIMARY KEY,
     recordDate DATE NOT NULL,
     temperature INT NOT NULL
);

-- 3. 插入示例数据
INSERT INTO Weather (id, recordDate, temperature) VALUES (1, '2015-01-01', 10);
INSERT INTO Weather (id, recordDate, temperature) VALUES (2, '2015-01-02', 25);
INSERT INTO Weather (id, recordDate, temperature) VALUES (3, '2015-01-03', 20);
INSERT INTO Weather (id, recordDate, temperature) VALUES (4, '2015-01-04', 30);

#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below

SELECT
    w1.id
FROM
    Weather w1
        LEFT JOIN Weather w2 ON DATEDIFF( w1.recordDate, w2.recordDate ) = 1
WHERE
    w1.temperature > w2.temperature

#leetcode submit region end(Prohibit modification and deletion)

}