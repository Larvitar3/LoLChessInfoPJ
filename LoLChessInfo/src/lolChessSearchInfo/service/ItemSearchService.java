package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import lolChessSearchInfo.dto.ResponseItem;
import lolChessSearchInfo.interfaces.IItemSearchService;
import lolChessSearchInfo.utils.DBHelper;

public class ItemSearchService implements IItemSearchService{

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ItemSearchService() {
		this.dbHelper = DBHelper.getInstance();
	}
	
	@Override
	public void selectItemByName(String itemName) {
		
		ItemSearchService is = new ItemSearchService();
		String itemSelect = " SELECT I.imageRoute, I.name AS NAME, "
				+ " I.itemEffect AS IE, IMT1.name, IMT2.name "
				+ " FROM itemtable AS I "
				+ " JOIN itemmaterialtable1 AS IMT1 "
				+ " ON I.materialId1 = IMT1.id  "
				+ " JOIN itemmaterialtable2 AS IMT2 "
				+ " ON I.materialId2 = IMT2.id "
				+ " WHERE I.name LIKE '%?%'  ";
		
				try {
					psmt = dbHelper.getConnection().prepareStatement(itemSelect);
					psmt.setString(1, itemSelect);
					rs = psmt.executeQuery();
					
//					-- 아이템 By 이름
//					SELECT I.imageRoute, I.name AS NAME, I.itemEffect AS IE, IMT1.name, IMT2.name
//					FROM itemtable AS I
//					JOIN itemmaterialtable1 AS IMT1
//					ON I.materialId1 = IMT1.id
//					JOIN itemmaterialtable2 AS IMT2
//					ON I.materialId2 = IMT2.id
//					WHERE I.name LIKE '%쇼%';
//					private String id;
//					private String name;
//					private String materialEffect;
//					private String imageRoute;
//					private String itemEffect;
//					private String materialId1;
//					private String materialId2;
					while(rs.next()) {
						ResponseItem ri = new ResponseItem();
						ri.getName(getString());
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	@Override
	public List<ResponseItem> selectItemByEffect(String effectName) {
		return list;
	}
	@Override
	public List<ResponseItem> selectItemByMaterial(String materialName) {
		return list;
	}
	
	
	
}
