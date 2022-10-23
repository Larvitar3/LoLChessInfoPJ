package lolChessSearchInfo.stepInterfaces;

import java.util.List;

import lolChessSearchInfo.dto.RequestChampion;
import lolChessSearchInfo.dto.ResponseChampion;

public interface IChampionDtoS {

	List<ResponseChampion> selectChamId(String champName);
	boolean insertChamp(RequestChampion req);
	String updateChamp(String oldChamp, String newChamp);
	int daleteChamp(int champId);
	
}
