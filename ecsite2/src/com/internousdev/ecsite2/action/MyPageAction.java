	package com.internousdev.ecsite2.action;
	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

	public class MyPageAction extends ActionSupport implements SessionAware{

		public Map<String,Object> session;
		private MyPageDAO myPageDAO = new MyPageDAO();
		private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

//購入情報を削除するdeleteFlgと削除合否の確認messageをローカル変数に定義。
		private String deleteFlg;
		private String message;

//実行メソッド
		public String execute() throws SQLException{

//sessionのキー名 login_user_idが存在してなければ(削除されていたら)戻り値はERROR→home.jspに
			if(!session.containsKey("login_user_id")){
				return ERROR;
			}

//deleteFlgは、ユーザーが削除ボタンを押したとき null→1に変化する。
//deleteFlg=null：削除しない場合は item_idとuser_idを取得後、引数にしてDAOのgetMyPageUserInfoメソッドを呼び出す。
			if(deleteFlg == null){
				String item_transaction_id = session.get("id").toString();
				String user_master_id = session.get("login_user_id").toString();
				
//DAOを経由して、アイテムのid,name,price,count,pay,dateの6カラムのmyPageDTOが返ってくる。
				myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
				
//deleteFlg=1：削除する場合は、同クラスのdelete()メソッドを呼び出す。
			}else if(deleteFlg.equals("1")){
				delete();
			}
			
//処理を行った後、無条件で result は SUCCESS
			String result = SUCCESS;
			return result;
		}

//実行メソッドでデータ削除の場合実行されるメソッド
		public void delete() throws SQLException{
			
//item_idとuser_idを取得して変数に格納
			String item_transaction_id = session.get("id").toString();
			String user_master_id= session.get("login_user_id").toString();

//上記を引数にDAOのbuyItemHistoryDeleteを呼び出し、戻り値をresに格納
			int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);

//resにdeleteを行った際の更新件数の結果が入っている。0件でない場合。
			if(res>0){
				
/* アイテムのid,name,price,count,pay,dateの6カラムが入っている配列を空にする。
 *（DBで消えてるのでここで消さなければ削除した商品の情報も残る？）*/
				myPageList = null;
				setMessage("商品情報を正しく削除しました。");

//deleteを行った際の更新件数が0の場合。
			}else if(res == 0){
				setMessage("商品情報の削除に失敗しました。");
			}
		}

//myPage.jspでユーザー入力されている値をフィールドにset
		public void setDeleteFlg(String deleteFlg){
			this.deleteFlg = deleteFlg;
		}

		@Override
		public void setSession(Map<String,Object>session){
			this.session = session;
		}

//myPage.jspで
		public ArrayList<MyPageDTO> getMyPageList(){
			return this.myPageList;
		}

		public String getMessage(){
			return this.message;
		}

		public void setMessage(String message){
			this.message = message;
		}
	}
