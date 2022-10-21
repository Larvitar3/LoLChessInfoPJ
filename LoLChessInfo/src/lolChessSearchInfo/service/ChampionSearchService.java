package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.interfaces.IChampionSearchService;
import lolChessSearchInfo.utils.DBHelper;


public class ChampionSearchService implements IChampionSearchService{


	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;

	public ChampionSearchService() {
		this.dbHelper = DBHelper.getInstance();
	}

	@Override
	public ResponseChampion selectChampionByName(String championName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseChampion> selectChampionByLine(String lineName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseChampion> selectChampionBytribe(String tribeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseChampion> selectChampionByPrice(String price) {
		// TODO Auto-generated method stub
		return null;
	}



	



}
