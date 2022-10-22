

-- 챔피언정보
-- SELECT * FROM championtable;


select name as champName, price, hp, powe, dps as dps, attackRange as attackRange, attackSpeed as attackSpeed,
defense as defense, magicResistance as magicResistance, imageRoute as imageRoute
from championtable as C
WHERE name = '니달리';

SELECT name AS champName, price AS price, hp AS hp, power AS power, dps AS dps, attackRange AS attackRange, attackSpeed AS attackSpeed,
defense AS defense, magicResistance AS magicResistance, imageRoute AS imageRoute
FROM championtable
WHERE name = ? ;

select name as champName, price as price, hp as hp,  power as power, dps as dps, attackRange as attackRange,  attackSpeed as attackSpeed, defense as defense, magicResistance as magicResistance, imageRoute as imageRoute from championtable WHERE name = '니달리';

-- 챔피언 계열 , 첫번째 넣을 계열 사진 없음

select l.name as lineName, c.imageRoute as champImage, c.name as champName
from championtable as c
join synergyTable as s
on c.id = s.championId
join lineTable as l
on s.lineId = l.id
WHERE l.name = '용사냥꾼'
group by c.name;


SELECT l.name AS lineName, l.lineSynergyEffect as lineSynergyEffect, l.lineSynergyCharacteristic as lineSynergyCharacteristic
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN lineTable AS l
ON s.lineId = l.id
where l.name = '용사냥꾼'
group by l.name;

-- 챔피언 계열 , 첫번째 넣을 계열 사진 없음

SELECT l.name AS lineName, c.imageRoute AS champImage, c.name AS champName
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN lineTable AS l
ON s.lineId = l.id
where l.name = '용사냥꾼'
group by c.name;

-- select * from lineTable;

/*
-- 챔피언 종족 종족 사진 아직 없음.
SELECT t.name AS tribeName, t.tribeSynergyEffect as tribeSynergyEffect, t.tribeSynergyCharacteristic as tribeSynergyCharacteristic
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN tribeTable AS t
ON s.tribeId = t.id
WHERE t.name = '별'
group by t.name;
*/

--  select * from tribeTable;

-- 챔피언 종족 종족 사진 아직 없음.
SELECT c.imageRoute AS champImage, c.name AS champName
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN tribeTable AS t
ON s.tribeId1 = t.id
WHERE t.name = '기병대'
group by c.name;

SELECT l.name AS lineName, c.name AS name, c.imageRoute AS champImage  FROM championtable AS c  JOIN synergyTable AS s  ON c.id = s.championId  JOIN lineTable AS l  ON s.lineId = l.id  where l.name = ''  group by c.name ;


select name
from championtable
WHERE price = 1;

-- 캐릭터 비용
SELECT price, name
FROM championtable
WHERE price = 1
ORDER BY price;

SELECT * , (
SELECT T.name
FROM championtable as C
join synergytable AS S
ON c.id = s.championId
JOIN linetable AS L
ON L.id = s.lineId
JOIN tribetable AS T
ON T.id = s.tribeId2
WHERE c.name = '릴리아'
group by c.name) AS T2
FROM championtable as C
join synergytable AS S
ON c.id = s.championId
JOIN linetable AS L
ON L.id = s.lineId
JOIN tribetable AS T
ON T.id = s.tribeId1
WHERE c.name = '릴리아'
group by c.name;












