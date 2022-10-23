package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;

public interface ISynergySearchService {

	List<ResponseChampion>selectSynergyByLine(String synergyLine);
	
	List<ResponseChampion> selectISynergyByTribel(String synergyTribel);

	List<ResponseChampion> selectSynergyByEffect(String synergyEffect);


}
