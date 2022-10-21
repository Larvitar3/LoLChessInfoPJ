package lolChessSearchInfo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import lolChessSearchInfo.dto.ResponseItem;
import lolChessSearchInfo.interfaces.IItemSearchService;
import lolChessSearchInfo.utils.DBHelper;

public class ItemSearchService implements IItemSearchService{

	private DBHelper dbHelper;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public void selectItemByName(String itemName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ResponseItem> selectItemByEffect(String effectName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ResponseItem> selectItemByMaterial(String materialName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
