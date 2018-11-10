package com.xtl.dictree.dao;

import java.util.List;

import org.hibernate.Session;

public class XtlDao {
	private static XtlDao singleton = new XtlDao();
	public static XtlDao self(){
		return singleton;
	}
	private Session session ;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	} 
	
	public void save(Object obj){
		session.save(obj);
	}
	public void update(Object obj){
		session.update(obj);
	}
	
	public void delete(Object obj){
		session.delete(obj);
	}
	
	public List queryAll(String tableClassName){
		List rsl = session.createQuery("from "+tableClassName).list();
		
		return rsl;
	}
	
}
