package lolChessSearchInfo.stepDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lolChessSearchInfo.dto.RequestChampion;
import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.stepInterfaces.IChampionDtoS;
import lolChessSearchInfo.utils.DBHelper;

public class ChampionDao implements IChampionDtoS {
	
	private DBHelper dbHelper;
	private  PreparedStatement psmt;
	private ResultSet rs;
	
	public ChampionDao() {
		this.dbHelper = DBHelper.getInstance();
	}

	String idSelectQuery = " SELECT C.id, C.name"
			+ " FROM championtable AS C"
			+ " WHERE C.name = ? ";

	@Override
	public List<ResponseChampion> selectChamId(String champName) {
		List<ResponseChampion> list = new ArrayList<>();
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(idSelectQuery);
			psmt.setString(1, champName);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				ResponseChampion rc = new ResponseChampion();
				rc.setId(rs.getInt("id"));
				rc.setName(rs.getString("name"));
				
				list.add(rc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean insertChamp(RequestChampion requestChampion) {
		boolean flag = true;
		
		try {
			dbHelper.getConnection().setAutoCommit(false);
			
			// 1. 테이블 마지막 ID
			String lastIdQuery = "SELECT id FROM championtable ORDER BY id DESC LIMIT 1";
			rs = dbHelper.getConnection().prepareStatement(lastIdQuery).executeQuery();
			
			while(rs.next()) {
				int lastId = Integer.parseInt(rs.getString("id")) + 1;
				requestChampion.setId(lastId);
				System.out.println("챔피언 번호 : " + lastId);
			}
			
			String insertChamp =  "INSERT INTO championtable VALUES "
					+ "(? ,?, ?, ?, ?, ?, ?, ?, ?,?, ?)" ;
			
			psmt = dbHelper.getConnection().prepareStatement(insertChamp);
			psmt.setInt(1, requestChampion.getId());
			psmt.setString(2, requestChampion.getName());
			psmt.setString(3, requestChampion.getPrice());
			psmt.setString(4, requestChampion.getHp());
			psmt.setString(5, requestChampion.getPower());
			psmt.setString(6, requestChampion.getDps());
			psmt.setString(7, requestChampion.getAttackRange());
			psmt.setString(8, requestChampion.getAttackSpeed());
			psmt.setString(9, requestChampion.getDefense());
			psmt.setString(10, requestChampion.getMagicResistance());
			psmt.setString(11, requestChampion.getImageAddress());
			psmt.executeUpdate();
			
			dbHelper.getConnection().commit();
			dbHelper.getConnection().setAutoCommit(true);
			
			
		} catch (SQLException e) {
			try {
				dbHelper.getConnection().rollback();
				System.out.println("롤백이 실행 되었습니다.");
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
		
		
		
		return flag;
	}

	@Override
	public String updateChamp(String oldChamp, String newChamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int daleteChamp(int champId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		ChampionDao C = new ChampionDao();
		ResponseChampion R = new ResponseChampion();
		RequestChampion R2 = new RequestChampion();
		
		List<ResponseChampion> list = C.selectChamId("니달리");
		for (ResponseChampion responseChampion : list) {
			System.out.println(responseChampion);
		}
		
		R2.setName("리신");
		R2.setHp("800");
		R2.setAttackRange("★☆☆☆☆");
		R2.setAttackSpeed("0.75");
		
		C.insertChamp(R2);
		
	}
	
	
	
	
	
	
}
