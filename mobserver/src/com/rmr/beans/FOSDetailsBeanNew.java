package com.rmr.beans;

import java.util.List;

public class FOSDetailsBeanNew {
	private String fosId;
	private List<TaskDetailsBeanNew> listTasks;

	public String getFosId() {
		return fosId;
	}

	public void setFosId(String fosId) {
		this.fosId = fosId;
	}

	public List<TaskDetailsBeanNew> getListTasks() {
		return listTasks;
	}

	public void setListTasks(List<TaskDetailsBeanNew> listTasks) {
		this.listTasks = listTasks;
	}

}
