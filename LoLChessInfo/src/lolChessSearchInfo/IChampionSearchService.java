package lolChessSearchInfo;

import java.util.List;

public interface IChampionSearchService {
	
	void selectChampionByName(String championName);
	void selectChampionByLine(String lineName);
	void selectChampionBytribe(String tribeName);
	List<Integer> selectChampionByPrice(int price);
	// champion end 
	
}
