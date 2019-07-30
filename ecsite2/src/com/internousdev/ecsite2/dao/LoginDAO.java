package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class LoginDAO {
//接続系クラスをインスタンス化
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

//Actionクラスから呼び出されているDAOのメインメソッド引数はユーザー入力のID/PASS
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

//DBのユーザー情報テーブルから指定のid/passに紐づくすべての情報を表示するSELECT文
		String sql = "SELECT * FROM login_user_transaction WHERE login_id= ? AND login_pass = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);

//DBに送るINSERT文のid/passを指定
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

//結果を出力してrsに格納
			ResultSet rs = ps.executeQuery();

//if文でINSERT結果(id,pass,name)のrsのデータをDTOに格納
			if(rs.next()){
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));

//login_idが空白でなければloginFlgをtrueに。
				if(rs.getString("login_id")!=null){
					loginDTO.setLoginFlg(true);
				}
			}

//例外時の表示処理
		}catch(SQLException e){
			e.printStackTrace();
		}

//loginDTOを戻り値として返す。
		return loginDTO;
	}
}
