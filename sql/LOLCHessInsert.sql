


/*
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
    PRIMARY KEY (id)
);
*/

<<<<<<< HEAD
=======

-- desc championTable;
-- select * from championTable;


>>>>>>> b396b56798ccc40d5ee3d4a150a8b51e23f83fe7
insert into championTable
values ( 1 , '니달리' , 1 , 600 , 60 , 42 , '★★★★☆' , 0.7 , 30 , 30 ,'Images/Nidalee.png');
UPDATE championTable SET name = '니달리'
WHERE imageRoute = 'Images/Nidalee.png';

insert into championTable 
values ( 2 , '블라디미르' , 1 , 700 , 40 , 24 , '★★☆☆☆' , 0.6 , 45 , 45,'C:\\LoLChessPJ\\Images\\Vladimir.png' );
insert into championTable 
values ( 3 , '스카너' , 1 , 650 , 60 , 36 , '★☆☆☆☆' , 0.6 , 45 , 45,'C:\\LoLChessPJ\\Images\\Skarner.png' );
insert into championTable 
values ( 4 , '럭스' , 2 , 600 , 30 , 21 , '★★★★☆' , 0.7 , 20 , 20,'C:\\LoLChessPJ\\Images\\Lux.jpg' );
insert into championTable 
values ( 5 , '바루스' , 3 , 650 , 55 , 39 , '★★★☆☆' , 0.7 , 25 , 25,'C:\\LoLChessPJ\\Images\\Varus.png' );
insert into championTable 
values ( 6 , '아우렐리온 솔' , 8 , 800 , 60 , 45 , '★★★★☆' , 0.75 , 35 , 35,'C:\\LoLChessPJ\\Images\\AurelionSol.png' );
insert into championTable 
values ( 7 , '릴리아' , 2 , 750 , 40 , 28 , '★☆☆☆☆' , 0.7 , 40 , 40,'C:\\LoLChessPJ\\Images\\Lillia.png' );
insert into championTable 
values ( 8 , '브라움' , 2 , 800 , 70 , 42 , '★☆☆☆☆' , 0.6 , 60 , 60,'C:\\LoLChessPJ\\Images\\Braum.png' );
insert into championTable
values ( 9 , '다이애나' , 3 , 700 , 50 , 38 , '★☆☆☆☆' , 0.75 , 35 , 35,'C:\\LoLChessPJ\\Images\\Diana.png' );
insert into championTable 
values ( 10 , '올라프' , 3 , 800 , 55 , 39 , '★☆☆☆☆' , 0.7 , 50 , 50,'C:\\LoLChessPJ\\Images\\Olaf.png' );
insert into championTable 
values ( 11 , '세주아니' , 1 , 650 , 60 , 33 , '★☆☆☆☆' , 0.55 , 40 , 40,'C:\\LoLChessPJ\\Images\\Sejuani.png' );
insert into championTable 
values ( 12 , '트위치' , 2 , 550 , 55 , 39 , '★★★☆☆' , 0.7 , 20 , 20,'C:\\LoLChessPJ\\Images\\Twitch.png' );
insert into championTable
values ( 13 , '제이스' , 4 , 900 , 90 , 72 , '★★★☆☆' , 0.8 , 25 , 25,'C:\\LoLChessPJ\\Images\\Jayce.jpg' );
insert into championTable
values ( 14 , '바드' , 5 , 850 , 60 , 42 , '★★★★☆' , 0.7 , 40 , 40,'C:\\LoLChessPJ\\Images\\Bard.png' );
insert into championTable
values ( 15 , '쌩쌩이' , 6 , 800 , 85 , 64 , '★☆☆☆☆' , 0.75 , 50 , 50,'C:\\LoLChessPJ\\Images\\Zippy.png' );
insert into championTable
values ( 16 , '렐' , 2 , 700 , 50 , 30 , '★☆☆☆☆' , 0.6 , 45 , 45,'C:\\LoLChessPJ\\Images\\Rell.jpg' );
insert into championTable 
values ( 17 , '아펠리오스' , 2 , 500 , 60 , 42 , '★★★★☆' , 0.7 , 20 , 20,'C:\\LoLChessPJ\\Images\\Aphelios.jpg' );
insert into championTable
values ( 18 , '렝가' , 3 , 700 , 70 , 53 , '★☆☆☆☆' , 0.75 , 30 , 30,'C:\\LoLChessPJ\\Images\\Rengar.jpg' );
insert into championTable
values ( 19 , '스웨인' , 7 , 900 , 40 , 24 , '★★☆☆☆' , 0.6 , 70 , 70,'C:\\LoLChessPJ\\Images\\Swain.jpg' );
insert into championTable
values ( 20 , '나서스' , 1 , 600 , 60 , 33 , '★☆☆☆☆' , 0.55 , 40 , 40,'C:\\LoLChessPJ\\Images\\Nasus.jpg' );
insert into championTable
values ( 21 , '잭스' , 2 , 750 , 55 , 39 , '★☆☆☆☆' , 0.7 , 45 , 45,'C:\\LoLChessPJ\\Images\\Jax.jpg' );
insert into championTable
values ( 22 , '볼리베어' , 3 , 800 , 50 , 38 , '★☆☆☆☆' , 0.75 , 50 , 50,'C:\\LoLChessPJ\\Images\\Volibear.png' );
insert into championTable
values ( 23 , '조이' , 5 , 800 , 45 , 34 , '★★★★☆' , 0.75 , 20 , 20,'C:\\LoLChessPJ\\Images\\Zoe.png' );
insert into championTable
values ( 24 , '이다스' , 7 , 950 , 90 , 50 , '★☆☆☆☆' , 0.55 , 60 , 60,'C:\\LoLChessPJ\\Images\\Idas.png' );
insert into championTable
values ( 25 , '자이라' , 2 , 600 , 40 , 26 , '★★★★☆' , 0.65 , 20 , 20,'C:\\LoLChessPJ\\Images\\Zyra.jpg' );
insert into championTable
values ( 26 , '사일러스' , 3 , 800 , 60 , 36 , '★☆☆☆☆' , 0.6 , 50 , 50,'C:\\LoLChessPJ\\Images\\Sylas.png' );
insert into championTable
values ( 27 , '판테온' , 4 , 1000 , 60 , 39 , '★☆☆☆☆' , 0.65 , 50 , 50,'C:\\LoLChessPJ\\Images\\Pantheon.jpg' );
insert into championTable
values ( 28 , '사이펜' , 7 , 900 , 90 , 63 , '★☆☆☆☆' , 0.7 , 60 , 60,'C:\\LoLChessPJ\\Images\\Syfen.png' );

