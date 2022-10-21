package lolChessSearchInfo.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class ResponseChampion {

	private String id;
	private String name;
<<<<<<< HEAD
	private String lineName;
	private String tribeName;
=======
>>>>>>> b396b56798ccc40d5ee3d4a150a8b51e23f83fe7
	private String price;
	private String hp;
	private String power;
	private String dps;
	private String attackRange;
	private String attackSpeed;
	private String defense;
	private String magicResistance;
<<<<<<< HEAD
	private String imageAddress;
=======
	private String imageRoute;
>>>>>>> b396b56798ccc40d5ee3d4a150a8b51e23f83fe7
	
	private String tribeSynergyEffect;
	private String tribeSynergyCharacteristic;
	
	private String lineSynergyEffect;
	private String lineSynergyCharacteristic;
	
	private String lineId;
<<<<<<< HEAD
	private String collaborationCount;
	private String collaborativeEffect;
	private String tribeId;
	private String championId;
	
=======
	private String lineName;
	private String collaborationCount;
	private String collaborativeEffect;
	private String tribeId;
	private String tribeName;
	private String championId;
	
	

>>>>>>> b396b56798ccc40d5ee3d4a150a8b51e23f83fe7
	
	@Override
	public String toString() {
		return "ResponseChampion [id=" + id + ", name=" + name + ", price=" + price + ", hp=" + hp + ", power=" + power
				+ ", dps=" + dps + ", attackRange=" + attackRange + ", attackSpeed=" + attackSpeed + ", defense="
				+ defense + ", magicResistance=" + magicResistance + ", imageAddress=" + imageAddress
				+ ", tribeSynergyEffect=" + tribeSynergyEffect + ", tribeSynergyCharacteristic="
				+ tribeSynergyCharacteristic + ", lineSynergyEffect=" + lineSynergyEffect
				+ ", lineSynergyCharacteristic=" + lineSynergyCharacteristic + ", lineId=" + lineId
				+ ", collaborationCount=" + collaborationCount + ", collaborativeEffect=" + collaborativeEffect
				+ ", tribeId=" + tribeId + ", championId=" + championId + ", lineName=" + lineName + "tribeName=" + tribeName + "]";
	}
	
	
	
	
	
}
