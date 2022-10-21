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
<<<<<<< HEAD
	public void selectChampionByName(String championName) {
			
=======
	public List<ResponseChampion> selectChampionByName(String championName) {
		
		List<ResponseChampion> list = new ArrayList<>();
		
		String selectName = "select name as champName, price as price, hp as hp, "
				+ " power as power, dps as dps, attackRange as attackRange, "
				+ " attackSpeed as attackSpeed,"
				+ " defense as defense, magicResistance as magicResistance, imageRoute as imageRoute"
				+ " from championtable"
				+ " WHERE name = ? ";
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectName);
			psmt.setString(1, championName);			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ResponseChampion rc = new ResponseChampion();
				rc.setName(rs.getString("champName"));
				rc.setPrice(rs.getInt("price"));
				rc.setHp(rs.getInt("hp"));
				rc.setPower(rs.getInt("power"));
				rc.setDps(rs.getInt("dps"));
				rc.setAttackRange(rs.getString("attackRange"));
				rc.setAttackSpeed(rs.getDouble("attackSpeed"));
				rc.setDefense(rs.getInt("defense"));
				rc.setMagicResistance(rs.getInt("magicResistance"));
				rc.setImageRoute(rs.getString("imageRoute"));
				
				list.add(rc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		
>>>>>>> dev
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


	public static void main(String[] args) {
		ChamoionSearchService cp =new ChamoionSearchService();
		
		List<ResponseChampion> list = cp.selectChampionByName("니달리");
		System.out.println(list);

		
	}

}
