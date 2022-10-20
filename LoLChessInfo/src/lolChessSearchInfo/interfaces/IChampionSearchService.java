package lolChessSearchInfo.interfaces;

import java.util.List;

public interface IChampionSearchService {
	
	void selectChampionByName(String championName);
	List<String> selectChampionByLine(String lineName);
	List<String> selectChampionBytribe(String tribeName);
	List<Integer> selectChampionByPrice(int price);
	// champion end 
	
}
