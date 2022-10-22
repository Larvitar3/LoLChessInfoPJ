package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lolChessSearchInfo.dto.ResponseItem;
import lolChessSearchInfo.interfaces.IItemSearchService;
import lolChessSearchInfo.utils.DBHelper;

public class ItemSearchService implements IItemSearchService {

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;

	public ItemSearchService() {
		this.dbHelper = DBHelper.getInstance();
	}

	@Override
	public ResponseItem selectItemByName(String itemName) {
		ResponseItem ri = new ResponseItem();
		String selectItemQuery = " SELECT I.imageRoute, I.name AS NAME, I.itemEffect AS IE, IMT1.name, IMT2.name "
				+ " FROM itemtable AS I " + " JOIN itemmaterialtable1 AS IMT1 " + " ON I.materialId1 = IMT1.id "
				+ " JOIN itemmaterialtable2 AS IMT2 " + " ON I.materialId2 = IMT2.id " + " WHERE I.name LIKE  ? ";
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectItemQuery);
			psmt.setString(1, "%" + itemName + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				ri.setImageRoute(rs.getString("imageRoute"));
				ri.setName(rs.getString("Name"));
				ri.setItemEffect(rs.getString("IE"));
				ri.setMaterialId1(rs.getString("name"));
				ri.setMaterialId2(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ri;
	}

	@Override
	public List<ResponseItem> selectItemByEffect(String effectName) {
		List<ResponseItem> list = new ArrayList<>();
		ResponseItem ri = new ResponseItem();
		String selectItemEffectQuery = " SELECT I.imageRoute, I.name AS NAME, I.itemEffect AS IE, IMT1.name, IMT2.name "
				+ " FROM itemtable AS I " + " JOIN itemmaterialtable1 AS IMT1 " + " ON I.materialId1 = IMT1.id "
				+ " JOIN itemmaterialtable2 AS IMT2 " + " ON I.materialId2 = IMT2.id " + " WHERE I.itemEffect LIKE ? ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectItemEffectQuery);
			psmt.setString(1, "%" + effectName + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				ri.setImageRoute(rs.getString("imageRoute"));
				ri.setName(rs.getString("Name"));
				ri.setItemEffect(rs.getString("IE"));
				ri.setMaterialId1(rs.getString("name"));
				ri.setMaterialId2(rs.getString("name"));

				list.add(ri);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ResponseItem> selectItemByMaterial(String materialName) {
		List<ResponseItem> list = new ArrayList<>();
		ResponseItem ri = new ResponseItem();
		String selectItemMaterialQuery = " SELECT IMT1.imageRoute, IMT1.name, IMT1.materialEffect, "
				+ " I.imageRoute, I.name, IMT2.name " + " FROM itemmaterialtable1 AS IMT1 " + " JOIN itemtable AS I "
				+ " ON IMT1.id = I.materialId1 " + " JOIN itemmaterialtable2 AS IMT2 " + " ON IMT2.id = I.materialId2 "
				+ " WHERE IMT1.name LIKE ? ";

		try {
			psmt = dbHelper.getConnection().prepareStatement(selectItemMaterialQuery);
			psmt.setString(1, "%" + materialName + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				ri.setImageRoute(rs.getString("imageRoute"));
				ri.setName(rs.getString("name"));
				ri.setMaterialEffect(rs.getString("materialEffect"));
				ri.setImageRoute(rs.getString("imageRoute"));
				ri.setMaterialId1(rs.getString("name"));
				ri.setMaterialId2(rs.getString("name"));
				list.add(ri);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		ItemSearchService iss = new ItemSearchService();
//		System.out.println(iss.selectItemByName("쇼"));
//		System.out.println("----");

		List<ResponseItem> list1;
//		list1 = iss.selectItemByEffect("추가");
//		for (ResponseItem responseItem : list1) {
//			System.out.println(responseItem);
//		}

		list1 = iss.selectItemByMaterial("대검");
	}

}
