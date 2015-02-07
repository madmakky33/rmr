package com.rmr.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rmr.model.FOSDetails;
import com.rmr.model.Tasks;
import com.rmr.util.HibernateUtil;

public class UserDao extends HibernateUtil {
	public boolean addFOS(FOSDetails fos) {
		Transaction trans = null;
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			trans = session.beginTransaction();
			session.save(fos);
			trans.commit();
			return true;
		} catch (HibernateException e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public List<FOSDetails> list() {

		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		trans = session.beginTransaction();
		List<FOSDetails> fos = null;
		try {

			fos = (List<FOSDetails>) session.createQuery("from FOSDetails")
					.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return fos;
	}

	public boolean delete(String username) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		trans = session.beginTransaction();
		try {
			FOSDetails fo = (FOSDetails) session.load(FOSDetails.class,
					username);
			if (null != fo) {
				session.delete(fo);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {// need to make genericks
			e.printStackTrace();
			if (trans != null)
				trans.rollback();
			return false;
		}
		return true;
	}

	public List<String> getAllUsers() {
		String hql = "SELECT F.username FROM FOSDetails F";
		List<String> usernames = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
			usernames = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		session.getTransaction().rollback();
		return usernames;
	}

	public FOSDetails authenticateUsers(String username, String password) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		trans = session.beginTransaction();
		Object user = null;
		try {

			user = session.createQuery(
					"from FOSDetails where username='" + username
							+ "' and password='" + password + "'")
					.uniqueResult();
		} catch (HibernateException e) {// need to make genericks
			e.printStackTrace();
		}
		if (trans != null)
			trans.rollback();
		return (FOSDetails) user;
	}
}
