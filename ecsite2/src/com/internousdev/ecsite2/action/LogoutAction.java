package com.internousdev.ecsite2.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class LogoutAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

//sessionの中身をclearする。dbにはデータが残るがlogin_user_id =nullになる。
	public String execute(){
		session.clear();

//無条件でreturn SUCCESS → home.jspへ
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
}
