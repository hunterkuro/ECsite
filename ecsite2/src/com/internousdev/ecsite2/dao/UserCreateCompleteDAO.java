package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();

//DBのユーザー情報テーブルのid/pass/name/dateに?,?,?,?で指定した情報を格納するINSERT文
	String sql = "INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";

//UserCreateCompleteActionから渡されたId,Pass,Nameを引数として実行
	public void createUser(String loginUserId,String loginPassword,String userName)throws SQLException{

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ps.setString(3, userName);

//引数として渡されていないdateはインスタンスDateUtilからgetDateする。
			ps.setString(4, dateUtil.getDate());

//実行した値はpsに格納される。
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
//INSERTのみなので戻り値はなし。
	}
}
