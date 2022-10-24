package lolChessSearchInfo.stepInterfaces;

import java.util.List;

import lolChessSearchInfo.dto.RequestChampion;
import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.hostFrame.HostInsertFrame;

public interface IChampionDtoS {

	List<ResponseChampion> selectChamIdAll();
	List<ResponseChampion> selectChamIdByName(String champName);
	void insertChamp(HostInsertFrame req);
	void updateChamp(String oldName, String newName);
	void daleteChamp(int champId);
	
}
