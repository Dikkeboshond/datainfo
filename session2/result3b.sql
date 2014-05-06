SELECT a.pid as personID
FROM Acts a
INNER JOIN Movie m
WHERE a.mid = m.mid;