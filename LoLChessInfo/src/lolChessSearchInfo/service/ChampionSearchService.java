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
		} finally {
			try {
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (Exception e) {

			}
		}

		return rc;
	}

	@Override

	public List<ResponseLine> selectChampionByLine(String lineName) {

		ArrayList<ResponseLine> resl = new ArrayList<>();

		String selectLine = "SELECT c.imageRoute AS champImage, "
				+ " c.name AS champName, L.name AS lineName "
				+ " FROM championtable AS c "
				+ " JOIN synergyTable AS s "
				+ " ON c.id = s.championId  "
				+ " JOIN linetable AS L"
				+ " ON s.lineId = L.id "
				+ " WHERE L.name = ? " ;

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
		} finally {
			try {
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (Exception e) {

			}
		}

		return resl;
	}

	@Override
	public List<ResponseChampion> selectChampionBytribe(String tribeName) {

		List<ResponseChampion> list = new ArrayList<>();

		String selectLine = "SELECT C.name AS championName, T.name AS tribeName, C.imageRoute"
				+ " FROM championtable as C " + " join synergytable AS S " + " ON c.id = s.championId "
				+ " JOIN linetable AS L " + " ON L.id = s.lineId " + " JOIN tribetable AS T " + " ON T.id = s.tribeId1 "
				+ " WHERE T.name = ? ";
		ResponseChampion rc = new ResponseChampion();
//		String selectLine = " SELECT t.name AS tribeName, c.imageRoute AS imageAddress, c.name AS name "
//				+ " FROM championtable AS c" + " JOIN synergyTable AS s " + " ON c.id = s.championId "
//				+ " JOIN tribeTable AS t " + "ON s.tribeId1 = t.id " + "WHERE t.name = ? " + " group by c.name ";  멀징

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, tribeName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseChampion rcp = new ResponseChampion();
				rcp.setTribeName(rs.getString("tribeName"));
				rcp.setImageAddress(rs.getString("imageRoute"));
				rcp.setName(rs.getString("championName"));

				list.add(rcp);
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
	public List<ResponseChampion> selectChampionByPrice(String price) {

		List<ResponseChampion> list = new ArrayList<>();

		String selectLine = " SELECT C .price, C .name , C.imageRoute " + " FROM championtable AS C "
				+ " join synergytable AS S " + " ON c.id = s.championId " + " JOIN linetable AS L "
				+ " ON L.id = s.lineId " + " JOIN tribetable AS T " + " ON T.id = s.tribeId1 " + " WHERE c.price = ? "
				+ " group by c.name ";
		ResponseChampion rc = new ResponseChampion();
//		String selectLine = " SELECT c.price, c.name " + " FROM championtable AS C " + " join synergytable AS S "
//				+ " ON c.id = s.championId " + " JOIN linetable AS L " + " ON L.id = s.lineId "
//				+ " JOIN tribetable AS T " + " ON T.id = s.tribeId1 " + " WHERE c.price = ? " + " group by c.name "; 멀징

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, price);
			rs = psmt.executeQuery();

			while (rs.next()) {
//				ResponseChampion rc = new ResponseChampion();
				rc.setName(rs.getString("name"));
				rc.setPrice(rs.getString("price"));
				rc.setImageAddress(rs.getString("imageRoute"));
				list.add(rc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public boolean insertChampion(ResponseChampion rc) {

		// 트랜잭션 정상 쿼리가 등록 되었으면 true 반환, false 처리
		boolean flag = true;
		// 트랜잭션 사용하기
		// setAutoCommit 트랜잭션 처리 -- 기본값은 true이다 --> 바로 적용이 된다.
		try {
			System.out.println("11111111");
			dbHelper.getConnection().setAutoCommit(false); // 일부러 false
			// 1. 테이블의 마지막 번호 들고오기.
			String query1 = " SELECT id FROM championtable ORDER BY id DESC LIMIT 1 ";
			rs = dbHelper.getConnection().prepareStatement(query1).executeQuery();
			while (rs.next()) {
				int lastId = Integer.parseInt(rs.getString("id")) + 1;
				rc.setId(lastId);
				System.out.println("챔피언id; " + lastId);
			}

			String query2 = " INSERT INTO championtable "
					+ " ( id, name, price, hp, power, dps, attackRange, attackSpeed, defense, magicResistance, imageRoute ) "
					+ " VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";

			psmt = dbHelper.getConnection().prepareStatement(query2);
			psmt.setInt(1, rc.getId());
			psmt.setString(2, rc.getName());
			psmt.setString(3, rc.getPrice());
			psmt.setString(4, rc.getHp());
			psmt.setString(5, rc.getPower());
			psmt.setString(6, rc.getDps());
			psmt.setString(7, rc.getAttackRange());
			psmt.setString(8, rc.getAttackSpeed());
			psmt.setString(9, rc.getDefense());
			psmt.setString(10, rc.getMagicResistance());
			psmt.setString(11, rc.getImageAddress());

			psmt.executeUpdate();

			dbHelper.getConnection().commit(); // 이걸 해야 실제 데이터 베이스에 반영//깃같은느낌
			dbHelper.getConnection().setAutoCommit(true);

		} catch (SQLException e) {
			try {
				// 롤백 (백업)
				dbHelper.getConnection().rollback();
				System.out.println("롤백했습니다!!");
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				// 다시 원상 복구로 돌려 놓는 것을 권장
//				dbHelper.getConnection().setAutoCommit(true); //<<<< 커밋밑으로 이사시킴 여기 있으면 불안정
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public void updateChampion(String oldName, String newName) {
		String query = " UPDATE championtable SET name = ? WHERE name = ?  ";
//		 " VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) "; 밸류로 해도 되고 안해도 되는듯??
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(query);
			psmt.setString(1, oldName);
			psmt.setString(2, newName);
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void deleteChampion(int championId) {
		
		try {
			dbHelper.getConnection().setAutoCommit(false);
			String query1 = " DELETE FROM championtable WHERE id = ? " ;
			psmt = dbHelper.getConnection().prepareStatement(query1);
			psmt.setInt(1, championId);
			psmt.executeUpdate();
			
			dbHelper.getConnection().commit();
			dbHelper.getConnection().setAutoCommit(true);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbHelper.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally{
				try {
					rs.close();
					psmt.close();
					dbHelper.connectionClose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	
	
	

	public static void main(String[] args) {

		ChampionSearchService css = new ChampionSearchService();
		ResponseChampion rc = new ResponseChampion();

//		System.out.println(css.selectChampionByName("릴리아"));
//
//		System.out.println("---------------");
//
//		List<ResponseChampion> list = css.selectChampionByLine("용사냥꾼");
//		for (ResponseChampion responseChampion : list) {
//			System.out.println(responseChampion);
//		}
//		
//		System.out.println("---");
//		
//		
//		List<ResponseChampion> tlist = css.selectChampionBytribe("민첩사수");
//		for (ResponseChampion responseChampion1 : tlist) {
//			System.out.println(responseChampion1);
//		}
//		
//		System.out.println("--------");
//		List<ResponseChampion> plist = css.selectChampionByPrice("8");
//		for (ResponseChampion responseChampion2 : plist) {
//			System.out.println(responseChampion2);
//		}

//		System.out.println("인설트시작");
//		rc.setId(29);
//		rc.setName("이승");
//		rc.setPrice("1");
//		rc.setHp("12");
//		rc.setPower("13");
//		rc.setDps("1");
//		rc.setAttackRange("ㅇㅇㅇ");
//		rc.setAttackSpeed("0.1");
//		rc.setDefense("2");
//		rc.setMagicResistance("30");
//		rc.setImageAddress("ㅇㅇ");
//		css.insertChampion(rc); //이거 있어야 실행됨
//		System.out.println("인설트끝");

		
		
//		System.out.println("update꼬");
//		css.updateChampion("승원", "이승원");
//		System.out.println("update끝");
		
//		css.deleteChampion(29);  //삭제
	}
}
