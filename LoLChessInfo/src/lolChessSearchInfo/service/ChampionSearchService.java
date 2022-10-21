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
		
		ResponseChampion rc = new ResponseChampion();
		String selectName = "select name as champName, price as price, hp as hp, "
				+ " power as power, dps as dps, attackRange as attackRange, "
				+ " attackSpeed as attackSpeed,"
				+ " defense as defense, magicResistance as magicResistance, "
				+ " imageRoute as imageAddress"
				+ " from championtable"
				+ " WHERE name = ? ";
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectName);
			psmt.setString(1, championName);			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				rc.setName(rs.getString("champName"));
				rc.setPrice(rs.getString("price"));
				rc.setHp(rs.getString("hp"));
				rc.setPower(rs.getString("power"));
				rc.setDps(rs.getString("dps"));
				rc.setAttackRange(rs.getString("attackRange"));
				rc.setAttackSpeed(rs.getString("attackSpeed"));
				rc.setDefense(rs.getString("defense"));
				rc.setMagicResistance(rs.getString("magicResistance"));
				rc.setImageAddress(rs.getString("imageAddress"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rc;
		
		
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
	public List<Integer> selectChampionByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		ChampionSearchService cp =new ChampionSearchService();
		
		
		
	}

}
