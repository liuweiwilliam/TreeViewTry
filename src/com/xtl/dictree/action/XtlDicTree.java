package com.xtl.dictree.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import com.xtl.dictree.cachemgr.XtlDictionaryTreeCacheMgr;
import com.xtl.dictree.factory.XtlFactory;
import com.xtl.dictree.utils.LzzBaseException;
import com.xtl.dictree.utils.XtlLogger;

import net.sf.json.JSONObject;

public class XtlDicTree extends XtlBaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getDicTree() {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setCharacterEncoding("utf-8");

		JSONObject rsl = new JSONObject();
		Transaction ts = XtlFactory.currentSession().beginTransaction();

		try {
			XtlLogger.logInfo("1234", "msg info");
			XtlLogger.logError("1234", "msg error");
			XtlLogger.logDebug("1234", "msg debug");
			XtlLogger.logFatal("1234", "msg fatal");
			XtlLogger.logWarn("1234", "msg warn");
			
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
			XtlDictionaryTreeCacheMgr.self().reloadCache();
			rsl.put("iserror", true);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			rsl.put("errormgr", sw.toString());
		} finally {
			XtlFactory.closeSession();
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.append(rsl.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public String getFiles() {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setCharacterEncoding("utf-8");

		JSONObject rsl = new JSONObject();
		Transaction ts = XtlFactory.currentSession().beginTransaction();

		try {

			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
			XtlDictionaryTreeCacheMgr.self().reloadCache();
			rsl.put("iserror", true);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			rsl.put("errormgr", sw.toString());
		} finally {
			XtlFactory.closeSession();
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.append(rsl.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public String addFiles() {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setCharacterEncoding("utf-8");

		JSONObject rsl = new JSONObject();
		Transaction ts = XtlFactory.currentSession().beginTransaction();

		try {

			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
			XtlDictionaryTreeCacheMgr.self().reloadCache();
			rsl.put("iserror", true);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			rsl.put("errormgr", sw.toString());
		} finally {
			XtlFactory.closeSession();
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.append(rsl.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public String removeFile() {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setCharacterEncoding("utf-8");

		JSONObject rsl = new JSONObject();
		Transaction ts = XtlFactory.currentSession().beginTransaction();

		try {

			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
			XtlDictionaryTreeCacheMgr.self().reloadCache();
			rsl.put("iserror", true);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			rsl.put("errormgr", sw.toString());
		} finally {
			XtlFactory.closeSession();
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.append(rsl.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public String addDicTree() {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setCharacterEncoding("utf-8");

		JSONObject rsl = new JSONObject();
		Transaction ts = XtlFactory.currentSession().beginTransaction();

		try {

			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ts.rollback();
			XtlDictionaryTreeCacheMgr.self().reloadCache();
			rsl.put("iserror", true);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			rsl.put("errormgr", sw.toString());
		} finally {
			XtlFactory.closeSession();
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.append(rsl.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
}
