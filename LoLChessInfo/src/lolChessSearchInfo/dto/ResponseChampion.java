package lolChessSearchInfo.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class ResponseChampion {

	private int id;
	private String name;


	private String price;
	private String hp;
	private String power;
	private String dps;
	private String attackRange;
	private String attackSpeed;
	private String defense;
	private String magicResistance;

	private String imageAddress;
	
	private String tribeSynergyEffect;
	private String tribeSynergyCharacteristic;
	
	private String lineSynergyEffect;
	private String lineSynergyCharacteristic;
	
	private String lineId;

	private String collaborationCount;
	private String collaborativeEffect;
	private String tribeId;
	private String championId;
	
//	private String synergyName;
	private String lineName;
	private String tribeName;
	private String tribeName2;
	@Override
	public String toString() {
		return "ResponseChampion [id=" + id + ", name=" + name + ", price=" + price + ", hp=" + hp + ", power=" + power
				+ ", dps=" + dps + ", attackRange=" + attackRange + ", attackSpeed=" + attackSpeed + ", defense="
				+ defense + ", magicResistance=" + magicResistance + ", imageAddress=" + imageAddress
				+ ", tribeSynergyEffect=" + tribeSynergyEffect + ", tribeSynergyCharacteristic="
				+ tribeSynergyCharacteristic + ", lineSynergyEffect=" + lineSynergyEffect
				+ ", lineSynergyCharacteristic=" + lineSynergyCharacteristic + ", lineId=" + lineId
				+ ", collaborationCount=" + collaborationCount + ", collaborativeEffect=" + collaborativeEffect
				+ ", tribeId=" + tribeId + ", championId=" + championId + ", lineName=" + lineName + ", tribeName="
				+ tribeName + ", tribeName2=" + tribeName2 + "]";
	}

	
	

	
	
	
	
	
}
