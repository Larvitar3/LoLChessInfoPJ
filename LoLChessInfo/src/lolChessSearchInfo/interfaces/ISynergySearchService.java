package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;

public interface ISynergySearchService {

	void selectSynergyByName(String synergyName);
	List<ResponseChampion> selectSynergyByEffect(String effectName);
	List<ResponseChampion> selectISynergyByMaterial(String materialName);
	
}
