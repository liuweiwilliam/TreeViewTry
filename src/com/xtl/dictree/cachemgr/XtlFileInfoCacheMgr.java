package com.xtl.dictree.cachemgr;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.hibernate.Session;

import com.xtl.dictree.dao.XtlDao;
import com.xtl.dictree.factory.XtlFactory;
import com.xtl.dictree.pojo.XtlFileGroup;
import com.xtl.dictree.pojo.XtlFileInfo;

public class XtlFileInfoCacheMgr{
  private Session session;
	private XtlDao dao;
	private Vector<XtlFileInfo> mXtlFileInfos;
	private boolean mXtlFileInfosLoaded;
	private Hashtable<String, XtlFileInfo> mXtlFileInfoHash;

	private Vector<XtlFileGroup> mXtlFileGroups;
	private boolean mXtlFileGroupsLoaded;
	private Hashtable<String, XtlFileGroup> mXtlFileGroupHash;


	// Singleton functions ( construction is private)
	private final static XtlFileInfoCacheMgr singleton = new XtlFileInfoCacheMgr ();	
	public static XtlFileInfoCacheMgr self(){
		return singleton;
	}
	public XtlFileInfoCacheMgr getSelf(){
		return self();
	}
	private XtlFileInfoCacheMgr (){
		dao = new XtlDao();
		mXtlFileInfos = new Vector<XtlFileInfo>();
		mXtlFileInfosLoaded = false;
		mXtlFileInfoHash = new Hashtable<String,XtlFileInfo>();

		mXtlFileGroups = new Vector<XtlFileGroup>();
		mXtlFileGroupsLoaded = false;
		mXtlFileGroupHash = new Hashtable<String,XtlFileGroup>();

	}
	private boolean loadXtlFileInfos(){

		if(!mXtlFileInfosLoaded){
			session = XtlFactory.currentSession();
			dao.setSession(session);
			List<XtlFileInfo> array = (List<XtlFileInfo>)dao.queryAll("XtlFileInfo");
			
			for(int i = 0;i < array.size();i++){
				mXtlFileInfos.add(array.get(i));
				mXtlFileInfoHash.put(array.get(i).getId(), array.get(i));
			}
			mXtlFileInfosLoaded = true;
		}
		return true;
	}


	private boolean loadXtlFileGroups(){

		if(!mXtlFileGroupsLoaded){
			session = XtlFactory.currentSession();
			dao.setSession(session);
			List<XtlFileGroup> array = (List<XtlFileGroup>)dao.queryAll("XtlFileGroup");
			
			for(int i = 0;i < array.size();i++){
				mXtlFileGroups.add(array.get(i));
				mXtlFileGroupHash.put(array.get(i).getId(), array.get(i));
			}
			mXtlFileGroupsLoaded = true;
		}
		return true;
	}



	public boolean loadAllDB(){
		loadXtlFileInfos();	

		loadXtlFileGroups();	

		return true;
	}

	public boolean clearCache(){
		mXtlFileInfos.clear();
		mXtlFileInfosLoaded = false;
		mXtlFileInfoHash.clear();

		mXtlFileGroups.clear();
		mXtlFileGroupsLoaded = false;
		mXtlFileGroupHash.clear();

		return true;
	}

	public boolean reloadCache(){
		clearCache();
		loadAllDB();
		return true;
	}
	

