package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import lolChessSearchInfo.interfaces.IChampionSearchService;
import lolChessSearchInfo.utils.DBHelper;

public class ChamoionSearchService implements IChampionSearchService{

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ChamoionSearchService() {
		this.dbHelper = DBHelper.getInstance();
	}

	@Override
	public void selectChampionByName(String championName) {
		
	}

	@Override
	public List<String> selectChampionByLine(String lineName) {
		
		return null;
	}

	@Override
	public List<String> selectChampionBytribe(String tribeName) {
		
		return null;
	}

	@Override
	public List<Integer> selectChampionByPrice(int price) {
		
		return null;
	}
	

}
