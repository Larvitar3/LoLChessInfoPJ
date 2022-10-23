package lolChessSearchInfo.interfaces;

import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;

public interface IChampionSearchService {
	
	ResponseChampion selectChampionByName(String championName);
	List<ResponseChampion> selectChampionByLine(String lineName);
	List<ResponseChampion> selectChampionBytribe(String tribeName);
	List<ResponseChampion> selectChampionByPrice(String price);
	
	boolean insertChampion(ResponseChampion rc);
	void updateChampion(String oldName, String newName);
	void deleteChampion(int championId);
	// champion end 
	
}
