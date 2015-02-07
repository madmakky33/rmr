package com.rmr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private int taskId;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "username")
	private String username;

	@Column(name = "defined_lat")
	private double definedLat;

	@Column(name = "defined_lang")
	private double definedLang;

	@Column(name = "actual_lat")
	private double actualLat;

	@Column(name = "actual_lang")
	private double actualLang;

	@Column(name = "target_amount")
	private int targetAmount;

	@Column(name = "collected_amt")
	private int collectedAmt;

	@Column(name = "task_contact")
	private String taskContact;

	@Column(name = "assigned_date")
	private Date assignedDate;

	@Column(name = "closed_date")
	private Date closedDate;

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
