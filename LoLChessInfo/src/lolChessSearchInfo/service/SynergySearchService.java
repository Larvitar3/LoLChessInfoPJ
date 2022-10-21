package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.interfaces.ISynergySearchService;
import lolChessSearchInfo.utils.DBHelper;

public class SynergySearchService implements ISynergySearchService{

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public void selectSynergyByName(String synergyName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ResponseChampion> selectSynergyByEffect(String effectName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ResponseChampion> selectISynergyByMaterial(String materialName) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