	// save new object(if you want to change an exist object, please call other functions.)
	public void saveXtlFileInfo(Object obj) {
		loadXtlFileInfos();
		session = XtlFactory.currentSession();
		dao.setSession(session);
		dao.save(obj);
		XtlFileInfo obj2 = (XtlFileInfo)obj;
		mXtlFileInfos.add(obj2);
		mXtlFileInfoHash.put(obj2.getId(), obj2);
	}
	public void delXtlFileInfo(Object obj) {
		loadXtlFileInfos();

		XtlFileInfo obj2 = (XtlFileInfo)obj;
		
		session = XtlFactory.currentSession();
		dao.setSession(session);
		
		dao.delete(mXtlFileInfoHash.get(obj2.getId()));

		for(XtlFileInfo msg : mXtlFileInfos){
			if(msg.getId().equals(obj2.getId())){
				mXtlFileInfos.remove(msg);
				break;
			}
		}
		mXtlFileInfoHash.remove(obj2.getId());
		
	}
	public void updateXtlFileInfo(Object obj) {
		loadXtlFileInfos();
		
		for(int i = 0; i < mXtlFileInfos.size(); i++){
			if(mXtlFileInfos.get(i).getId().equals(((XtlFileInfo)obj).getId())){
					mXtlFileInfos.set(i, (XtlFileInfo) obj);
					break;
			}
		}
		XtlFileInfo tmp = mXtlFileInfoHash.get(((XtlFileInfo)obj).getId());
		tmp.constructWith((XtlFileInfo)obj);
		
		//mXtlFileInfoHash.remove(((XtlFileInfo)obj).getId());
		//mXtlFileInfoHash.put(((XtlFileInfo)obj).getId(), (XtlFileInfo)obj);
		session = XtlFactory.currentSession();
		dao.setSession(session);
		//dao.update(obj);
		dao.update(tmp);
	}

	public List<XtlFileInfo> getAllXtlFileInfo() {
		loadXtlFileInfos();
		
		List<XtlFileInfo> objects = new ArrayList<XtlFileInfo>();
		for(int i = 0;i < mXtlFileInfos.size(); i++)
		{
			objects.add(mXtlFileInfos.get(i).clone());
		}
		return objects;
	}

	public XtlFileInfo getXtlFileInfoById(String id){
		loadXtlFileInfos();
		return mXtlFileInfoHash.get(id).clone();
	}

	// save new object(if you want to change an exist object, please call other functions.)
	public void saveXtlFileGroup(Object obj) {
		loadXtlFileGroups();
		session = XtlFactory.currentSession();
		dao.setSession(session);
		dao.save(obj);
		XtlFileGroup obj2 = (XtlFileGroup)obj;
		mXtlFileGroups.add(obj2);
		mXtlFileGroupHash.put(obj2.getId(), obj2);
	}
	public void delXtlFileGroup(Object obj) {
		loadXtlFileGroups();

		XtlFileGroup obj2 = (XtlFileGroup)obj;
		
		session = XtlFactory.currentSession();
		dao.setSession(session);
		
		dao.delete(mXtlFileGroupHash.get(obj2.getId()));

		for(XtlFileGroup msg : mXtlFileGroups){
			if(msg.getId().equals(obj2.getId())){
				mXtlFileGroups.remove(msg);
				break;
			}
		}
		mXtlFileGroupHash.remove(obj2.getId());
		
	}
	public void updateXtlFileGroup(Object obj) {
		loadXtlFileGroups();
		
		for(int i = 0; i < mXtlFileGroups.size(); i++){
			if(mXtlFileGroups.get(i).getId().equals(((XtlFileGroup)obj).getId())){
					mXtlFileGroups.set(i, (XtlFileGroup) obj);
					break;
			}
		}
		XtlFileGroup tmp = mXtlFileGroupHash.get(((XtlFileGroup)obj).getId());
		tmp.constructWith((XtlFileGroup)obj);
		
		//mXtlFileGroupHash.remove(((XtlFileGroup)obj).getId());
		//mXtlFileGroupHash.put(((XtlFileGroup)obj).getId(), (XtlFileGroup)obj);
		session = XtlFactory.currentSession();
		dao.setSession(session);
		//dao.update(obj);
		dao.update(tmp);
	}

	public List<XtlFileGroup> getAllXtlFileGroup() {
		loadXtlFileGroups();
		
		List<XtlFileGroup> objects = new ArrayList<XtlFileGroup>();
		for(int i = 0;i < mXtlFileGroups.size(); i++)
		{
			objects.add(mXtlFileGroups.get(i).clone());
		}
		return objects;
	}

	public XtlFileGroup getXtlFileGroupById(Long id){
		loadXtlFileGroups();
		return mXtlFileGroupHash.get(id).clone();
	}


}
