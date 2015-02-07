package com.rmr.action;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;
import com.opensymphony.xwork2.ActionSupport;

public class GCMAction extends ActionSupport {

	final private static String SERVER_KEY = "AIzaSyCpXm9PxlwxOrP2o156UlwT5JI3D2wi5P8";
	private String gcmMessage;
	private String gcmClientKey;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String sendMessage() {
		Sender sender = new Sender(SERVER_KEY);
		String clientKey = getGcmClientKey();
		Message message = new Message.Builder().timeToLive(80)
				.delayWhileIdle(true).addData("message", gcmMessage).build();
		try {
			//sender.sendNoRetry(arg0, arg1)
			sender.send(message, clientKey, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getGcmClientKey() {
		File f = new File("GcmReg.txt");
		if (f.exists()) {
			FileReader fr = null;
			try {
				fr = new FileReader(f);
				char all[] = new char[(int)f.length()];
				fr.read(all);
				gcmClientKey = new String(all);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fr != null) {
					try {
						fr.close();
						fr = null;
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
			}
		} else {
			gcmClientKey = "Client is not yet register";
		}
		return gcmClientKey;
	}

	public void setGcmClientKey(String gcmClientKey) {
		this.gcmClientKey = gcmClientKey;
	}

	public String getGcmMessage() {
		return gcmMessage;
	}

	public void setGcmMessage(String gcmMessage) {
		this.gcmMessage = gcmMessage;
	}

}
