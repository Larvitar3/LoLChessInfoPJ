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
	private String attackRange;
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
	
	@Override
	public String toString() {
		return "ResponseChampion [id=" + id + ", name=" + name + ", price=" + price + ", hp=" + hp + ", power=" + power
				+ ", dps=" + dps + ", attackRange=" + attackRange + ", attackSpeed=" + attackSpeed + ", defense="
				+ defense + ", magicResistance=" + magicResistance + ", imageRoute=" + imageRoute
				+ ", tribeSynergyEffect=" + tribeSynergyEffect + ", tribeSynergyCharacteristic="
				+ tribeSynergyCharacteristic + ", lineSynergyEffect=" + lineSynergyEffect
				+ ", lineSynergyCharacteristic=" + lineSynergyCharacteristic + ", lineId=" + lineId
				+ ", collaborationCount=" + collaborationCount + ", collaborativeEffect=" + collaborativeEffect
				+ ", tribeId=" + tribeId + ", championId=" + championId + "]";
	}
	
	
	
	
	
}
