# Write your MySQL query statement below
SELECT
    CASE
        WHEN s.id % 2 = 1 AND s.id + 1 <= m.max_id THEN s.id + 1
        WHEN s.id % 2 = 0 THEN s.id - 1
        ELSE s.id
    END AS id,
    s.student
FROM Seat s
JOIN (SELECT MAX(id) AS max_id FROM Seat) m
ORDER BY id;
