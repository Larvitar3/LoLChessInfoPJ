package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.dto.ResponseLine;
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
		String selectName = "  SELECT * , T.name AS tName, ( " + " SELECT T.name" + " FROM championtable as C "
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
				rc.setImageAddress(rs.getString("imageRoute"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rc;
	}

	@Override
	public List<ResponseLine> selectChampionByLine(String lineName) {

		ArrayList<ResponseLine> resl = new ArrayList<>();

		String selectLine = "SELECT c.imageRoute AS champImage, c.name AS champName"
				+ " FROM championtable AS c "
				+ " JOIN synergyTable AS s "
				+ " ON c.id = s.championId "
				+ " JOIN tribeTable AS t "
				+ " ON s.tribeId1 = t.id "
				+ " WHERE t.name = ? "
				+ " group by c.name ";

		System.out.println(selectLine);
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, lineName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseLine res = new ResponseLine();
				res.setChampName(rs.getString("champName"));
				res.setChampImage(rs.getString("champImage"));
				resl.add(res);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resl;
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
