package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseItem;

public interface IItemSearchService {

	ResponseItem selectItemByName(String itemName);

	List<ResponseItem> selectItemByEffect(String effectName);

	List<ResponseItem> selectItemByMaterial(String materialName);

}
