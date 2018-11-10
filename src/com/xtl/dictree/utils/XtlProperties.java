package com.xtl.dictree.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class XtlProperties {
	private static String COPID = "";
	private static String QUERYCODEID = "";
	private static String QUERYCODESECRET = "";
	private static String SECRET = "";
	private static String AGENTID = "";
	private static String SET_SESSION_JSP = "";
	private static String DOMAIN_NAME = "";
	private static String NONCESTR = "";
	private static String ACCESS_TICKET_URL = "";
	private static String XTL_ID_URL = "";
	private static String APPID = "";
	private static String ACCESS_TICKET_URL2 = "";
	private static String SSOURL = "";
	private static String SSOURL_SPOKER = "";
	private static String SSOPAR = "";
	private static String RegistCallBackTag = "";
	private static String RegistCallBackToken = "";
	private static String AESKEY = "";
	private static String ProjectManDepartUser = "";
	private static String ProjectManDepartName = "";
	private static String SaleDepartName = "";
	private static String Dbfalg="";
	private static String LOCAL_PATH = "";
	private static String REMOTE_PATH = "";
	private static String RESTRICT_FILE_COUNT = "";
	private static String RESTRICT_FILE_SIZE = "";
	private static String RESTRICT_IP_COUNT = "";
	private static String RESTRICT_USER_COUNT = "";
	private static String FILE_UPLOAD_PATH = "";
	private static String ProjectName = "";
	private static String STORAGE_ADDR = "";
	private static String FTP_PORT = "";
	private static String FTP_USER = "";
	private static String FTP_PSW = "";
	private static String FTP_MAPPING_DIR = "";
	private static String REAL_TIME_BACKUP_RATIO = "";
	private static String REAL_TIME_BACKUP_STOP_RATIO = "";
	private static String DENY_RATIO = "";
	private static String SELF_IP_ADDR = "";
	private static String sign = "";
	
	public static String getDbfalg() {
		if(Dbfalg.equals("")){
			initDDProperties();
		}
		return Dbfalg;
	}


	public static String getCOPID() {
		if(COPID.equals("")){
			initDDProperties();
		}
		return COPID;
	}

	public static String getSECRET() {
		if(SECRET.equals("")){
			initDDProperties();
		}
		return SECRET;
	}
	
	public static String getAGENTID() {
		if(AGENTID.equals("")){
			initDDProperties();
		}
		return AGENTID;
	}
	
	public static String getDOMAIN_NAME() {
		if(DOMAIN_NAME.equals("")){
			initDDProperties();
		}
		return DOMAIN_NAME;
	}
	
	public static String getSET_SESSION_JSP() {
		if(SET_SESSION_JSP.equals("")){
			initDDProperties();
		}
		return SET_SESSION_JSP;
	}
	
	public static String getNONCESTR() {
		if(NONCESTR.equals("")){
			initDDProperties();
		}
		return NONCESTR;
	}
	
	public static String getACCESSTICKETURL() {
		if(ACCESS_TICKET_URL.equals("")){
			initDDProperties();
		}
		return ACCESS_TICKET_URL;
	}
	
	public static String getXTLIDURL() {
		if(XTL_ID_URL.equals("")){
			initDDProperties();
		}
		return XTL_ID_URL;
	}
	
	public static String getAPPID() {
		if(APPID.equals("")){
			initDDProperties();
		}
		return APPID;
	}
	
	public static String getSSOURL() {
		if(SSOURL.equals("")){
			initDDProperties();
		}
		return SSOURL;
	}
	
	public static String getSSOURL_SPOKER() {
		if(SSOURL_SPOKER.equals("")){
			initDDProperties();
		}
		return SSOURL_SPOKER;
	}
	
	public static String getSSOPAR() {
		if(SSOPAR.equals("")){
			initDDProperties();
		}
		return SSOPAR;
	}
	
	public static String getACCESSTICKETURL2() {
		if(ACCESS_TICKET_URL2.equals("")){
			initDDProperties();
		}
		return ACCESS_TICKET_URL2;
	}
	
	public static String getRegistCallBackTag() {
		if(RegistCallBackTag == ""){
			initDDProperties();
		}
		return RegistCallBackTag;
	}

	public static String getAESKEY() {
		if(AESKEY == ""){
			initDDProperties();
		}
		return AESKEY;
	}

	public static String getRegistCallBackToken() {
		if(RegistCallBackToken == ""){
			initDDProperties();
		}
		return RegistCallBackToken;
	}
	
	public static String getProjectManDepartUser() {
		if(ProjectManDepartUser == ""){
			initDDProperties();
		}
		return ProjectManDepartUser;
	}
	
	public static String getProjectManDepartName() {
		if(ProjectManDepartName == ""){
			initDDProperties();
		}
		return ProjectManDepartName;
	}
	
	public static String getSaleDepartName() {
		if(SaleDepartName == ""){
			initDDProperties();
		}
		return SaleDepartName;
	}
	
	public static String getLOCAL_PATH() {
		if (LOCAL_PATH == "") initDDProperties();
		return LOCAL_PATH;
	}
	
	public static String getREMOTE_PATH() {
		if (REMOTE_PATH == "") initDDProperties();
		return REMOTE_PATH;
	}
	
	public static int getRESTRICT_FILE_COUNT() {
		if (RESTRICT_FILE_COUNT == "") initDDProperties();
		return Integer.parseInt(RESTRICT_FILE_COUNT);
	}
	
	public static int getRESTRICT_FILE_SIZE() {
		if (RESTRICT_FILE_SIZE == "") initDDProperties();
		return Integer.parseInt(RESTRICT_FILE_SIZE);
	}
	
	public static int getRESTRICT_IP_COUNT() {
		if (RESTRICT_IP_COUNT == "") initDDProperties();
		return Integer.parseInt(RESTRICT_IP_COUNT);
	}
	
	public static int getRESTRICT_USER_COUNT() {
		if (RESTRICT_USER_COUNT == "") initDDProperties();
		return Integer.parseInt(RESTRICT_USER_COUNT);
	}
	
	public static String getFILE_UPLOAD_PATH(){
		if (FILE_UPLOAD_PATH == "") initDDProperties();
		return FILE_UPLOAD_PATH;
	}
	
	public static String getQUERYCODEID(){
		if (QUERYCODEID == "") initDDProperties();
		return QUERYCODEID;
	}
	
	public static String getProjectName(){
		if (ProjectName == "") initDDProperties();
		return ProjectName;
	}
	
	public static String getQUERYCODESECRET(){
		if (QUERYCODESECRET == "") initDDProperties();
		return QUERYCODESECRET;
	}
	
	public static String getSTORAGE_ADDR() {
		if (STORAGE_ADDR == "") initDDProperties();
		return STORAGE_ADDR;
	}
	
	public static String getFTP_PORT() {
		if (FTP_PORT == "") initDDProperties();
		return FTP_PORT;
	}
	
	public static String getFTP_USER() {
		if (FTP_USER == "") initDDProperties();
		return FTP_USER;
	}
	
	public static String getFTP_PSW() {
		if (FTP_PSW == "") initDDProperties();
		return FTP_PSW;
	}
	
	public static String getFTP_MAPPING_DIR() {
		if (FTP_MAPPING_DIR == "") initDDProperties();
		return FTP_MAPPING_DIR;
	}
	
	public static String getREAL_TIME_BACKUP_RATIO() {
		if (REAL_TIME_BACKUP_RATIO == "") initDDProperties();
		return REAL_TIME_BACKUP_RATIO;
	}
	
	public static String getREAL_TIME_BACKUP_STOP_RATIO() {
		if (REAL_TIME_BACKUP_STOP_RATIO == "") initDDProperties();
		return REAL_TIME_BACKUP_STOP_RATIO;
	}

	public static String getDENY_RATIO() {
		if (DENY_RATIO == "") initDDProperties();
		return DENY_RATIO;
	}
	
	public static String getSELF_IP_ADDR() {
		if (SELF_IP_ADDR == "") initDDProperties();
		return SELF_IP_ADDR;
	}

	public static String getSign() {
		if (sign == "") initDDProperties();
		return sign;
	}
	
	private static void initDDProperties() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		String path = Thread.currentThread().getContextClassLoader().getResource("dd.properties").getPath();
		try {
			properties.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		COPID = properties.getProperty("COPID");
		SECRET = properties.getProperty("SECRET");
		AGENTID = properties.getProperty("AGENTID");
		DOMAIN_NAME = properties.getProperty("DOMAIN_NAME");
		DOMAIN_NAME = properties.getProperty("DOMAIN_NAME");
		NONCESTR = properties.getProperty("NONCESTR");
		SET_SESSION_JSP = properties.getProperty("SET_SESSION_JSP");
		ACCESS_TICKET_URL = properties.getProperty("ACCESS_TICKET_URL");
		XTL_ID_URL = properties.getProperty("XTL_ID_URL");
		APPID = properties.getProperty("APPID");
		ACCESS_TICKET_URL2 = properties.getProperty("ACCESS_TICKET_URL2");
		SSOURL = properties.getProperty("SSOURL");
		SSOURL_SPOKER = properties.getProperty("SSOURL_SPOKER");
		SSOPAR = properties.getProperty("SSOPAR");
		RegistCallBackTag = properties.getProperty("RegistCallBackTag");
		RegistCallBackToken = properties.getProperty("RegistCallBackToken");
		AESKEY = properties.getProperty("AESKEY");
		ProjectManDepartUser = properties.getProperty("ProjectManDepartUser");
		ProjectManDepartName = properties.getProperty("ProjectManDepartName");
		SaleDepartName = properties.getProperty("SaleDepartName");
		Dbfalg=properties.getProperty("Dbflag");
		LOCAL_PATH = properties.getProperty("LOCAL_PATH");
		REMOTE_PATH = properties.getProperty("REMOTE_PATH");
		RESTRICT_FILE_COUNT = properties.getProperty("RESTRICT_FILE_COUNT");
		RESTRICT_FILE_SIZE = properties.getProperty("RESTRICT_FILE_SIZE");
		RESTRICT_IP_COUNT = properties.getProperty("RESTRICT_IP_COUNT");
		RESTRICT_USER_COUNT = properties.getProperty("RESTRICT_USER_COUNT");
		FILE_UPLOAD_PATH = properties.getProperty("FILE_UPLOAD_PATH");
		ProjectName = properties.getProperty("ProjectName");
		QUERYCODEID = properties.getProperty("QUERYCODEID");
		QUERYCODESECRET = properties.getProperty("QUERYCODESECRET");
		STORAGE_ADDR = properties.getProperty("STORAGE_ADDR");
		FTP_PORT = properties.getProperty("FTP_PORT");
		FTP_USER = properties.getProperty("FTP_USER");
		FTP_PSW = properties.getProperty("FTP_PSW");
		FTP_MAPPING_DIR = properties.getProperty("FTP_MAPPING_DIR");
		REAL_TIME_BACKUP_RATIO = properties.getProperty("REAL_TIME_BACKUP_RATIO");
		REAL_TIME_BACKUP_STOP_RATIO = properties.getProperty("REAL_TIME_BACKUP_STOP_RATIO");
		DENY_RATIO = properties.getProperty("DENY_RATIO");
		SELF_IP_ADDR = properties.getProperty("SELF_IP_ADDR");
		sign = properties.getProperty("sign");
	}
}
