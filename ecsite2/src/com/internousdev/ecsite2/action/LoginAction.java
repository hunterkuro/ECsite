	package com.internousdev.ecsite2.action;
	import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/*下記importしないと、別パッケージで同じクラスがある可能性があるので、
 * private com.internousdev.ecsite2.dao.LoginDAO loginDAO = new com.internousdev.ecsite2.dao.LoginDAO();
 * と、パッケージ名から書かなければならない。*/
import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

	public class LoginAction extends ActionSupport implements SessionAware{
/* login.jspから【ユーザー入力のloginUserIdとloginPassword】を渡されている。
 * Struts2のValueStackがページ下部に記載のsetterを使って
 * 下記フィールド変数に渡している。*/
		private String loginUserId;
		private String loginPassword;

		public Map<String,Object> session;

//DB接続系クラスをインスタンス化しておく
		private LoginDAO loginDAO = new LoginDAO();
//DTOのインスタンス化は35行目のloginDTO = ・・・の型の定義として記述。後で出る方にLoginDTO loginDTO =と記述しても可。
		private LoginDTO loginDTO = new LoginDTO();
		private BuyItemDAO buyItemDAO= new BuyItemDAO();


//実行メソッド
		public String execute(){
//ログインの合否となるresultの初期値はERROR→このままだとlogin.jspに戻される
			String result = ERROR;

//【ユーザー入力のID/PASSをDAOのgetLoginUserInfoを通してsql検索】loginDTOに格納(ID/PASS/NAME/FLGが入っている)
			loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

//sessionにキー『loginUser』でloginDTO(ID/PASS/NAME/FLGが入っている)を格納
			session.put("loginUser", loginDTO);

/*sessionのloginUserの情報をLoginDTO型に戻して、DTOクラスのgetLoginFlgを実行
 * →ログインが通っていればFLGはtrueになっているのでif文が実行される。*/
			if(((LoginDTO) session.get("loginUser")).getLoginFlg()){

//ifが実行されたとき、戻り値resultはSUCCESS→buyItem.jspへ。
				result = SUCCESS;

//buyItemDTOはDAOの戻り値となるBuyItemDTO型の変数。ただの変数の箱なのでインスタンス化していない。
				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

//商品情報をsqlから取得してきて、それぞれにキー名をつけsessionに格納。
				session.put("login_user_id", loginDTO.getLoginId());
				session.put("id", buyItemDTO.getId());
				session.put("buyItem_name", buyItemDTO.getItemName());
				session.put("buyItem_price", buyItemDTO.getItemPrice());
//！！！！！！！！！！！！！！！特に2回書いている理由はない？？
				return result;
			}
			return result;
		}


//このクラスを親クラスとしたメソッドがLoginUserIdを参照したい時に使えるようにgetterを定義。
		public String getLoginUserId(){
			return loginUserId;
		}
//Struts2のValueStackがユーザー入力のIDをset。
		public void setLoginUserId(String loginUserId){
			this.loginUserId = loginUserId;
		}

		public String getLoginPassword(){
			return loginPassword;
		}
//Struts2のValueStackがユーザー入力のPASSをset。
		public void setLoginPassword(String loginPassword){
			this.loginPassword = loginPassword;
		}

/* オーバーライドする際は@Overrideを記載推奨。
 	メソッドに付与することでスペルミスや存在しないメソッドを
	オーバーライドしているという問題がエラーで明らかになる。*/
		@Override
		public void setSession(Map<String,Object> session){
		this.session = session;
		}
	}