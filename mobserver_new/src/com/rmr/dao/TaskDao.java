package com.rmr.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rmr.beans.TaskDetailsBeanNew;
import com.rmr.model.Tasks;
import com.rmr.util.HibernateUtil;

public class TaskDao extends HibernateUtil {

	public boolean addTask(Tasks task) {
		Transaction trans = null;
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			trans = session.beginTransaction();
			session.save(task);
			trans.commit();
			return true;
		} catch (HibernateException e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public List<Tasks> list() {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		trans = session.beginTransaction();
		List<Tasks> taskList = null;
		try {
			taskList = (List<Tasks>) session.createQuery("from Tasks").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (trans != null)
				trans.rollback();
		}
		session.getTransaction().commit();
		return taskList;
	}

	public List<Tasks> getTask(String username) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		trans = session.beginTransaction();
		List<Tasks> taskList = null;
		try {
			taskList = (List<Tasks>) session.createQuery(
					"from Tasks where username='" + username + "'").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (trans != null)
				trans.rollback();
		}
		session.getTransaction().commit();
		return taskList;
	}

	public boolean deleteTask(int taskId) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		trans = session.beginTransaction();
		try {
			Tasks task = (Tasks) session.load(Tasks.class, taskId);
			if (null != task) {
				session.delete(task);
			}
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {// need to make genericks
			e.printStackTrace();
			if (trans != null)
				trans.rollback();
		}
		return false;
	}

	public boolean updateTaskList(HashMap<String, String> tasksList) {
		Set<String> keySet = tasksList.keySet();
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		for (String taskId : keySet) {
			trans = session.beginTransaction();
			Tasks task = (Tasks) session.load(Tasks.class, new Integer(taskId));
			task.setCollectedAmt(new Integer(tasksList.get(taskId)));
			session.update(task);
			trans.commit();
		}
		HibernateUtil.getSessionFactory().close();

		return false;
	}

	public boolean updateTasks(List<Tasks> taskList) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		for (Tasks task : taskList) {
			trans = session.beginTransaction();
			Tasks taskLoaded = (Tasks) session.load(Tasks.class,
					task.getTaskId());
			taskLoaded.setCollectedAmt(task.getCollectedAmt());
			taskLoaded.setClosedDate(task.getClosedDate());
			taskLoaded.setActualLang(task.getActualLang());
			taskLoaded.setActualLat(task.getActualLat());
			session.update(task);
			trans.commit();
		}
		return false;
	}

	public boolean updateTasksBean(List<TaskDetailsBeanNew> taskList) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		trans = session.beginTransaction();
		for (TaskDetailsBeanNew task : taskList) {

			Tasks taskLoaded = (Tasks) session.load(Tasks.class,
					task.getTaskId());
			taskLoaded.setCollectedAmt(task.getCollectedAmt());
			String closedDate = task.getStrngClosedDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			try {
				taskLoaded.setClosedDate(sdf.parse(closedDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			taskLoaded.setActualLang(task.getActualLang());
			taskLoaded.setActualLat(task.getActualLat());
			session.update(taskLoaded);
		}
		trans.commit();
		return false;
	}
}
