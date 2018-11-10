package com.xtl.dictree.cachemgr;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.hibernate.Session;

import com.xtl.dictree.dao.XtlDao;
import com.xtl.dictree.factory.XtlFactory;
import com.xtl.dictree.pojo.XtlID;
public class XtlIDCacheMgr{
  private Session session;
	private XtlDao dao;
	private Vector<XtlID> mXtlIDs;
	private boolean mXtlIDsLoaded;
	private Hashtable<String, XtlID> mXtlIDHash;


	// Singleton functions ( construction is private)
	private final static XtlIDCacheMgr singleton = new XtlIDCacheMgr ();	
	public static XtlIDCacheMgr self(){
		return singleton;
	}
	public XtlIDCacheMgr getSelf(){
		return self();
	}
	private XtlIDCacheMgr (){
		dao = new XtlDao();
		mXtlIDs = new Vector<XtlID>();
		mXtlIDsLoaded = false;
		mXtlIDHash = new Hashtable<String,XtlID>();

	}
	private boolean loadXtlIDs(){

		if(!mXtlIDsLoaded){
			session = XtlFactory.currentSession();
			dao.setSession(session);
			List<XtlID> array = (List<XtlID>)dao.queryAll("XtlID");
			
			for(int i = 0;i < array.size();i++){
				mXtlIDs.add(array.get(i));
				mXtlIDHash.put(array.get(i).getId(), array.get(i));
			}
			mXtlIDsLoaded = true;
		}
		return true;
	}



	public boolean loadAllDB(){
		loadXtlIDs();	

		return true;
	}

	public boolean clearCache(){
		mXtlIDs.clear();
		mXtlIDsLoaded = false;
		mXtlIDHash.clear();

		return true;
	}

	public boolean reloadCache(){
		clearCache();
		loadAllDB();
		return true;
	}
	

	// save new object(if you want to change an exist object, please call other functions.)
	public void saveXtlID(Object obj) {
		loadXtlIDs();
		session = XtlFactory.currentSession();
		dao.setSession(session);
		dao.save(obj);
		XtlID obj2 = (XtlID)obj;
		mXtlIDs.add(obj2);
		mXtlIDHash.put(obj2.getId(), obj2);
	}
	public void delXtlID(Object obj) {
		loadXtlIDs();

		XtlID obj2 = (XtlID)obj;
		
		session = XtlFactory.currentSession();
		dao.setSession(session);
		
		dao.delete(mXtlIDHash.get(obj2.getId()));

		for(XtlID msg : mXtlIDs){
			if(msg.getId().equals(obj2.getId())){
				mXtlIDs.remove(msg);
				break;
			}
		}
		mXtlIDHash.remove(obj2.getId());
		
	}
	public void updateXtlID(Object obj) {
		loadXtlIDs();
		
		for(int i = 0; i < mXtlIDs.size(); i++){
			if(mXtlIDs.get(i).getId().equals(((XtlID)obj).getId())){
					mXtlIDs.set(i, (XtlID) obj);
					break;
			}
		}
		XtlID tmp = mXtlIDHash.get(((XtlID)obj).getId());
		tmp.constructWith((XtlID)obj);
		
		//mXtlIDHash.remove(((XtlID)obj).getId());
		//mXtlIDHash.put(((XtlID)obj).getId(), (XtlID)obj);
		session = XtlFactory.currentSession();
		dao.setSession(session);
		//dao.update(obj);
		dao.update(tmp);
	}

	public List<XtlID> getAllXtlID() {
		loadXtlIDs();
		
		List<XtlID> objects = new ArrayList<XtlID>();
		for(int i = 0;i < mXtlIDs.size(); i++)
		{
			objects.add(mXtlIDs.get(i).clone());
		}
		return objects;
	}

	public XtlID getXtlIDById(Long id){
		loadXtlIDs();
		return mXtlIDHash.get(id).clone();
	}


}
