package com.xtl.dictree.service;


import java.util.List;

import com.xtl.dictree.cachemgr.*;
import com.xtl.dictree.pojo.XtlFileInfo;
import com.xtl.dictree.pojo.XtlFileGroup;
import com.xtl.dictree.utils.XtlDateUtil;
import com.xtl.dictree.utils.XtlFileInfoUtil;

public class XtlFileInfoService{

	// Singleton functions ( construction is private)
	private static XtlFileInfoService mSelf;	
	public static XtlFileInfoService self(){
		if(null==mSelf) mSelf = new XtlFileInfoService();
		
		return mSelf;
	}

	private XtlFileInfoService (){
	}
	
	// save new object(if you want to change an exist object, please call other functions.)
	public void saveXtlFileInfo(Object obj) {
		XtlFileInfoCacheMgr.self().saveXtlFileInfo(obj);
	}
        // delete new object(if you want to change an exist object, please call other functions.)
	public void delXtlFileInfo(String userid, Object obj) {
		XtlFileInfoCacheMgr.self().delXtlFileInfo(obj);
	}
	// update new object(if you want to change an exist object, please call other functions.)
	public void updateXtlFileInfo(String userid, Object obj) {
		XtlFileInfoCacheMgr.self().updateXtlFileInfo(obj);
	}
	
	public List<XtlFileInfo> getAllXtlFileInfo(String userid) {
		return XtlFileInfoCacheMgr.self().getAllXtlFileInfo();
	}
	
	public XtlFileInfo getXtlFileInfoById(String id){
		return XtlFileInfoCacheMgr.self().getXtlFileInfoById(id);
	}

	// save new object(if you want to change an exist object, please call other functions.)
	public void saveXtlFileGroup(String userid, Object obj) {
		XtlFileInfoCacheMgr.self().saveXtlFileGroup(obj);
	}
        // delete new object(if you want to change an exist object, please call other functions.)
	public void delXtlFileGroup(String userid, Object obj) {
		XtlFileInfoCacheMgr.self().delXtlFileGroup(obj);
	}
	// update new object(if you want to change an exist object, please call other functions.)
	public void updateXtlFileGroup(String userid, Object obj) {
		XtlFileInfoCacheMgr.self().updateXtlFileGroup(obj);
	}
	
	public List<XtlFileGroup> getAllXtlFileGroup(String userid) {
		return XtlFileInfoCacheMgr.self().getAllXtlFileGroup();
	}
	
	public XtlFileGroup getXtlFileGroupById(String userid, Long id){
		return XtlFileInfoCacheMgr.self().getXtlFileGroupById(id);
	}

	public void addFileInfo(String fileId, String fname,
			String fpath, String url_path) {
		// TODO Auto-generated method stub
		XtlFileInfo info = new XtlFileInfo();
		info.setId(fileId);
		info.setUid("");
		info.setFname(fname);
		info.setSavepath(fpath);
		info.setUrlpath(url_path);
		info.setFtype(XtlFileInfoUtil.self().typeOf(fname));
		info.setCreate_time(XtlDateUtil.getNow("second"));
		saveXtlFileInfo(info);
	}

}



