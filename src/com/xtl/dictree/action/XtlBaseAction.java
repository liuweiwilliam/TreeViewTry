package com.xtl.dictree.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xtl.dictree.utils.XtlLogger;

public class XtlBaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userid;
	public String customerid;

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected ServletContext application;
	
	@Override
	public void setServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application = application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
		Object obj = session.getAttribute("userid");
		Object obj2 = session.getAttribute("customerid");
		if(obj!=null){
			userid = obj.toString(); 
		}else{
			userid=null;
		}
		
		if(obj2!=null){
			customerid = obj2.toString(); 
		}else{
			customerid=null;
		}
	}
}
