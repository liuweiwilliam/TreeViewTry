package com.xtl.dictree.utils;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class XtlLogger {
	public static Logger logger = Logger.getLogger(XtlLogger.class);
	private final static String clazzName = "com.xtl.dictree.utils.XtlLogger"; 
	
	/**
	 * 输出INFO级别的日志到日志表
	 * @param userid 用户ID，如果为系统日志，则使用“system”字符串
	 * @param msg 日志的内容
	 */
	public static void logInfo(String userid, String msg){
		JSONObject p_fun = getPreviousStackTraceFunction(clazzName, "logInfo");
		
		XtlLogger.log("info",
				userid, 
				null==p_fun.get("clazz")?"":p_fun.get("clazz").toString(),
				null==p_fun.get("method")?"":p_fun.get("method").toString(),
				null==p_fun.get("line")?"":p_fun.get("line").toString(),
				null==p_fun.get("fileName")?"":p_fun.get("fileName").toString(),
				msg);
	}
	
	/**
	 * 输出ERROR级别的日志到日志表
	 * @param userid 用户ID，如果为系统日志，则使用“system”字符串
	 * @param msg 日志的内容
	 */
	public static void logError(String userid, String msg){
		
		JSONObject p_fun = getPreviousStackTraceFunction(clazzName, "logError");
		
		XtlLogger.log("error",
				userid, 
				null==p_fun.get("clazz")?"":p_fun.get("clazz").toString(),
				null==p_fun.get("method")?"":p_fun.get("method").toString(),
				null==p_fun.get("line")?"":p_fun.get("line").toString(),
				null==p_fun.get("fileName")?"":p_fun.get("fileName").toString(),
				msg);
	}

	/**
	 * 输出DEBUG级别的日志到日志表
	 * @param userid 用户ID，如果为系统日志，则使用“system”字符串
	 * @param msg 日志的内容
	 */
	public static void logDebug(String userid, String msg){
		
		JSONObject p_fun = getPreviousStackTraceFunction(clazzName, "logDebug");
		
		XtlLogger.log("debug",
				userid, 
				null==p_fun.get("clazz")?"":p_fun.get("clazz").toString(),
				null==p_fun.get("method")?"":p_fun.get("method").toString(),
				null==p_fun.get("line")?"":p_fun.get("line").toString(),
				null==p_fun.get("fileName")?"":p_fun.get("fileName").toString(),
				msg);
	}
	
	/**
	 * 输出EARN级别的日志到日志表
	 * @param userid 用户ID，如果为系统日志，则使用“system”字符串
	 * @param msg 日志的内容
	 */
	public static void logWarn(String userid, String msg){
		
		JSONObject p_fun = getPreviousStackTraceFunction(clazzName, "logWarn");
		
		XtlLogger.log("warn",
				userid, 
				null==p_fun.get("clazz")?"":p_fun.get("clazz").toString(),
				null==p_fun.get("method")?"":p_fun.get("method").toString(),
				null==p_fun.get("line")?"":p_fun.get("line").toString(),
				null==p_fun.get("fileName")?"":p_fun.get("fileName").toString(),
				msg);
	}

	/**
	 * 输出FATAL级别的日志到日志表
	 * @param userid 用户ID，如果为系统日志，则使用“system”字符串
	 * @param msg 日志的内容
	 */
	public static void logFatal(String userid, String msg){
		
		JSONObject p_fun = getPreviousStackTraceFunction(clazzName, "logFatal");
		
		XtlLogger.log("fatal",
				userid, 
				null==p_fun.get("clazz")?"":p_fun.get("clazz").toString(),
				null==p_fun.get("method")?"":p_fun.get("method").toString(),
				null==p_fun.get("line")?"":p_fun.get("line").toString(),
				null==p_fun.get("fileName")?"":p_fun.get("fileName").toString(),
						msg);
	}

	private static void log(String level, String userid, String clazz, String method, String line, String fileName, String msg){
		MDC.put("userid", userid);
		MDC.put("clazz", clazz + "." + method + "(" + fileName + ":" + line + ")");
		
		switch(level){
		case "debug":
			logger.debug(msg);
			break;
		case "info":
			logger.info(msg);
			break;
		case "warn":
			logger.warn(msg);
			break;
		case "error":
			logger.error(msg);
			break;
		case "fatal":
			logger.fatal(msg);
			break;
		default:
			logger.info(msg);
			break;
		}
		
		MDC.clear();
	}
	
	private static JSONObject getPreviousStackTraceFunction(String clazz, String method) {
		// TODO Auto-generated method stub
		JSONObject rslt = new JSONObject();
		
		Throwable ex = new Throwable();

		StackTraceElement[] stackElements = ex.getStackTrace();

		boolean cur_flag = false;
		if(stackElements != null){
			for(int i = 0; i < stackElements.length; i++){
				if(cur_flag){
					rslt.put("clazz", stackElements[i].getClassName());
					rslt.put("method", stackElements[i].getMethodName());
					rslt.put("line", stackElements[i].getLineNumber());
					rslt.put("fileName", stackElements[i].getFileName());
					break;
				}
				
				if(stackElements[i].getClassName().equals(clazz)
						&& stackElements[i].getMethodName().equals(method)){
					cur_flag = true;
				}
			}
		}
		
		return rslt;
	}
}
