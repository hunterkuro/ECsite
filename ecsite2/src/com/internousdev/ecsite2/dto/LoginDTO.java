package com.internousdev.ecsite2.dto;

public class LoginDTO {

//DAOから送られる情報をフィールド変数として定義。ValueStackが下のsetterを使い、値をSET
	private String loginId;
	private String loginPassword;
	private String userName;
/*DAOでユーザー入力とSQL上のID/PASSが一致しているかどうかの結果。初期値falseで、DAOのif文で書き換えている。
 * 型は真偽値を表すboolean */
	private boolean loginFlg = false;

//getterはActionクラスでデータの呼び出しを行う際に使っている
	public String getLoginId(){
		return loginId;
	}
//setterはDAOで検索SQL結果データをDTOのフィールド変数を格納する為に呼び出されている
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}
}
