package lolChessSearchInfo.dto;

import lombok.Data;

@Data
public class ResponseChampion {

	private int id;
	private String name;
	private int price;
	private int hp;
	private int power;
	private int dps;
	private int attackRange;
	private double attackSpeed;
	private int defense;
	private int magicResistance;
	private String imageRoute;
	
	private String tribeSynergyEffect;
	private String tribeSynergyCharacteristic;
	
	private String lineSynergyEffect;
	private String lineSynergyCharacteristic;
	
	private int lineId;
	private int collaborationCount;
	private String collaborativeEffect;
	private int tribeId;
	private int championId;
	
}
