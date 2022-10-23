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
		
		String selectName = "SELECT I.imageRoute, I.name AS NAME, I.itemEffect AS IE, "
				+ " IMT1.name AS IMT1Name, IMT2.name AS IMT2Name,"
				+ " IMT1.imageRoute AS IMT1img, IMT2.imageRoute AS IMT2img"
				+ " FROM itemtable AS I"
				+ " JOIN itemmaterialtable1 AS IMT1"
				+ " ON I.materialId1 = IMT1.id"
				+ " JOIN itemmaterialtable2 AS IMT2"
				+ " ON I.materialId2 = IMT2.id"
				+ " WHERE I.name LIKE ?";
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectName);
			psmt.setString(1, "%"+ itemName + "%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ri.setName(rs.getString("NAME"));
				ri.setImageAddress(rs.getString("imageRoute"));
				ri.setMaterialName1(rs.getString("IMT1Name"));
				ri.setMaterialName2(rs.getString("IMT2Name"));
				ri.setMtd1imgAddress(rs.getString("IMT1img"));
				ri.setMtd2imgAddress(rs.getString("IMT2img"));
				ri.setItemEffect(rs.getString("IE"));
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
		
		
		return ri;
	}

	@Override
	public List<ResponseItem> selectItemByEffect(String effectName) {
		
		List<ResponseItem> list = new ArrayList<>();
		
		String selectEffect = " SELECT I.imageRoute, I.name AS NAME, I.itemEffect AS IE, "
				+ " IMT1.name AS IMT1Name, IMT2.name AS IMT2Name,"
				+ " IMT1.imageRoute AS IMT1img, IMT2.imageRoute AS IMT2img"
				+ " FROM itemtable AS I"
				+ " JOIN itemmaterialtable1 AS IMT1"
				+ " ON I.materialId1 = IMT1.id"
				+ " JOIN itemmaterialtable2 AS IMT2"
				+ " ON I.materialId2 = IMT2.id"
				+ " WHERE I.itemEffect LIKE ? " ;
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectEffect);
			psmt.setString(1, "%"+ effectName + "%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ResponseItem ri = new ResponseItem();
				ri.setName(rs.getString("NAME"));
				ri.setImageAddress(rs.getString("imageRoute"));
				ri.setMaterialName1(rs.getString("IMT1Name"));
				ri.setMaterialName2(rs.getString("IMT2Name"));
				ri.setMtd1imgAddress(rs.getString("IMT1img"));
				ri.setMtd2imgAddress(rs.getString("IMT2img"));
				ri.setItemEffect(rs.getString("IE"));
				
				list.add(ri);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public List<ResponseItem> selectItemByMaterial(String materialName) {
		
		List<ResponseItem> list = new ArrayList<>();
		
		String selectMaterial = "SELECT IMT1.imageRoute AS IMT1Img, IMT1.name AS IMT1Name, "
				+ " IMT1.materialEffect AS IMT1Effect, "
				+ " I.imageRoute, I.name, "
				+ " IMT2.imageRoute AS IMT2Img, IMT2.name AS IMT2Name, IMT2.materialEffect AS IMT2Effect "
				+ " FROM itemmaterialtable1 AS IMT1"
				+ " JOIN itemtable AS I "
				+ " ON IMT1.id = I.materialId1 "
				+ " JOIN itemmaterialtable2 AS IMT2 "
				+ " ON IMT2.id = I.materialId2 "
				+ " WHERE IMT1.name LIKE ? ";
		
		try {
			psmt = dbHelper.getConnection().prepareStatement(selectMaterial);
			psmt.setString(1, "%"+ materialName+ "%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ResponseItem ri = new ResponseItem();
				
				ri.setName(rs.getString("name"));
				ri.setImageAddress(rs.getString("imageRoute"));
				ri.setMaterialName1(rs.getString("IMT1Name"));
				ri.setMaterialName2(rs.getString("IMT2Name"));
				ri.setMtd1imgAddress(rs.getString("IMT1img"));
				ri.setMtd2imgAddress(rs.getString("IMT2img"));
				ri.setMaterialEffect1(rs.getString("IMT1Effect"));
				ri.setMaterialEffect2(rs.getString("IMT2Effect"));
				
				list.add(ri);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				dbHelper.connectionClose();
			} catch (Exception e) {

			}
		}
		
		
		return list;
	}

	public static void main(String[] args) {
		ItemSearchService iss = new ItemSearchService();

		System.out.println("=== 이름 검색 ===");
		System.out.println(iss.selectItemByName("쇼"));

		System.out.println("=== 효과 검색 ===");
		List<ResponseItem> list = iss.selectItemByEffect("추가");
		for (ResponseItem responseItem : list) {
			System.out.println(responseItem);
		}

		System.out.println("=== 재료 검색 ===");
		List<ResponseItem> mlist = iss.selectItemByMaterial("대");
		for (ResponseItem responseItem : mlist) {
			System.out.println(responseItem);
		}

	}

}
