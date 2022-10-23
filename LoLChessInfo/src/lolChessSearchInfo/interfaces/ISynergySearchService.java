package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;

public interface ISynergySearchService {

	List<ResponseChampion>selectSynergyByLine(String synergyLine);

    List<ResponseChampion> selectISynergyByTribe(String synergyTribe);

    List<ResponseChampion> selectSynergyByEffect(String synergyEffect);
	
//	boolean insertSynergy(ResponseChampion rc);
//	void updateSynergy(String oldName, String newName);
//	void deleteSynergy(int synergyId);

}
