package com.internousdev.ecsite2.action;

import com.opensymphony.xwork2.ActionSupport;
public class UserCreateAction extends ActionSupport{

//実行メソッド 無条件で戻り値SUCCESSを返す。→userCreate.jspへ
	public String execute(){
		return SUCCESS;
	}


}
