package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseItem;

public interface IItemSearchService {

	void selectItemByName(String itemName);
	List<ResponseItem> selectItemByEffect(String effectName);
	List<ResponseItem> selectItemByMaterial(String materialName);
	
}
