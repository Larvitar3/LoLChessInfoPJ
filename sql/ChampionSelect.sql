

-- 챔피언정보
-- SELECT * FROM championtable;

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


-- 챔피언검색 끝

-- 챔피언 계열 , 첫번째 넣을 계열 사진 없음

SELECT l.name AS lineName, l.lineSynergyEffect as lineSynergyEffect, l.lineSynergyCharacteristic as lineSynergyCharacteristic
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN lineTable AS l
ON s.lineId = l.id
where l.name = '별'
group by l.name;

-- 챔피언 계열 , 첫번째 넣을 계열 사진 없음

SELECT l.name AS lineName, c.imageRoute AS champImage, c.name AS champName
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN lineTable AS l
ON s.lineId = l.id
where l.name = '별'
group by c.name;

SELECT l.name AS lineName, c.imageRoute AS champImage, c.name AS champName  
FROM championtable AS c  JOIN synergyTable AS s  ON c.id = s.championId  
JOIN lineTable AS l  ON s.lineId = l.id  
where l.name =  '용사냥꾼'  
group by c.name ;




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

select * from tribeTable;

-- 챔피언 종족 종족 사진 아직 없음.
SELECT t.name AS tribeName, c.imageRoute AS imageAddress, c.name AS name
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN tribeTable AS t
ON s.tribeId1 = t.id
WHERE t.name = '기병대'
group by c.name;




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


-- 코인찐
SELECT c.price
FROM championtable AS C
join synergytable AS S
ON c.id = s.championId
JOIN linetable AS L
ON L.id = s.lineId
JOIN tribetable AS T
ON T.id = s.tribeId1
WHERE c.name = ?
group by c.name;



-- 라인 찐
SELECT l.name AS lineName, c.imageRoute AS champImage,   c.name AS name 
FROM championtable AS c   
JOIN synergyTable AS s   
ON c.id = s.championId 
JOIN lineTable AS l   
ON s.lineId = l.id   
where l.name = '용사냥꾼'  
group by c.name;

