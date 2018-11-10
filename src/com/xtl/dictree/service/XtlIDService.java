package com.xtl.dictree.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xtl.dictree.cachemgr.XtlIDCacheMgr;
import com.xtl.dictree.pojo.XtlID;

public class XtlIDService{

	// Singleton functions ( construction is private)
	private static XtlIDService mSelf;	
	public static XtlIDService self(){
		if(null==mSelf) mSelf = new XtlIDService();
		
		return mSelf;
	}

	private XtlIDService (){
	}
	
	// save new object(if you want to change an exist object, please call other functions.)
	public void saveXtlID(Object obj) {
		XtlIDCacheMgr.self().saveXtlID(obj);
	}
        // delete new object(if you want to change an exist object, please call other functions.)
	public void delXtlID(String userid, Object obj) {
		XtlIDCacheMgr.self().delXtlID(obj);
	}
	// update new object(if you want to change an exist object, please call other functions.)
	public void updateXtlID(Object obj) {
		XtlIDCacheMgr.self().updateXtlID(obj);
	}
	
	public List<XtlID> getAllXtlID() {
		return XtlIDCacheMgr.self().getAllXtlID();
	}
	
	public XtlID getXtlIDById(String userid, Long id){
		return XtlIDCacheMgr.self().getXtlIDById(id);
	}






}



