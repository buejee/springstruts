package com.xxx.springstruts.web.action.ad;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.springstruts.web.action.BaseAction;
import com.xxx.springstruts.web.entity.User;
import com.xxx.springstruts.web.service.UserService;
public class PlanAction extends BaseAction{
	private static final Logger log = LoggerFactory.getLogger(PlanAction.class);
	@Autowired
	private UserService userService;
	public String list() {
		User user = userService.findById(1);
		log.info("user : "+user.getUsername());
		return "list";
	}
	
	
	public String getList(){
		String path = ServletActionContext.getServletContext().getRealPath("/uploads");
		File dir = new File(path);
		String [] list = dir.list();
		return ajax(getResultMap(list));
	}
	
	public String upload() {
		return "upload";
	}
	
	private String fileName;
	public void setFileName(String fileName) {
		try {
			fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException();
		}
		this.fileName = fileName;
	}
	
	@Action(value="plan",results= {@Result(name="download",type="stream",params= {"contentType","application/octet-stream","inputName","attrInputStream","contentDisposition","attachment;filename='${downloadFileName}'","bufferSize","1024"})})
	public String download() {
		log.info("ready to download->"+fileName);
		return "download";
	}
	
	public InputStream getAttrInputStream() {
		return ServletActionContext.getServletContext().getResourceAsStream("/uploads/"+fileName);
	}
	
	public String getDownloadFileName() {
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException();
		}
		return fileName;
	}
}
