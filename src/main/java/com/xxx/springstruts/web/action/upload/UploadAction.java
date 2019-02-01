package com.xxx.springstruts.web.action.upload;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.xxx.springstruts.web.action.BaseAction;
import com.xxx.springstruts.web.entity.DiskFile;
import com.xxx.springstruts.web.entity.DiskFile.FileType;
import com.xxx.springstruts.web.service.DiskFileService;
import com.xxx.springstruts.web.service.UserService;

public class UploadAction extends BaseAction{
	@Autowired
	private UserService userService;
	@Autowired
	private DiskFileService diskFileService;
	private static final Logger log = LogManager.getLogger(UploadAction.class);
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	public String save() {
		System.out.println(path);
		String path = ServletActionContext.getServletContext().getRealPath("/uploads");
		File dest = new File(path,uploadFileName);
		try {
			FileUtils.copyFile(upload, dest);
			//diskfile
			SecurityContext context = SecurityContextHolder.getContext();
			User user = (User)context.getAuthentication().getPrincipal();
			String username = user.getUsername();
			com.xxx.springstruts.web.entity.User currentUser = userService.findByUsername(username);
			DiskFile file = new DiskFile();
			file.setMimeType(uploadContentType);
			file.setPath(path);
			file.setName(uploadFileName);
			file.setType(FileType.file);
			file.setSize(upload.length());
			file.setUserId(currentUser.getId());
			diskFileService.save(file);
			log.info(uploadFileName+" upload successfully. stored at "+path);
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
