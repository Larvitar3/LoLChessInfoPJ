package lolChessSearchInfo.dto;

import lombok.Data;

@Data
public class ResponseItem {

	private String id;
	private String name;
	private String materialEffect;
	private String imageRoute;
	private String itemEffect;
	private String materialId1;
	private String materialId2;
	
	
	
	
	@Override
	public String toString() {
		return "ResponseItem [id=" + id + ", name=" + name + ", materialEffect=" + materialEffect + ", imageRoute="
				+ imageRoute + ", itemEffect=" + itemEffect + ", materialId1=" + materialId1 + ", materialId2="
				+ materialId2 + "]";
	}
	
	

}
