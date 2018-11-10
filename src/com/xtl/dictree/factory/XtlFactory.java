package com.xtl.dictree.factory;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class XtlFactory {
	public static final String CONFIG = "hibernate.cfg.xml"; 
	private static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();
	private static Configuration config ;
	private static ServiceRegistryBuilder builder;  
  
    private static ServiceRegistry registry;  
    
    private static SessionFactory sessionFactory;
    static{
    	try{
    		config = new Configuration().configure(CONFIG);
    		builder = new ServiceRegistryBuilder().applySettings(config.getProperties());
    		registry = builder.buildServiceRegistry();
    		sessionFactory = config.buildSessionFactory(registry);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public static Session currentSession() throws HibernateException{
    	Session session = threadlocal.get();
    	
    	if(session==null || session.isOpen()==false){
    		if(sessionFactory==null||sessionFactory.isClosed()){
    			try{
    				config = new Configuration().configure(CONFIG);
    				builder = new ServiceRegistryBuilder().applySettings(config.getProperties());
    				registry = builder.buildServiceRegistry();
    				sessionFactory = config.buildSessionFactory(registry);
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		}
    		
    		session = sessionFactory.openSession();
    		
        	threadlocal.set(session);
    	}
    	
    	//System.out.println("session getted");
    	return session;
    }
    
    public static void closeSession() throws HibernateException {  
        Session session = threadlocal.get();  
        threadlocal.set(null);  
        if (session != null) {  
            session.close();  
        }  
    }
}
