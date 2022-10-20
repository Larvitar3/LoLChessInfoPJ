
-- 시너지 By 계열
SELECT L.name, L.lineSynergyEffect, L.lineSynergyCharacteristic
FROM linetable AS L
WHERE L.name = '별';

SELECT C.name
FROM linetable AS L
JOIN synergytable AS S
ON L.id = S.lineId
JOIN championtable AS C
ON S.championId =  C.id
WHERE L.name = '별'
GROUP BY C.name;
-- 시너지 By 계열 end


-- 시너지 By 종족
SELECT T.name, T.tribeSynergyEffect, T.tribeSynergyCharacteristic
FROM tribetable AS T
WHERE T.name = '용';

SELECT C.name
FROM tribetable AS T
JOIN synergytable AS S
ON T.id = S.lineId
JOIN championtable AS C
ON S.championId =  C.id
WHERE T.name = '용'
GROUP BY C.name;
-- 시너지 by 종족 end

-- 시너지 by 효과 --
SELECT L.name, L.lineSynergyEffect, L.lineSynergyCharacteristic
FROM linetable AS L
WHERE L.lineSynergyEffect like '%별%'
OR L.lineSynergyCharacteristic Like '%플%';

SELECT T.name, T.tribeSynergyEffect, T.tribeSynergyCharacteristic
FROM tribetable AS T
WHERE T.tribeSynergyEffect like '%마%'
OR T.tribeSynergyCharacteristic Like '%저항력%';

SELECT C.name, L.name
FROM linetable AS L
JOIN synergytable AS S
ON L.id = S.lineId
JOIN championtable AS C
ON S.championId =  C.id
WHERE L.lineSynergyEffect like '%별%'
OR L.lineSynergyCharacteristic Like '%아%';

SELECT C.name, T.name
FROM tribetable AS T
JOIN synergytable AS S
ON T.id = S.lineId
JOIN championtable AS C
ON S.championId =  C.id
WHERE T.tribeSynergyEffect like '%마%'
OR T.tribeSynergyCharacteristic Like '%저항력%';
-- 시너지 By 효과 end 























