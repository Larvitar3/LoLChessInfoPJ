package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.interfaces.IChampionSearchService;
import lolChessSearchInfo.utils.DBHelper;

public class ChamoionSearchService implements IChampionSearchService{

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	private String selectCname = "  SELECT name AS champName, price AS price, hp AS hp, power AS power, "
			+ " dps AS dps, attackRange AS attackRange, attackSpeed AS attackSpeed, "
			+ " defense AS defense, magicResistance AS magicResistance, imageRoute AS imageRoute "
			+ " FROM championtable " ;    // 챔피언 셀렉트
	
	
	public ChamoionSearchService() {
		this.dbHelper = DBHelper.getInstance();
	}
	
	

	@Override
	public void selectChampionByName(String championName) {
			
	}

	@Override
	public List<ResponseChampion> selectChampionByLine(String lineName) {
		
		List<ResponseChampion> list = new ArrayList<>();
		
		return list;
	}

	@Override
	public List<ResponseChampion> selectChampionBytribe(String tribeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectChampionByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
