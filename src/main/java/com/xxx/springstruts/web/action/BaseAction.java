package com.xxx.springstruts.web.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
@ParentPackage("springstruts")
public class BaseAction {
	protected String path = "";
	public String ajax(Object object) {
		PrintWriter out = null;	
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=UTF-8");
			out = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(out, object);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out!=null) {
				out.close();
			}
		}
		return null;
	}
	
	
	public Map<String, Object> ok(){
		return getResultMap("success");
	}
	
	public Map<String, Object> getResultMap(int code,Object value){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", code);
		result.put("data", value);
		return result;
	}
	
	public Map<String, Object> getResultMap(Object value){
		return getResultMap(200, value);
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
