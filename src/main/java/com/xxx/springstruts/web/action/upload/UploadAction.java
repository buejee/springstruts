package com.xxx.springstruts.web.action.upload;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.xxx.springstruts.web.action.BaseAction;
public class UploadAction extends BaseAction{
	private static final Logger log = LogManager.getLogger(UploadAction.class);
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	public String save() {
		String path = ServletActionContext.getServletContext().getRealPath("/uploads");
		File dest = new File(path,uploadFileName);
		try {
			FileUtils.copyFile(upload, dest);
			log.info(uploadFileName+" upload successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajax(ok());
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	
}
