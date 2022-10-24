package lolChessSearchInfo.stepDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lolChessSearchInfo.dto.RequestChampion;
import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.hostFrame.HostInsertFrame;
import lolChessSearchInfo.stepInterfaces.IChampionDtoS;
import lolChessSearchInfo.utils.DBHelper;

public class ChampionDao implements IChampionDtoS {

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;

	public ChampionDao() {
		this.dbHelper = DBHelper.getInstance();
	}

	@Override
	public List<ResponseChampion> selectChamIdAll() {
		List<ResponseChampion> list = new ArrayList<>();

		String selectAllQuery = " SELECT C.id, C.name " + " FROM championtable AS C ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectAllQuery);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseChampion rc = new ResponseChampion();
				rc.setId(rs.getInt("id"));
				rc.setName(rs.getString("name"));

				list.add(rc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
	public List<ResponseChampion> selectChamIdByName(String champName) {
		List<ResponseChampion> list = new ArrayList<>();

		String idSelectQuery = " SELECT C.id, C.name" + " FROM championtable AS C" + " WHERE C.name = ? ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(idSelectQuery);
			psmt.setString(1, champName);
			rs = psmt.executeQuery();

			while (rs.next()) {

				ResponseChampion rc = new ResponseChampion();
				rc.setId(rs.getInt("id"));
				rc.setName(rs.getString("name"));

				list.add(rc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
	public void insertChamp(HostInsertFrame req) {

		try {
			dbHelper.getConnection().setAutoCommit(false);

			// 1. 테이블 마지막 ID
			String lastIdQuery = "SELECT id FROM championtable ORDER BY id DESC LIMIT 1";
			rs = dbHelper.getConnection().prepareStatement(lastIdQuery).executeQuery();
			int lastId = 0;
			if (rs.next()) {
				lastId = Integer.parseInt(rs.getString("id")) + 1;
			}
			System.out.println(lastId);
			String insertChamp = "INSERT INTO championtable VALUES " + "(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			psmt = dbHelper.getConnection().prepareStatement(insertChamp);
			psmt.setInt(1, lastId);
			psmt.setString(2, req.getInputName().getText());
			psmt.setString(3,  req.getInputPrice().getText());
			psmt.setString(4, req.getInputHp().getText());
			psmt.setString(5, req.getInputPower().getText());
			psmt.setString(6, req.getInputDps().getText());
			psmt.setString(7, req.getInputAttackRange().getText());
			psmt.setString(8, req.getInputAttackSpeed().getText());
			psmt.setString(9, req.getInputDefense().getText());
			psmt.setString(10, req.getInputMagicResistance().getText());
			psmt.setString(11, req.getInputImageAddress().getText());
			System.out.println(psmt.toString());
			psmt.executeUpdate();

			dbHelper.getConnection().commit();
			dbHelper.getConnection().setAutoCommit(true);

			System.out.println(lastIdQuery);
			System.out.println(insertChamp);
		} catch (SQLException e) {
			try {
				dbHelper.getConnection().rollback();
				System.out.println("롤백이 실행 되었습니다.");
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void updateChamp(String oldName, String newName) {

		String updateChampQuery = "UPDATE championtable " + " SET name = ? " + " WHERE name = ? ";
		try {
			psmt = dbHelper.getConnection().prepareStatement(updateChampQuery);
			psmt.setString(1, newName);
			psmt.setString(2, oldName);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void daleteChamp(int champId) {

		try {
			dbHelper.getConnection().setAutoCommit(false);

			String deleteSyneryQuery = "DELETE FROM synergytable WHERE championId = ? ";
			psmt = dbHelper.getConnection().prepareStatement(deleteSyneryQuery);
			psmt.setInt(1, champId);
			psmt.executeUpdate();

			String deleteChampQuery = "DELETE FROM championtable WHERE Id = ? ";
			psmt = dbHelper.getConnection().prepareStatement(deleteChampQuery);
			psmt.setInt(1, champId);
			psmt.executeUpdate();

			dbHelper.getConnection().commit();
			dbHelper.getConnection().setAutoCommit(true);

		} catch (SQLException e) {
			try {
				dbHelper.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}


}
