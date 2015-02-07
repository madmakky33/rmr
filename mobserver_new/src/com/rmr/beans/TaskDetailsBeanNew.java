package com.rmr.beans;

import java.util.Date;

public class TaskDetailsBeanNew {
	private int taskId;
	private String taskName;
	private String username;
	private double definedLat;
	private double definedLang;
	private double actualLat;
	private double actualLang;
	private int targetAmount;
	private int collectedAmt;
	private String taskContact;
	private Date assignedDate;
	private Date closedDate;
	private String strngClosedDate;

	public String getStrngClosedDate() {
		return strngClosedDate;
	}

	public void setStrngClosedDate(String strngClosedDate) {
		this.strngClosedDate = strngClosedDate;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskContact() {
		return taskContact;
	}

	public void setTaskContact(String taskContact) {
		this.taskContact = taskContact;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getDefinedLat() {
		return definedLat;
	}

	public void setDefinedLat(double definedLat) {
		this.definedLat = definedLat;
	}

	public double getDefinedLang() {
		return definedLang;
	}

	public void setDefinedLang(double definedLang) {
		this.definedLang = definedLang;
	}

	public double getActualLat() {
		return actualLat;
	}

	public void setActualLat(double actualLat) {
		this.actualLat = actualLat;
	}

	public double getActualLang() {
		return actualLang;
	}

	public void setActualLang(double actualLang) {
		this.actualLang = actualLang;
	}

	public int getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}

	public int getCollectedAmt() {
		return collectedAmt;
	}

	public void setCollectedAmt(int collectedAmt) {
		this.collectedAmt = collectedAmt;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

}
