CREATE TABLE championTable(
	id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR (10) NOT NULL,
    price INT NOT NULL,
    hp INT NOT NULL,
    power INT NOT NULL,
    dps INT NOT NULL,
    attackRange VARCHAR(10) NOT NULL,
    attackSpeed DOUBLE NOT NULL,
    defense INT NOT NULL,
    magicResistance INT NOT NULL,
    imageRoute VARCHAR(100),
    PRIMARY KEY (id)
);


-- 챔피언정보
SELECT * FROM championtable;

SELECT name AS champName, price AS price, hp AS hp, power AS power, dps AS dps, attackRange AS attackRange, attackSpeed AS attackSpeed,
defense AS defense, magicResistance AS magicResistance, imageRoute AS imageRoute
FROM championtable
WHERE name = ? ;


-- 챔피언 계열 , 첫번째 넣을 계열 사진 없음
SELECT l.name AS lineName, c.imageRoute AS champImage, c.name AS champName
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN lineTable AS l
ON s.lineId = l.id;


-- 챔피언 종족 종족 사진 아직 없음.
SELECT t.name AS tribeName, c.imageRoute AS champImage, c.name AS champName
FROM championtable AS c
JOIN synergyTable AS s
ON c.id = s.championId
JOIN tribeTable AS t
ON s.tribeId = t.id;


-- 캐릭터 비용
SELECT  price AS price , imageRoute AS imageRoute , name AS champName
FROM championtable
ORDER BY price;



