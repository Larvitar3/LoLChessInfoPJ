package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;

public interface IChampionSearchService {
	
	void selectChampionByName(String championName);
	List<ResponseChampion> selectChampionByLine(String lineName);
	List<ResponseChampion> selectChampionBytribe(String tribeName);
	List<Integer> selectChampionByPrice(int price);
	// champion end 
	
}
