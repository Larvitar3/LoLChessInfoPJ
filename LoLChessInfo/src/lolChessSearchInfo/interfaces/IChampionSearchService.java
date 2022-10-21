package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;

public interface IChampionSearchService {
	
	List<ResponseChampion> selectChampionByName(String championName);
	List<ResponseChampion> selectChampionByLine(String lineName);
	List<ResponseChampion> selectChampionBytribe(String tribeName);
	List<ResponseChampion> selectChampionByPrice(String price);
	// champion end 
	
}
