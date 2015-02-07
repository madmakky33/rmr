package com.rmr.webservices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.rmr.beans.AbstractBean;
import com.rmr.beans.FOSDetailsBean;
import com.rmr.beans.FOSDetailsBeanNew;
import com.rmr.dao.TaskDao;
import com.rmr.dao.UserDao;
import com.rmr.model.Director;
import com.rmr.model.FOSDetails;
import com.rmr.model.Tasks;

@Path("login_service")
public class CommonService {

	// Test method
	@POST
	@Path("newhello")
	@Produces({ "application/json" })
	@Consumes({ "application/json", "application/x-www-form-urlencoded" })
	public List<AbstractBean> hello() {
		List<AbstractBean> beans = new ArrayList<AbstractBean>();
		FOSDetailsBean bean = new FOSDetailsBean();
		bean.setFosId("1");
		bean.setFosName("test_fos");
		return beans;
	}

	@POST
	@Path("/post_authenticate")
	@Produces({ "application/json" })
	public FOSDetailsBean postAuthenticate(
			@FormParam("username") String username,
			@FormParam("password") String password) {
		UserDao dao = new UserDao();
		FOSDetailsBean fos = new FOSDetailsBean();
		FOSDetails foModel = dao.authenticateUsers(username, password);
		if (foModel != null) {
			String user = foModel.getUsername();
			TaskDao taskDao = new TaskDao();
			List<Tasks> beans = taskDao.getTask(username);
			fos.setFosId(user);
			fos.setFosNo(foModel.getContact());
			fos.setFosName(foModel.getFullName());
			fos.setTaskList(beans);
		}
		return fos;
	}

	@POST
	@Path("/post_driector_authenticate")
	@Produces({ "application/json" })
	public Director postDirectorAuthenticate(
			@FormParam("directorUsername") String directorUsername,
			@FormParam("directorPwd") String directorPwd) {
		// TODO Authenticate director credential from db
		// Since we are considering only one director for now

		Director director = new Director();
		List<FOSDetailsBean> fosListBean = new ArrayList<>();

		if ("eko".equals(directorUsername) && "eko".equals(directorPwd)) {
			UserDao userDao = new UserDao();
			TaskDao taskDao = new TaskDao();
			List<FOSDetails> fosModelList = userDao.list();
			FOSDetailsBean fosBean = null;
			for (FOSDetails fosModel : fosModelList) {
				String username = fosModel.getUsername();
				String fosName = fosModel.getFullName();
				List<Tasks> taskBeans = taskDao.getTask(username);
				fosBean = new FOSDetailsBean();
				fosBean.setFosId(username);
				fosBean.setFosName(fosName);
				fosBean.setFosNo(fosModel.getContact());
				fosBean.setTaskList(taskBeans);
				fosListBean.add(fosBean);
			}
		}
		director.setDirectorPwd(directorPwd);
		director.setDirectorUsername(directorUsername);
		director.setFosList(fosListBean);
		return director;
	}

	@POST
	@Path("/fos_details_updated_journey")
	@Consumes({ "application/json", "application/x-www-form-urlencoded" })
	public void postFOSDetailsUpdate(@FormParam("fos") String fos) {
		// Update users details
		Gson gson = new Gson();
		FOSDetailsBeanNew fosBean = gson.fromJson(fos, FOSDetailsBeanNew.class);
		TaskDao taskDao = new TaskDao();
		if (fosBean.getListTasks() != null) {
			taskDao.updateTasksBean(fosBean.getListTasks());
		}
	}

	@GET
	@Path("/get_authenticate")
	@Produces("application/json")
	public FOSDetails getAuthenticate(@QueryParam("username") String username,
			@QueryParam("password") String password) {
		UserDao dao = new UserDao();
		return dao.authenticateUsers(username, password);
	}

	@POST
	@Path("all_fos")
	@Produces({ "application/json" })
	@Consumes({ "application/json", "application/x-www-form-urlencoded" })
	public List<FOSDetails> getAllFos() {
		UserDao dao = new UserDao();
		return dao.list();
	}

	@POST
	@Path("get_fos_tasks")
	@Produces({ "application/json" })
	@Consumes({ "application/json", "application/x-www-form-urlencoded" })
	public List<Tasks> getTasks(@FormParam("username") String username) {
		TaskDao taskDao = new TaskDao();
		List<Tasks> beans = taskDao.getTask(username);
		return beans;
	}

	// for testing purpose;
	@GET
	@Path("get_fos_tasks_new")
	@Produces({ "application/json" })
	@Consumes({ "application/json", "application/x-www-form-urlencoded" })
	public List<Tasks> getTasks1(@QueryParam("username") String username) {
		TaskDao taskDao = new TaskDao();
		List<Tasks> beans = taskDao.getTask(username);
		return beans;
	}

	@POST
	@Path("get_gcm_key")
	@Consumes({ "application/json", "application/x-www-form-urlencoded" })
	public void getGCMKey(@FormParam("gcmReg") String gcmReg) {

		File gcmRegFile = new File("GcmReg.txt");
		BufferedWriter brw = null;
		try {
			if (!gcmRegFile.exists()) {
				gcmRegFile.createNewFile();
			}
			brw = new BufferedWriter(new FileWriter(gcmRegFile));
			brw.write(gcmReg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (brw != null) {
				try {
					brw.flush();
					brw.close();
					brw = null;
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	@GET
	@Path("get_get_gcm_key")
	@Consumes({ "application/json", "application/x-www-form-urlencoded" })
	public String getGetGCMKey(@QueryParam("gcmReg") String gcmReg) {

		File gcmRegFile = new File("GcmReg.txt");
		BufferedWriter brw = null;
		try {
			if (!gcmRegFile.exists()) {
				gcmRegFile.createNewFile();
			}
			brw = new BufferedWriter(new FileWriter(gcmRegFile));
			brw.write(gcmReg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (brw != null) {
				try {
					brw.flush();
					brw.close();
					brw = null;
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		return "success";
	}
}
