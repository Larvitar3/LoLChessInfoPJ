package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.interfaces.ISynergySearchService;
import lolChessSearchInfo.utils.DBHelper;

public class SynergySearchService implements ISynergySearchService {

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;

	public SynergySearchService() {
		this.dbHelper = DBHelper.getInstance();
	}

	@Override
	public List<ResponseChampion> selectSynergyByLine(String synergyLine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseChampion> selectISynergyByTribel(String synergyTribel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponseChampion> selectSynergyByEffect(String synergyEffect) {
		// TODO Auto-generated method stub
		return null;
	}


		
	

}
