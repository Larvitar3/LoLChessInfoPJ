
-- 시너지 By 계열

SELECT L.line, L.lineSynergyEffect, L.lineSynergyCharacteristic
FROM linetable AS L
WHERE L.line = '별';

SELECT C.name
FROM linetable AS L
JOIN synergytable AS S
ON L.id = S.lineId
JOIN championtable AS C
ON S.championId =  C.id
WHERE L.line = '별'
GROUP BY C.name;








