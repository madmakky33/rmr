package com.rmr.model;

import java.io.Serializable;
import java.util.List;

import com.rmr.beans.FOSDetailsBean;

public class Director implements Serializable {

	private String directorUsername;
	private String directorPwd;
	private List<FOSDetailsBean> fosList;

	public String getDirectorUsername() {
		return directorUsername;
	}

	public void setDirectorUsername(String directorUsername) {
		this.directorUsername = directorUsername;
	}

	public String getDirectorPwd() {
		return directorPwd;
	}

	public void setDirectorPwd(String directorPwd) {
		this.directorPwd = directorPwd;
	}

	public List<FOSDetailsBean> getFosList() {
		return fosList;
	}

	public void setFosList(List<FOSDetailsBean> fosList) {
		this.fosList = fosList;
	}

}
