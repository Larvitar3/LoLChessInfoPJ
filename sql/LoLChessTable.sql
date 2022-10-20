-- CREATE DATABASE LoLChessInfo;

-- USE LoLChessInfo;

-- DROP DATABASE LoLChessInfo;

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
    imageRoute varchar(100),
    PRIMARY KEY (id)
);


CREATE TABLE tribeTable(
id INT AUTO_INCREMENT NOT NULL,
tribe VARCHAR (10) NOT NULL,
tribeSynergyEffect TEXT NOT NULL,
tribeSynergyCharacteristic TEXT,
PRIMARY KEY (id)
);

CREATE TABLE lineTable(
	id INT AUTO_INCREMENT NOT NULL,
    line VARCHAR (10) NOT NULL,
    lineSynergyEffect TEXT NOT NULL,
    lineSynergyCharacteristic TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE lineSynergyTable(
	id INT AUTO_INCREMENT NOT NULL,
    lineId INT NOT NULL,
    collaborationCount INT NOT NULL,
    collaborativeEffect TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (lineId) REFERENCES lineTable (id)
);


CREATE TABLE tribeIdSynergyTable(
	id INT AUTO_INCREMENT NOT NULL,
    tribeId INT NOT NULL,
    collaborationCount INT NOT NULL,
    collaborativeEffect TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tribeId) REFERENCES tribeTable (id)
);

CREATE TABLE synergyTable(
	id INT NOT NULL,
    championId INT NOT NULL,
    tribeId INT NOT NULL,
    lineId INT NOT NULL,
    FOREIGN KEY (championId) REFERENCES championTable (id),
    FOREIGN KEY (tribeId) REFERENCES tribeTable (id),
    FOREIGN KEY(lineId) REFERENCES lineTable(id)
);

CREATE TABLE itemMaterialTable(
	id INT AUTO_INCREMENT NOT NULL,
    name TEXT NOT NULL,
    materialEffect TEXT NOT NULL,
    imageRoute varchar(100),
    PRIMARY KEY (id)
);

CREATE TABLE itemTable(
	id INT AUTO_INCREMENT NOT NULL,
    name TEXT NOT NULL,
    itemEffect TEXT NOT NULL,
    materialId1 INT NOT NULL,
    materialId2 INT NOT NULL,
    imageRoute varchar(100),
    PRIMARY KEY (id),
    FOREIGN KEY (materialId1) REFERENCES itemMaterialTable (id),
    FOREIGN KEY (materialId2) REFERENCES itemMaterialTable (id)
);

