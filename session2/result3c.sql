SELECT DISTINCT p.name AS pName FROM Person p, Writes w
WHERE NOT EXISTS (SELECT d.mid AS regisseurlozefilm FROM Directs d WHERE d.mid = w.mid)
AND w.pid = p.pid;
