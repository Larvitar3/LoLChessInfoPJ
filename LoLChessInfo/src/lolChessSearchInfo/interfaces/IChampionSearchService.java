package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.dto.ResponseLine;

public interface IChampionSearchService {
	
	ResponseChampion selectChampionByName(String championName);
	List<ResponseLine> selectChampionByLine(String lineName);
	List<ResponseChampion> selectChampionBytribe(String tribeName);
	List<ResponseChampion> selectChampionByPrice(String price);
	// champion end 
	
}
