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
	public ResponseChampion selectChampionByName(String championName) {
		ResponseChampion rc = new ResponseChampion();
		String selectName = "  SELECT * , T.name As tName, ( " + " SELECT T.name" + " FROM championtable as C "
				+ " join synergytable AS S " + " ON c.id = s.championId " + " JOIN linetable AS L "
				+ " ON L.id = s.lineId " + " JOIN tribetable AS T " + " ON T.id = s.tribeId2 " + " WHERE c.name = ? "
				+ " group by c.name) AS T2 " + " FROM championtable as C " + " join synergytable AS S "
				+ " ON c.id = s.championId " + " JOIN linetable AS L " + " ON L.id = s.lineId "
				+ " JOIN tribetable AS T " + " ON T.id = s.tribeId1 " + " WHERE c.name = ? " + " group by c.name ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectName);
			psmt.setString(1, championName);
			psmt.setString(2, championName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				rc.setName(rs.getString("name"));
				rc.setPrice(rs.getString("price"));
				rc.setHp(rs.getString("hp"));
				rc.setPower(rs.getString("power"));
				rc.setDps(rs.getString("dps"));
				rc.setTribeName(rs.getString("tName"));
				rc.setTribeName2(rs.getString("T2"));
				rc.setAttackRange(rs.getString("attackRange"));
				rc.setAttackSpeed(rs.getString("attackSpeed"));
				rc.setDefense(rs.getString("defense"));
				rc.setMagicResistance(rs.getString("magicResistance"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rc;
	}

	@Override
	public List<ResponseChampion> selectChampionByLine(String lineName) {

		List<ResponseChampion> list = new ArrayList<>();
		ResponseChampion rc = new ResponseChampion();
		String selectLine = " SELECT l.name AS lineName," + " c.name AS name " + " FROM championtable AS c "
				+ " JOIN synergyTable AS s " + " ON c.id = s.championId " + " JOIN lineTable AS l "
				+ " ON s.lineId = l.id " + " where l.name = ? " + " group by c.name ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, lineName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				rc.setName(rs.getString("name"));
				rc.setLineName(rs.getString("lineName"));
				list.add(rc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ResponseChampion> selectChampionBytribe(String tribeName) {

		List<ResponseChampion> list = new ArrayList<>();
		ResponseChampion rc = new ResponseChampion();
		String selectLine = " SELECT t.name AS tribeName, c.imageRoute AS imageAddress, c.name AS name "
				+ " FROM championtable AS c" + " JOIN synergyTable AS s " + " ON c.id = s.championId "
				+ " JOIN tribeTable AS t " + "ON s.tribeId1 = t.id " + "WHERE t.name = ? "
				+ " group by c.name ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, tribeName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				rc.setLineName(rs.getString("tribeName"));
				list.add(rc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ResponseChampion> selectChampionByPrice(String price) {

		List<ResponseChampion> list = new ArrayList<>();
		ResponseChampion rc = new ResponseChampion();
		String selectLine = " SELECT c.price, c.name "
				+ " FROM championtable AS C "
				+ " join synergytable AS S "
				+ " ON c.id = s.championId "
				+ " JOIN linetable AS L "
				+ " ON L.id = s.lineId "
				+ " JOIN tribetable AS T "
				+ " ON T.id = s.tribeId1 "
				+ " WHERE c.price = ? "
				+ " group by c.name ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, price);
			rs = psmt.executeQuery();

			while (rs.next()) {
				rc.setName(rs.getString("name"));
				rc.setPrice(rs.getString("price"));
				list.add(rc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {

		ChampionSearchService cp = new ChampionSearchService();

		System.out.println(cp.selectChampionByName("릴리아"));

		System.out.println("---------------");

		List<ResponseChampion> list = cp.selectChampionByLine("용사냥꾼");
		for (ResponseChampion responseChampion : list) {
			System.out.println(responseChampion);
		}
		
		System.out.println("---");
		
		
		List<ResponseChampion> tlist = cp.selectChampionBytribe("민첩사수");
		for (ResponseChampion responseChampion1 : tlist) {
			System.out.println(responseChampion1);
		}
		
		System.out.println("--------");
		List<ResponseChampion> plist = cp.selectChampionByPrice("8");
		for (ResponseChampion responseChampion2 : plist) {
			System.out.println(responseChampion2);
		}

	}

}
