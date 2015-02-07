package com.rmr.beans;

import java.util.List;

import com.rmr.model.Tasks;

public class FOSDetailsBean {
	private String fosName;
	private String fosId;
	private String fosNo;
	private List<Tasks> taskList;

	public String getFosName() {
		return fosName;
	}

	public void setFosName(String fosName) {
		this.fosName = fosName;
	}

	public String getFosId() {
		return fosId;
	}

	public void setFosId(String fosId) {
		this.fosId = fosId;
	}

	public String getFosNo() {
		return fosNo;
	}

	public void setFosNo(String fosNo) {
		this.fosNo = fosNo;
	}

	public List<Tasks> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Tasks> taskList) {
		this.taskList = taskList;
	}

}
