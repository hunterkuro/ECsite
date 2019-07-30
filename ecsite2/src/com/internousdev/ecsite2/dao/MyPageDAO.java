	package com.internousdev.ecsite2.dao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.MyPageDTO;
import com.internousdev.ecsite2.util.DBConnector;

//実行メソッド
	public class MyPageDAO {
		private DBConnector db = new DBConnector();
		private Connection con = db.getConnection();

/*DAOからArrayList<MyPageDTO>型 getMyPageUserInfoメソッド
 * MyPageActionから呼び出される 引数はsessionの(item_id,user_id)*/
		public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id)throws SQLException{

//ArrayListをMyPageDTO型でインスタンス化
	ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

/* DBのユーザー情報テーブルと購入商品テーブルを連結して?,?で指定した行の
 * user_id,item_name,total_price,count,pay,dateを取得するSELECT文*/
		String sql = "SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";

		try{

//	MyPageAction渡された 引数(item_id,user_id)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

//結果を rs に格納
			ResultSet rs = ps.executeQuery();

//rsのデータがある限り実行（購入者id "a" が商品id "1" を買った履歴が複数あればループ）
			while(rs.next()){
				MyPageDTO dto = new MyPageDTO();

//6つの取得カラムをDTOにsetしていく。
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));

//ArrayList(配列)にsetされたdtoの結果を追加する。
				myPageDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return myPageDTO;
		}

//データを削除する場合MyPageActionから呼び出される。引数は(item_id,user_id)
		public int buyItemHistoryDelete(String item_transaction_id,String user_master_id)throws SQLException{

//?,?(item_id,userid)で指定した商品購入履歴のデータを削除するdelete文。
			String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id= ? AND user_master_id =?";

			PreparedStatement ps;

//更新(削除)の件数を格納する変数を定義。初期値は0
			int result = 0;
			try{
				ps = con.prepareStatement(sql);
				ps.setString(1, item_transaction_id);
				ps.setString(2, user_master_id);

//delete文を実行した更新件数【executeUpdate()】をresultに格納
				result = ps.executeUpdate();

			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				con.close();
			}

//更新件数を戻り値として返す。
			return result;
		}
	}