insert into tribeTable   
values ( 1 , '기병대' , '기병대가 방어력과 마법 저항력을 얻습니다. 
전투 시작 및 돌격 이후 4초 동안 이 수치가 200% 증가합니다.' , '이동 시 대상에게 빠르게 돌격합니다.');
insert into tribeTable   
values ( 2 , '민첩사수' , '민첩사수와 대상 사이에 놓인 칸 하나당 해당 민첩사수가 공격 속도를 얻습니다.' , 
'공격 사거리가 2칸 증가합니다.' );
insert into tribeTable   
values ( 3 , '형상변환자' , '변신 시 추가 최대 체력을 얻습니다.', null );
insert into tribeTable   
values ( 4 , '신비술사' , '아군이 마법 저항력을 얻습니다.', null );
insert into tribeTable   
values ( 5 , '음유시인' , '바드는 춤을 출 때 항상 음표를 생성합니다. 
음표를 획득할 때마다 상점에서 단계가 높은 챔피언이 등장할 확률이 1%씩 증가합니다.' ,
'플레이어 대상 전투에서 아군이 살아남으면 2% 확률로 음표를 생성합니다.' );
insert into tribeTable   
values ( 6 , '용' , '용은 특성 중첩을 3 증가시키고 아군 용이 몇 마리 있는지에 따라 추가 효과를 얻습니다.' , 
'2개의 팀 슬롯이 필요합니다.' );
insert into tribeTable   
values ( 7 , '요술사' , '요술사는 스킬을 두 번 사용하고 총 주문력이 조정됩니다.', null );
insert into tribeTable   
values ( 8 , '일깨우는자' , '아군 또는 적이 스킬을 사용할 때마다 일깨우는 자가 마나를 얻습니다.', null );
insert into tribeTable   
values ( 9 , '포병대' , '5번째 공격마다 대포를 발사하고 대상 주변에 폭발을 일으켜 물리 피해를 입힙니다.', null );
insert into tribeTable   
values ( 10 , '암살자' , '암살자는 추가 치명타 피해량과 확률을 획득하며, 스킬에 치명타가 적용될 수 있습니다.' ,
'전투 시작 시 적의 후방으로 도약합니다.' );
insert into tribeTable   
values ( 11 , '수호자' , '전투당 한 번 체력이 50%일 때 가장 가까운 아군과 자신에게 최대 체력의 일정 비율만큼 
피해를 흡수하는 보호막을 씌웁니다. 보호막은 중첩됩니다!' , null);
insert into tribeTable   
values ( 12 , '주문도둑' , '조이가 스킬 사용 후와 라운드 시작 시마다 새 스킬을 가져갑니다.', null );
insert into tribeTable   
values ( 13 , '전사' , '전사가 공격 시 50%의 확률로 다음 공격의 피해량이 증가합니다.', null );
insert into tribeTable   
values ( 14 , '난동꾼' , '아군의 최대 체력이 증가합니다. 난동꾼은 두 배로 증가합니다.', null );
insert into tribeTable   
values ( 15 , '용술사' , '용술사의 축복을 사용해 영웅을 선택합니다. 
영웅의 체력과 주문력이 용술사의 별 레벨 하나당 20%씩 증가합니다.' , null);

-- desc lineTable;
-- SELECT * FROM tribeTable;

insert into lineTable   
values ( 1 , '별' , '플레이어 대상 전투 후 별의 구를 획득합니다.
아군 별 챔피언의 별 레벨 총합에 따라 구의 값어치가 달라집니다' , 
'별 챔피언은 추가 주문력을 얻습니다' );
insert into lineTable   
values ( 2 , '용사냥꾼' , 
'용사냥꾼이 체력이 1900보다 높은 적에게 받는 피해량이 15% 감소하고 피해량에 비례하는 추가 마법 피해를 입힙니다.', null );
insert into lineTable   
values ( 3 , '길드' , '아군에게 고유 보너스를 부여합니다. 길드원은 두 배로 얻습니다. 전장의 길드 아군마다 증가합니다!' , null);
insert into lineTable   
values ( 4 , '어둠강림' , '희생의 제단을 소환합니다. 전투 시작: 제단에 놓인 유닛이 희생되어, 보유한 아이템 하나의 복사본과 함께 추가 체력을 모든 어둠강림 챔피언에게 부여합니다.', 
'상징과 제작 불가 아이템은 복사되는 순간 오염되어 어둠강림 정수로 변합니다.' );
insert into lineTable   
values ( 5 , '빛비늘' , '무작위 빛비늘 한정 아이템을 부여합니다.' , '장착 유닛을 대기석에 놓으면 빛비늘 아이템을 제거할 수 있습니다.' );
insert into lineTable   
values ( 6 , '속삭임' , '속삭임이 피해를 입힌 적은 움츠러들며 6초 동안 방어력과 마법 저항력이 40% 감소합니다.' , 
'움츠러든 적에게 피해를 입힌 속삭임은 중첩되는 공격력과 주문력을 얻습니다.' );

-- SELECT * FROM linetable;

-- desc lineSynergyTable;

insert into lineSynergyTable  
values ( 1 , 1 , 3 , '주문력+5' );
insert into lineSynergyTable  
values ( 2 , 1 , 5 , '주문력+30' );
insert into lineSynergyTable  
values ( 3 , 2 , 2 , '마법피해 15% 증가' );
insert into lineSynergyTable  
values ( 4 , 2 , 4 , '마법피해 50% 증가' );
insert into lineSynergyTable  
values ( 5 , 3 , 1 , '능력치보너스 100% 증가' );
insert into lineSynergyTable  
values ( 6 , 3 , 2 , '능력치보너스 110% 증가' );
insert into lineSynergyTable  
values ( 7 , 3 , 3 , '능력치보너스 120% 증가' );
insert into lineSynergyTable  
values ( 8 , 3 , 4 , '능력치보너스 130% 증가' );
insert into lineSynergyTable  
values ( 9 , 3 , 5 , '능력치보너스 140% 증가' );
insert into lineSynergyTable  
values ( 10 , 4 , 2 , '체력 +500' );
insert into lineSynergyTable  
values ( 11 , 4 , 4 , '체력 +750' );
insert into lineSynergyTable  
values ( 12 , 5 , 3 , '고유아이템 +1' );
insert into lineSynergyTable  
values ( 13 , 5 , 5 , '고유아이템 +2' );
insert into lineSynergyTable  
values ( 14 , 6 , 2 , '공격력과 주문력 +1' );
insert into lineSynergyTable  
values ( 15 , 6 , 4 , '공격력과 주문력 +3' );

-- desc tribeIdSynergyTable;

insert into tribeIdSynergyTable  
values ( 1 , 1 , 2 , '방어력 +35, 마법저항력 +35' );
insert into tribeIdSynergyTable  
values ( 2 , 1 , 3 , '방어력 +50, 마법저항력 +50' );
insert into tribeIdSynergyTable  
values ( 3 , 2 , 2 , '공격속도 +10%' );
insert into tribeIdSynergyTable  
values ( 4 , 2 , 3 , '공격속도 +15%' );
insert into tribeIdSynergyTable  
values ( 5 , 3 , 2 , '추가체력 +50%' );
insert into tribeIdSynergyTable  
values ( 6 , 3 , 4 , '추가체력 +125%' );
insert into tribeIdSynergyTable  
values ( 7 , 4 , 2 , '마법저항력 +40' );
insert into tribeIdSynergyTable  
values ( 8 , 4 , 3 , '마법저항력 +80' );
insert into tribeIdSynergyTable  
values ( 9 , 4 , 4 , '마법저항력 +150' );
insert into tribeIdSynergyTable  
values ( 10 , 5 , 1 , '높은챔피언 등장 확률 +1%' );
insert into tribeIdSynergyTable  
values ( 11 , 6 , 1 , '추가체력 +500' );
insert into tribeIdSynergyTable  
values ( 12 , 6 , 2 , '마법 저항력 및 방어력 +20' );
insert into tribeIdSynergyTable  
values ( 13 , 6 , 3 , '추가 피해 +10%' );
insert into tribeIdSynergyTable  
values ( 14 , 6 , 4 , '팀 정원 +1' );
insert into tribeIdSynergyTable  
values ( 15 , 7 , 3 , '주문력 +80%');
insert into tribeIdSynergyTable  
values ( 16 , 8 , 2 , '마나 +4' );
insert into tribeIdSynergyTable  
values ( 17 , 8 , 3 , '마나 +6' );
insert into tribeIdSynergyTable  
values ( 18 , 9 , 2 , '공격력 +150%' );
insert into tribeIdSynergyTable  
values ( 19 , 9 , 4 , '공격력 +275%' );
insert into tribeIdSynergyTable  
values ( 20 , 10 , 2 , '치명타 확률 +20% 및 치명타 피해량 +10%' );
insert into tribeIdSynergyTable  
values ( 21 , 10 , 4 , '치명타 확률 +50% 및 치명타 피해량 +25%' );
insert into tribeIdSynergyTable  
values ( 22 , 11 , 2 , '최대 체력의 비례 보호막 +25%' );
insert into tribeIdSynergyTable  
values ( 23 , 11 , 4 , '최대 체력의 비례 보호막 +40%' );
insert into tribeIdSynergyTable  
values ( 24 , 12 , 1 , '스킬 사용 후와 라운드 시작 시마다 새 스킬을 가져갑니다.' );
insert into tribeIdSynergyTable  
values ( 25 , 13 , 2 , '피해 +75%' );
insert into tribeIdSynergyTable  
values ( 26 , 13 , 4 , '피해 +150%' );
insert into tribeIdSynergyTable  
values ( 27 , 14 , 2 , '체력 +180' );
insert into tribeIdSynergyTable  
values ( 28 , 14 , 4 , '체력 +350' );

-- desc synergyTable;

insert into synergyTable   
values ( 1 , 1 , 3 , null, 1 );
insert into synergyTable   
values ( 2 , 2 , 7 , null,1 );
insert into synergyTable   
values ( 3 , 3 , 14 ,null, 1 );
insert into synergyTable   
values ( 4 , 4 , 7 ,null, 1 );
insert into synergyTable   
values ( 5 , 5 , 2 ,null, 1 );
insert into synergyTable   
values ( 6 , 6 , 6 , 8 , 1 );
insert into synergyTable   
values ( 7 , 7 , 7 , 1, 2 );
insert into synergyTable   
values ( 8 , 8 , 11 , null,2 );
insert into synergyTable   
values ( 9 , 9 , 10 ,null, 2 );
insert into synergyTable   
values ( 10 , 10 , 14 , 13,  2 );
insert into synergyTable   
values ( 11 , 11 , 1 , null,3 );
insert into synergyTable   
values ( 12 , 12 , 2 ,null, 3 );
insert into synergyTable   
values ( 13 , 13 , 3 ,null, 3 );
insert into synergyTable   
values ( 14 , 14 , 4 , 5, 3 );
insert into synergyTable   
values ( 15 , 15 , 6 ,null, 3 );
insert into synergyTable   
values ( 16 , 16 , 1 ,null, 4 );
insert into synergyTable   
values ( 17 , 17 , 9 ,null, 4 );
insert into synergyTable   
values ( 18 , 18 , 10 ,null, 4 );
insert into synergyTable   
values ( 19 , 19 , 6 ,null, 4 );
insert into synergyTable   
values ( 20 , 20 , 11 ,null, 5 );
insert into synergyTable   
values ( 21 , 21 , 14 ,null, 5 );
insert into synergyTable   
values ( 22 , 22 , 15 ,null, 5 );
insert into synergyTable   
values ( 23 , 23 , 7 , 12, 5 );
insert into synergyTable   
values ( 24 , 24 , 6 ,11, 5 );
insert into synergyTable   
values ( 25 , 25 , 8 ,null, 6 );
insert into synergyTable   
values ( 26 , 26 , 7 ,14, 6 );
insert into synergyTable   
values ( 27 , 27 , 13 , null,6 );
insert into synergyTable   
values ( 28 , 28 , 6 ,14, 6 );


<<<<<<< HEAD
=======
 
desc itemMaterialTable1;
  
-- desc itemMaterialTable;
  
>>>>>>> b396b56798ccc40d5ee3d4a150a8b51e23f83fe7

insert into itemMaterialTable1  
values ( 1 , '대검' , '공격력 +10' , 'C:\\LoLChessPJ\\Images\\BFSword.png' );
insert into itemMaterialTable1  
values ( 2 , '곡궁' , '공격속도 +10', 'C:\\LoLChessPJ\\Images\\RecurveBow.png' );
insert into itemMaterialTable1  
values ( 3 , '갑옷' , '방어력 +20' , 'C:\\LoLChessPJ\\Images\\ChainVest.png' );
insert into itemMaterialTable1 
values ( 4 , '여신의눈물' , '마나 +15' , 'C:\\LoLChessPJ\\Images\\Tearofthegoddess.png' );

insert into itemMaterialTable2  
values ( 1 , '대검' , '공격력 +10' , 'C:\\LoLChessPJ\\Images\\BFSword.png' );
insert into itemMaterialTable2  
values ( 2 , '곡궁' , '공격속도 +10', 'C:\\LoLChessPJ\\Images\\RecurveBow.png' );
insert into itemMaterialTable2  
values ( 3 , '갑옷' , '방어력 +20' , 'C:\\LoLChessPJ\\Images\\ChainVest.png' );
insert into itemMaterialTable2 
values ( 4 , '여신의눈물' , '마나 +15' , 'C:\\LoLChessPJ\\Images\\Tearofthegoddess.png' );

-- desc itemTable;
-- select * from itemTable;

insert into itemTable  
values ( 1 , '죽음의검' , '추가 공격력 25/45/65 획득' , 1 , 1 , 'C:\\LoLChessPJ\\Images\\LordsEdge.jpg' );
insert into itemTable  
values ( 2 , '거인학살자' , '기본 공격 및 스킬 사용시 20%의 추가 피해. 
대상 최대 체력이 1900 초과 시 추가 피해 45%로 증가' , 1 , 2 , 'C:\\LoLChessPJ\\Images\\GiantSlayer.jpg' );
insert into itemTable  
values ( 3 , '밤의끝자락' , '체력이 60%일 때 잠시 은신하며 대상으로 지정할 수 없는 상태가 되고 해로운 효과 제거. 
이후 추가 공격 속도 40% 획득.' , 1 , 3 , 'C:\\LoLChessPJ\\Images\\GuardianAngel.png' );
insert into itemTable  
values ( 4 , '쇼진의창' , '추가 주문력 20, 기본 공격 시 추가로 5의 마나 회복' , 1 , 4 , 'C:\\LoLChessPJ\\Images\\SpearofShojin.png' );
insert into itemTable  
values ( 5 , '고속연사포' , '추가 공격 속도 30% 및 공격 사거리 1칸 증가' , 2 , 2 , 'C:\\LoLChessPJ\\Images\\Rapid Firecannon.png' );
insert into itemTable  
values ( 6 , '거인의결의' , '공격하거나 피해를 받으면 공격력 및 주문력 2 획득 (최대 25회 중첩)' , 2 , 3 , 'C:\\LoLChessPJ\\Images\\TitansResolve.png' );
insert into itemTable  
values ( 7 , '스태틱의단검' , '추가 공격 속도 10%. 세 번째 공격마다 4명의 적에게 튕기는 
연쇄 번개를 발사하여 50의 마법 피해를 입히고 대상의 마법 저항력 5초 동안 50% 감소' , 2  , 4 , 'C:\\LoLChessPJ\\Images\\StatikkShiv.png' );
insert into itemTable  
values ( 8 , '덤불조끼' , '추가 방어력 40. 받는 치명타 공격의 추가 피해 75% 무효화. 기본 공격에 맞을 경우 
주변 모든 적에게 75/100/150 ★의 마법 피해 (2.5초마다 한 번씩)' , 3 , 3 , 'C:\\LoLChessPJ\\Images\\BrambleVest.png' );
insert into itemTable  
values ( 9 , '수호자의맹세' , '시작 마나 15 증가
전투 당 한번: 체력이 50%까지 떨어지면, 3칸 내 아군들이 2초 동안 최대 체력의 10%에 해당하는 보호막을 획득하며 
전투가 끝날 때까지 방어력 및 마법 저항력 15 획득' , 3 , 4 , 'C:\\LoLChessPJ\\Images\\Fimbulwinter.png' );
insert into itemTable  
values ( 10 , '푸른파수꾼' , '시작 마나 20 증가. 스킬 사용 후 마나를 20까지 회복' , 4 , 4 , 'C:\\LoLChessPJ\\Images\\BlueBuff.png' );