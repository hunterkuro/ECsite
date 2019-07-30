package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//private 変数として定義しているDTOはパッケージ名省略のためimport
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;


//メインメソッド
public class BuyItemDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

//Actionから呼び出されるメソッド
	public BuyItemDTO getBuyItemInfo(){

//DBの商品情報テーブルからid/name/priceの情報を表示するSELECT文
		String sql = "SELECT id,item_name,item_price FROM item_info_transaction";

//検索結果をrsに格納
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

//検索結果rsの情報をDTOに格納
			if(rs.next()){
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

//戻り値をDTOに返す。
		return buyItemDTO;

	}
}
