package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.interfaces.IChampionSearchService;
import lolChessSearchInfo.utils.DBHelper;

public class ChampionSearchService implements IChampionSearchService {

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;


	public ChampionSearchService() {
		this.dbHelper = DBHelper.getInstance();
	}

	@Override

	public List<ResponseChampion> selectChampionByName(String championName) {

		List<ResponseChampion> list = new ArrayList<>();

		String selectName = "select name as champName, price as price, hp as hp, "
				+ " power as power, dps as dps, attackRange as attackRange, " + " attackSpeed as attackSpeed,"
				+ " defense as defense, magicResistance as magicResistance, imageRoute as imageRoute"
				+ " from championtable" + " WHERE name = ? ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectName);
			psmt.setString(1, championName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseChampion rc = new ResponseChampion();
				rc.setName(rs.getString("champName"));
				rc.setPrice(rs.getString("price"));
				rc.setHp(rs.getString("hp"));
				rc.setPower(rs.getString("power"));
				rc.setDps(rs.getString("dps"));
				rc.setAttackRange(rs.getString("attackRange"));
				rc.setAttackSpeed(rs.getString("attackSpeed"));
				rc.setDefense(rs.getString("defense"));
				rc.setMagicResistance(rs.getString("magicResistance"));
				rc.setImageRoute(rs.getString("imageRoute"));

				list.add(rc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<ResponseChampion> selectChampionByLine(String lineName) {

		List<ResponseChampion> list = new ArrayList<>();

		String selectLine = " SELECT l.name AS lineName, c.imageRoute AS champImage, c.name AS champName "
				+ " FROM championtable AS c "
				+ " JOIN synergyTable AS s "
				+ " ON c.id = s.championId "
				+ " JOIN lineTable AS l "
				+ " ON s.lineId = l.id "
				+ " where l.name =  ? "
				+ " group by c.name " ;
			
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, lineName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseChampion rc = new ResponseChampion();
				rc.setLineName(rs.getString("lineName"));
				rc.setName(rs.getString("champName"));

				list.add(rc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ResponseChampion> selectChampionBytribe(String tribeName) {

		List<ResponseChampion> list = new ArrayList<>();

		String selectTribe = " SELECT t.name AS tribeName, c.imageRoute AS champImage, c.name AS champName "
				+ " FROM championtable AS c " + " JOIN synergyTable AS s " + " ON c.id = s.championId "
				+ " JOIN tribeTable AS t " + " ON s.tribeId = t.id " + " WHERE t.name = ? " + " GROUP BY c.name; ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectTribe);
			psmt.setString(1, tribeName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseChampion rc = new ResponseChampion();
//				SELECT l.name AS lineName, c.imageRoute AS champImage, c.name AS champName
				rc.setTribeName(rs.getString("tribeName"));
				rc.setName(rs.getString("champName"));
//				rc.setImageRoute(rs.getString("imageRoute"));

				list.add(rc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ResponseChampion> selectChampionByPrice(String price) {

		List<ResponseChampion> list = new ArrayList<>();

		String selectPrice = " SELECT name, price " + " FROM championtable " + " WHERE price = ? " + " ORDER BY name ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectPrice);
			psmt.setString(1, price);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseChampion rc = new ResponseChampion();
				int lastId = Integer.parseInt(rs.getString("price")) + 1;
				rc.setPrice(selectPrice);
				System.out.println("price:" + lastId);
				rc.setName(rs.getString("name"));
				rc.setPrice(rs.getString("price"));

				list.add(rc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public static void main(String[] args) {
		ChampionSearchService cp = new ChampionSearchService();
		
		List<ResponseChampion> list = cp.selectChampionByName("사일러스");
		for (ResponseChampion responseChampion1 : list) {
			System.out.println(responseChampion1);
		}
		
		System.out.println("---------");

		List<ResponseChampion> list2 = cp.selectChampionByLine("용사냥꾼");
		for (ResponseChampion responseChampion2 : list2) {
			System.out.println(responseChampion2);
		}

		System.out.println("---------");

		List<ResponseChampion> list3 = cp.selectChampionByPrice("3");
		for (ResponseChampion responseChampion3 : list3) {
			System.out.println(responseChampion3);

		}

	}

}
