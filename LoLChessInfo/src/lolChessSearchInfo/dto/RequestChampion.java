package lolChessSearchInfo.dto;

import lombok.Data;

@Data
public class RequestChampion {
	
	//챔피언
	
	private String id;
	private String name;
	private String price;
	private String hp;
	private String power;
	private String dps;
	private String attackRange;
	private String attackSpeed;
	private String defense;
	private String magicResistance;
	private String imageRoute;
	
	private String tribeName;
	private String tribeSynergyEffect;
	private String tribeSynergyCharacteristic;
	
	private String lineSynergyEffect;
	private String lineSynergyCharacteristic;
	
	private String lineId;
	private String collaborationCount;
	private String collaborativeEffect;
	private String tribeId;
	private String championId;
	

	
	
	
	
	
}
