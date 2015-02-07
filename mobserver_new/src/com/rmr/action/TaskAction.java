package com.rmr.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rmr.dao.TaskDao;
import com.rmr.dao.UserDao;
import com.rmr.model.Tasks;

public class TaskAction extends ActionSupport {
	private Tasks task;
	private List<Tasks> taskList;
	private List<String> usernames;

	private String taskId;
	private String username;

	private TaskDao taskDao;
	private UserDao userDao;

	public TaskAction() {
		// TODO replace instantiation by @Autowired
		taskDao = new TaskDao();
		userDao = new UserDao();
	}

	@Override
	public String execute() throws Exception {
		this.taskList = taskDao.list();
		this.usernames = userDao.getAllUsers();
		return SUCCESS;
	}

	public String add() {
		try {
			taskDao.addTask(getTask());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String delete() {
		taskDao.deleteTask(new Integer(getTaskId()));
		return SUCCESS;
	}

	public List<String> getUsernames() {
		return usernames;
	}

	public void setUsernames(List<String> usernames) {
		this.usernames = usernames;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Tasks getTask() {
		return task;
	}

	public void setTask(Tasks task) {
		// task.setUsername(getUsername());
		task.setAssignedDate(new Date());
		this.task = task;
	}

	public List<Tasks> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Tasks> taskList) {
		this.taskList = taskList;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
}
