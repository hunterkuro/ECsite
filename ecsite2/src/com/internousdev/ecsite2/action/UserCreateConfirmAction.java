	package com.internousdev.ecsite2.action;
	import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
	public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

/* userCreate.jspからユーザー入力の新規ID,Pass,Nameが送られている。
 * オーバーライドしたsessionとerrorMessageを定義*/
		private String loginUserId;
		private String loginPassword;
		private String userName;
		public Map<String,Object> session;
		private String errorMessage;

//実行メソッド
		public String execute(){

//新規ユーザー作成の結果resultの初期値はSUCCESS→このままならuserCreateConfirm.jsp
			String result = SUCCESS;

//ユーザー入力の新規ID,Pass,Nameが空白でなければsessionに情報を格納。
			if(!(loginUserId.equals(""))&&!(loginPassword.equals(""))&&!(userName.equals(""))){
				session.put("loginUserId", loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("userName", userName);

/* ユーザー入力の新規ID,Pass,Nameが空白があればerrorMessageにエラー文を格納。
 * 新規ユーザー作成の結果resultをERROR→userCreate.jspに戻る。 */
			}else{
				setErrorMessage("未入力の項目があります。");
				result=ERROR;
			}

//戻り値resultを返す。
			return result;
		}

		public String getLoginUserId(){
			return loginUserId;
		}

		public void setLoginUserId(String loginUserId){
			this.loginUserId = loginUserId;
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

		@Override
		public void setSession(Map<String,Object> session){
		this.session = session;
		}

//userCreate.jspからエラー文を呼び出される。
		public String getErrorMessage(){
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage){
			this.errorMessage = errorMessage;
		}
	}