-- 아이템 By 이름

SELECT I.imageRoute, I.name AS NAME, I.itemEffect AS IE, IMT1.name, IMT2.name
FROM itemtable AS I
JOIN itemmaterialtable1 AS IMT1
ON I.materialId1 = IMT1.id
JOIN itemmaterialtable2 AS IMT2
ON I.materialId2 = IMT2.id
WHERE I.name LIKE '%쇼%';

select * from itemtable;

-- 아이템 By 이름 end --



-- 아이템 By 효과 
SELECT I.imageRoute, I.name AS NAME, I.itemEffect AS IE, IMT1.name, IMT2.name
FROM itemtable AS I
JOIN itemmaterialtable1 AS IMT1
ON I.materialId1 = IMT1.id
JOIN itemmaterialtable2 AS IMT2
ON I.materialId2 = IMT2.id
WHERE I.itemEffect LIKE '%추가%';
-- 아이템 By 효과 END


-- 아이템 By 재료
SELECT IMT1.imageRoute, IMT1.name, IMT1.materialEffect, 
I.imageRoute, I.name, IMT2.name
FROM itemmaterialtable1 AS IMT1
JOIN itemtable AS I
ON IMT1.id = I.materialId1
JOIN itemmaterialtable2 AS IMT2
ON IMT2.id = I.materialId2
WHERE IMT1.name LIKE '%대%';


select * from synergytable;


