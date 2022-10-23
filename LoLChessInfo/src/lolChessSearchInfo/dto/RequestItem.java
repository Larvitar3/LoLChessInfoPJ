package lolChessSearchInfo.dto;

import lombok.Data;

@Data
public class RequestItem {

	private String id;
	private String name;
	private String materialEffect;
	private String imageAddress;
	private String itemEffect;
	private String materialIName1;
	private String mtd1imgAddress;
	private String materialName2;
	private String mtd2imgAddress;
	@Override
	public String toString() {
		return "RequestItem [id=" + id + ", name=" + name + ", materialEffect=" + materialEffect + ", imageAddress="
				+ imageAddress + ", itemEffect=" + itemEffect + ", materialIName1=" + materialIName1
				+ ", mtd1imgAddress=" + mtd1imgAddress + ", materialName2=" + materialName2 + ", mtd2imgAddress="
				+ mtd2imgAddress + "]";
	}
	
	
	
}
