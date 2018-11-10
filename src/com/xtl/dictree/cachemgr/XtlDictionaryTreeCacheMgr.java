package com.xtl.dictree.cachemgr;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.hibernate.Session;
import com.xtl.dictree.pojo.XtlDictionaryTree;


import com.xtl.dictree.factory.XtlFactory;
import com.xtl.dictree.dao.XtlDao;
public class XtlDictionaryTreeCacheMgr{
  private Session session;
	private XtlDao dao;
	private Vector<XtlDictionaryTree> mXtlDictionaryTrees;
	private boolean mXtlDictionaryTreesLoaded;
	private Hashtable<String, XtlDictionaryTree> mXtlDictionaryTreeHash;


	// Singleton functions ( construction is private)
	private final static XtlDictionaryTreeCacheMgr singleton = new XtlDictionaryTreeCacheMgr ();	
	public static XtlDictionaryTreeCacheMgr self(){
		return singleton;
	}
	public XtlDictionaryTreeCacheMgr getSelf(){
		return self();
	}
	private XtlDictionaryTreeCacheMgr (){
		dao = new XtlDao();
		mXtlDictionaryTrees = new Vector<XtlDictionaryTree>();
		mXtlDictionaryTreesLoaded = false;
		mXtlDictionaryTreeHash = new Hashtable<String, XtlDictionaryTree>();

	}
	private boolean loadXtlDictionaryTrees(){

		if(!mXtlDictionaryTreesLoaded){
			session = XtlFactory.currentSession();
			dao.setSession(session);
			List<XtlDictionaryTree> array = (List<XtlDictionaryTree>)dao.queryAll("XtlDictionaryTree");
			
			for(int i = 0;i < array.size();i++){
				mXtlDictionaryTrees.add(array.get(i));
				mXtlDictionaryTreeHash.put(array.get(i).getId(), array.get(i));
			}
			mXtlDictionaryTreesLoaded = true;
		}
		return true;
	}



	public boolean loadAllDB(){
		loadXtlDictionaryTrees();	

		return true;
	}

	public boolean clearCache(){
		mXtlDictionaryTrees.clear();
		mXtlDictionaryTreesLoaded = false;
		mXtlDictionaryTreeHash.clear();

		return true;
	}

	public boolean reloadCache(){
		clearCache();
		loadAllDB();
		return true;
	}
	

	// save new object(if you want to change an exist object, please call other functions.)
	public void saveXtlDictionaryTree(Object obj) {
		loadXtlDictionaryTrees();
		session = XtlFactory.currentSession();
		dao.setSession(session);
		dao.save(obj);
		XtlDictionaryTree obj2 = (XtlDictionaryTree)obj;
		mXtlDictionaryTrees.add(obj2);
		mXtlDictionaryTreeHash.put(obj2.getId(), obj2);
	}
	public void delXtlDictionaryTree(Object obj) {
		loadXtlDictionaryTrees();

		XtlDictionaryTree obj2 = (XtlDictionaryTree)obj;
		
		session = XtlFactory.currentSession();
		dao.setSession(session);
		
		dao.delete(mXtlDictionaryTreeHash.get(obj2.getId()));

		for(XtlDictionaryTree msg : mXtlDictionaryTrees){
			if(msg.getId().equals(obj2.getId())){
				mXtlDictionaryTrees.remove(msg);
				break;
			}
		}
		mXtlDictionaryTreeHash.remove(obj2.getId());
		
	}
	public void updateXtlDictionaryTree(Object obj) {
		loadXtlDictionaryTrees();
		
		for(int i = 0; i < mXtlDictionaryTrees.size(); i++){
			if(mXtlDictionaryTrees.get(i).getId().equals(((XtlDictionaryTree)obj).getId())){
					mXtlDictionaryTrees.set(i, (XtlDictionaryTree) obj);
					break;
			}
		}
		XtlDictionaryTree tmp = mXtlDictionaryTreeHash.get(((XtlDictionaryTree)obj).getId());
		tmp.constructWith((XtlDictionaryTree)obj);
		
		//mXtlDictionaryTreeHash.remove(((XtlDictionaryTree)obj).getId());
		//mXtlDictionaryTreeHash.put(((XtlDictionaryTree)obj).getId(), (XtlDictionaryTree)obj);
		session = XtlFactory.currentSession();
		dao.setSession(session);
		//dao.update(obj);
		dao.update(tmp);
	}

	public List<XtlDictionaryTree> getAllXtlDictionaryTree() {
		loadXtlDictionaryTrees();
		
		List<XtlDictionaryTree> objects = new ArrayList<XtlDictionaryTree>();
		for(int i = 0;i < mXtlDictionaryTrees.size(); i++)
		{
			objects.add(mXtlDictionaryTrees.get(i).clone());
		}
		return objects;
	}

	public XtlDictionaryTree getXtlDictionaryTreeById(Long id){
		loadXtlDictionaryTrees();
		return mXtlDictionaryTreeHash.get(id).clone();
	}


}
