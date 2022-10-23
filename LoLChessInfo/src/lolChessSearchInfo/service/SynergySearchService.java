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
		ResponseChampion rc = new ResponseChampion();

		String query = " SELECT C.name "
				+ " FROM linetable AS L "
				+ " JOIN synergytable AS S "
				+ " ON L.id = S.lineId "
				+ " JOIN championtable AS C "
				+ " ON S.championId =  C.id "
				+ " WHERE L.name = ? "
				+ " GROUP BY C.name ";
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(query);
			psmt.setString(1, synergyLine);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				rc.setName(rs.getString("name"));
				list.add(rc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ResponseChampion> selectISynergyByTribe(String synergyTribe) {
		List<ResponseChampion> list = new ArrayList<>();
		ResponseChampion rc = new ResponseChampion();
		
		String query = " SELECT C.name "
				+ " FROM tribetable AS T "
				+ " JOIN synergytable AS S "
				+ " ON T.id = S.lineId "
				+ " JOIN championtable AS C "
				+ " ON S.championId =  C.id "
				+ " WHERE T.name = ? "
				+ " GROUP BY C.name "; 
		
				try {
					psmt = dbHelper.getConnection().prepareStatement(query);
					psmt.setString(1, synergyTribe);
					rs = psmt.executeQuery();
					
					while(rs.next()) {
						rc.setName(rs.getString("name"));
						list.add(rc);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return list;
	}

	@Override
	public List<ResponseChampion> selectSynergyByEffect(String effectName) {
		List<ResponseChampion> list = new ArrayList<>();
		ResponseChampion rc = new ResponseChampion();

		String query = 
				" SELECT C.name, T.name "
				+ " FROM tribetable AS T "
				+ " JOIN synergytable AS S "
				+ " ON T.id = S.lineId "
				+ " JOIN championtable AS C "
				+ " ON S.championId =  C.id "
				+ " WHERE T.tribeSynergyEffect LIKE ? "
				+ " OR T.tribeSynergyCharacteristic LIKE ? ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(query);
			psmt.setString(1, "%" + effectName + "%");
			psmt.setString(2, "%" + effectName + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				rc.setName(rs.getString("name"));
				rc.setTribeName(rs.getString("name"));
				list.add(rc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	

	public static void main(String[] args) {
		SynergySearchService sss = new SynergySearchService();
		
		
//		System.out.println(sss.selectSynergyByLine("별"));
		
		
//		System.out.println(sss.selectSynergyByEffect("민첩사수"));
		
		System.out.println(sss.selectSynergyByEffect("마"));
	}

}
