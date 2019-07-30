	package com.internousdev.ecsite2.action;

	import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

	public class BuyItemAction extends ActionSupport implements SessionAware{

//buyItem.jspからcountとpayがformで送られている。
		public Map<String,Object> session;
		private int count;
		private String pay;

//実行メソッド
		public String execute(){

//商品購入の結果を返すresultの初期値はSUCCESS（変更されない
			String result = SUCCESS;

//sessionに購入個数countを定義
			session.put("count", count);

/* 合計金額(購入個数＊値段)を計算するためsessionのcountとpriceをint型に変換
 * .toString()でsessionのMAP型をString型に変換。
 * Integer.parseInt(String型の変数)でString型をint型へ変換。 */
			int intCount = Integer.parseInt(session.get("count").toString());
			int intPrice = Integer.parseInt(session.get("buyItem_price").toString());

//count*priceをsessionのtotal_priceに格納。
			session.put("total_price",intCount * intPrice);

/*ローカル変数paymentを定義してbuyItem.jspから送られた
 *payのvalueに応じてpaymentに支払方法を格納 */
			String payment;
			if(pay.equals("1")){
				payment = "現金払い";
				session.put("pay",payment);
			}else{
				payment = "クレジットカード";
				session.put("pay",payment);
			}

//result = SUCCESSのまま返す。→buyItemConfirm.jspへ
			return result;
		}

		public void setCount(int count){
			this.count = count;
		}

		public void setPay(String pay){
			this.pay = pay;
		}

		@Override
		public void setSession(Map<String,Object> session){
			this.session = session;
		}
	}
