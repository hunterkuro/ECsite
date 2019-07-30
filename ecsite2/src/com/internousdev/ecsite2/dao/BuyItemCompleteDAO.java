package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class BuyItemCompleteDAO {

/*BuyItemConfirmActionから呼び出される。
 * 引数は(item_id,total_price,count,user_id,pay)の５つ*/
	public void buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
/* DBの購入商品テーブルの(item_id/total_price/count/user_id,pay,date)に
 * ?,?,?,?,?,?で指定した情報を格納するINSERT文*/
		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";

// 6のdateはDateUtilインスタンスからgetDate()
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
//INSERT文だけなので戻り値無し。
}
