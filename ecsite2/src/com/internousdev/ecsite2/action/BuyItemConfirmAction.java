package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


//buyItemComfirm.jspで購入完了すると移行する
public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

//importしたDAOのインスタンス化
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

/*throwsはメソッド内で例外が発生した場合、自信のメソッド内でcatchするのではなく、
 * 呼ばれる側に例外を投げる処理だ。例外処理はtry catch文を書くか、
 * throwsで呼び出し元に例外を投げるという二つの方法がある。 */
	public String execute() throws SQLException{

//buyItemCompleteDAOのbuyItemInfoメソッドを呼び出し。(DAOはINSERTのみなので戻り値無し。）
		buyItemCompleteDAO.buyItemInfo(

//送る引数はsessionからgetterで取得。toStringでString型に変換。
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString()
				);

//戻り値がないので商品購入のresultは無条件でSUCCESS
		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
//sessionのgetter無し・・・なぜ？
}
