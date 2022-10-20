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
select * from championtable;

select name as champName, price as price, hp as hp, power as power, dps as dps, attackRange as attackRange, attackSpeed as attackSpeed,
defense as defense, magicResistance as magicResistance, imageRoute as imageRoute
from championtable;


-- 챔피언 계열 , 첫번째 넣을 계열 사진 없음
select l.name as lineName, c.imageRoute as champImage, c.name as champName
from championtable as c
join synergyTable as s
on c.id = s.championId
join lineTable as l
on s.lineId = l.id;


-- 챔피언 종족 종족 사진 아직 없음.
select t.name as tribeName, c.imageRoute as champImage, c.name as champName
from championtable as c
join synergyTable as s
on c.id = s.championId
join tribeTable as t
on s.tribeId = t.id;


-- 캐릭터 비용
select  price as price , imageRoute as imageRoute , name as champName
from championtable
order by price;



