package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;

public interface ISynergySearchService {

	List<ResponseChampion>selectSynergyByLine(String synergyLine);

	List<ResponseChampion> selectSynergyByTribe(String synergyTribel);
}
