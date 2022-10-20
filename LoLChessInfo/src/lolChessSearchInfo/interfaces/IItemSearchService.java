package lolChessSearchInfo.interfaces;

import java.util.List;

public interface IItemSearchService {

	void selectItemByName(String itemName);
	List<String> selectItemByEffect(String effectName);
	List<String> selectItemByMaterial(String materialName);
	
}
