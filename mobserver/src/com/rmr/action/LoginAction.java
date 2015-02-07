package com.rmr.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rmr.model.FOSDetails;

public class LoginAction extends ActionSupport {

	private String userName;
	private String password;

	private FOSDetails fosDetail;
	private List<FOSDetails> fosList;

	public LoginAction() {

	}

	public String signUp() {
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		if ("admin".equals(userName) && "eko".equals(password)){
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FOSDetails getFosDetail() {
		return fosDetail;
	}

	public void setFosDetail(FOSDetails fosDetail) {
		this.fosDetail = fosDetail;
	}

	public List<FOSDetails> getFosList() {
		return fosList;
	}

	public void setFosList(List<FOSDetails> fosList) {
		this.fosList = fosList;
	}

}
