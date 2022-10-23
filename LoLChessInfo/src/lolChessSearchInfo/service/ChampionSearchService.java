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

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectLine);
			psmt.setString(1, price);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ResponseChampion rc = new ResponseChampion();
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
	
	
	public boolean insertChampion(ResponseChampion irc) {

		//트랜잭션 정상 쿼리가 등록 되었으면 true 반환, false 처리
		boolean flag = true;
		// 트랜잭션 사용하기
		// setAutoCommit 트랜잭션 처리 -- 기본값은 true이다 --> 바로 적용이 된다.
		try {
//			System.out.println("11111111" + dbHelper.getConnection());
			dbHelper.getConnection().setAutoCommit(true); //일부러 false
			// 1. 영화 테이블의 마지막 번호 들고오기.
			String query1 = " SELECT id FROM championtable ORDER BY id DESC LIMIT 1 ";
			rs = dbHelper.getConnection().prepareStatement(query1).executeQuery();
			while(rs.next()) {
				int lastId = Integer.parseInt(rs.getString("id")) + 1;
				irc.setId(query1);
				System.out.println("챔피언id; " + lastId);
			}
			
//			//배우 테이블에 마지막 번호 들고 오기
//			String query2 = " SELECT 번호 FROM 배우 ORDER BY 번호 DESC LIMIT 1 ";
//			rs = dbHelper.getConnection().prepareStatement(query2).executeQuery();
//			while(rs.next()) {
//				int lastId = Integer.parseInt(rs.getString("번호")) + 1;
//				irc.set배우번호(lastId);
//				System.out.println("배우번호:" + lastId);
//			}
			
			//영화 데이터 저장 (id, 이름, 개봉연도, 관객수, 평점)
			String query3 = " INSERT INTO championtable VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
			psmt = dbHelper.getConnection().prepareStatement(query3);
			psmt.setString(1, irc.getId());
			psmt.setString(2, irc.getName());
			psmt.setString(3, irc.getPrice());
			psmt.setString(4, irc.getHp());
			psmt.setString(5, irc.getPower());
			psmt.setString(6, irc.getDps());
			psmt.setString(7, irc.getAttackRange());
			psmt.setString(8, irc.getAttackSpeed());
			psmt.setString(9, irc.getDefense());
			psmt.setString(10, irc.getMagicResistance());
			psmt.setString(11, irc.getImageAddress());
			
			psmt.executeUpdate();
			
//			//배우 데이터 저장
//			String query4 = " INSERT INTO 배우( 번호, 이름, 출생, 키, 몸무게 ) VALUES ( ?, ?, ?, ?, ? ) ";
//			psmt = dbHelper.getConnection().prepareStatement(query4);
//			psmt.setInt(1, irc.get배우번호());
//			psmt.setString(2, irc.get배우이름());
//			psmt.setString(3, irc.get출생());
//			psmt.setInt(4, irc.get키());
//			psmt.setInt(5, irc.get몸무게());
//			psmt.executeUpdate();
			
//			//출연 데이터 저장
//			String query5 = " INSERT INTO 출연( 영화번호, 배우번호, 역할, 역 ) VALUES( ?, ?, ?, ? ) ";
//			psmt = dbHelper.getConnection().prepareStatement(query5);
//			psmt.setInt(1, irc.get영화번호());
//			psmt.setInt(2, irc.get배우번호());
//			psmt.setInt(3, irc.get역할());
//			psmt.setString(4, irc.get역());
//			psmt.executeUpdate();
			
			dbHelper.getConnection().commit();		 // 이걸 해야 실제 데이터 베이스에 반영//깃같은느낌 
			dbHelper.getConnection().setAutoCommit(true);  
//			System.out.println("11111111" + dbHelper.getConnection());
			
		} catch (SQLException e) {
			try {
				//롤백 (백업)
				dbHelper.getConnection().rollback();
				System.out.println("롤백했습니다!!");
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				//다시 원상 복구로 돌려 놓는 것을 권장
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
	

	public static void main(String[] args) {

		ChampionSearchService select = new ChampionSearchService();
		ResponseChampion rpc = new ResponseChampion();

		
		
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
		
		System.out.println("인설트11111");
		rpc.setId("29");
		rpc.setName("이승원");
		rpc.setPrice("1");
		rpc.setHp("12");
		rpc.setPower("13");
		rpc.setDps("1");
		rpc.setAttackRange("ㅇㅇㅇ");
		rpc.setAttackSpeed("0.1");
		rpc.setDefense("2");
		rpc.setMagicResistance("30");
		rpc.setImageAddress("이승원");
		
	}

}
