# Write your MySQL query statement below
SELECT MAX(salary) as SecondHighestSalary
FROM Employee WHERE SALARY < (SELECT MAX(SALARY) from Employee)