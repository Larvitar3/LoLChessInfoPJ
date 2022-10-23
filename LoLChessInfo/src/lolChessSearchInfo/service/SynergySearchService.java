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

		List<ResponseChampion> list = new ArrayList<>();

		String selectLine = "SELECT C.name AS cName,L.name AS lName,"
				+ " L.lineSynergyEffect AS lse, L.lineSynergyCharacteristic AS lsc "
				+ " FROM linetable AS L "
				+ " JOIN synergytable AS S "
				+ " ON L.id = S.lineId "
				+ " JOIN championtable AS C "
				+ " ON S.championId =  C.id "
				+ " WHERE L.name = ? " ;
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, synergyLine);
			rs = psmt.executeQuery();

			while (rs.next()) {

				ResponseChampion rc = new ResponseChampion();
				
				rc.setName(rs.getString("cName"));
				rc.setLineName(rs.getString("lName"));
				rc.setLineSynergyEffect(rs.getString("lse"));
				rc.setLineSynergyCharacteristic(rs.getString("lsc"));

				list.add(rc);

			}

			System.out.println(selectLine);
			
		} catch (SQLException e) {

		} finally {
			try {
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (Exception e) {

			}
		}

		return list;
	}

	@Override
	public List<ResponseChampion> selectSynergyByTribe(String synergyTribel) {
		
		List<ResponseChampion> list = new ArrayList<>();
		
		String selectTribel = "SELECT C.name AS cName , "
				+ " T.name AS tName, T.tribeSynergyEffect, "
				+ " T.tribeSynergyCharacteristic "
				+ " FROM tribetable AS T  "
				+ " JOIN synergytable AS S  "
				+ " ON T.id = S.tribeId1  "
				+ " JOIN championtable AS C  "
				+ " ON S.championId =  C.id  "
				+ " WHERE T.name = ? ";
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectTribel);
			psmt.setString(1, synergyTribel);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ResponseChampion rc = new ResponseChampion();
				rc.setName(rs.getString("cName"));
				rc.setTribeName(rs.getString("tName"));
				rc.setTribeSynergyEffect(rs.getString("tribeSynergyEffect"));
				rc.setTribeSynergyCharacteristic(rs.getString("tribeSynergyCharacteristic"));
				
				list.add(rc);
			}
			System.out.println(selectTribel);
		} catch (SQLException e) {
			
		}finally {
			try {
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (Exception e) {

			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		SynergySearchService sss = new SynergySearchService();
		
		System.out.println("=== 라인 검색 ===");
		
		List<ResponseChampion> list = sss.selectSynergyByLine("별");
		for (ResponseChampion responseChampion : list) {
			System.out.println(responseChampion);
		}    
		
		System.out.println("=== 종족 검색 ===");
		List<ResponseChampion> list2 = sss.selectSynergyByTribe("용");
		for (ResponseChampion responseChampion : list2) {
			System.out.println(responseChampion);
		}
		
		
		
		
	}
	
	
}
