package com.rmr.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rmr.dao.UserDao;
import com.rmr.model.FOSDetails;

public class FOSAction extends ActionSupport {
	private FOSDetails fos;
	private List<FOSDetails> fosList;
	private String username;

	private UserDao userDao = null;

	public FOSAction() {
		userDao = new UserDao();
	}

	@Override
	public String execute() throws Exception {
		this.fosList = userDao.list();
		userDao.getAllUsers();
		return SUCCESS;
	}

	public String add() {
		try {
			userDao.addFOS(getFos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String delete() {
		userDao.delete(getUsername());
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public FOSDetails getFos() {
		return fos;
	}

	public void setFos(FOSDetails fos) {
		this.fos = fos;
	}

	public List<FOSDetails> getFosList() {
		return fosList;
	}

	public void setFosList(List<FOSDetails> fosList) {
		this.fosList = fosList;
	}
}
