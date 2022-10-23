package lolChessSearchInfo.dto;

import lombok.Data;

@Data
public class ResponseItem {

	private String id;
	private String name;
	private String materialEffect1;
	private String materialEffect2;
	private String imageAddress;
	private String itemEffect;
	private String materialName1;
	private String mtd1imgAddress;
	private String materialName2;
	private String mtd2imgAddress;
	
	
	
	@Override
	public String toString() {
		return "ResponseItem [id=" + id + ", name=" + name + ", materialEffect1=" + materialEffect1
				+ ", materialEffect2=" + materialEffect2 + ", imageAddress=" + imageAddress + ", itemEffect="
				+ itemEffect + ", materialName1=" + materialName1 + ", mtd1imgAddress=" + mtd1imgAddress
				+ ", materialName2=" + materialName2 + ", mtd2imgAddress=" + mtd2imgAddress + "]";
	}
	

}
