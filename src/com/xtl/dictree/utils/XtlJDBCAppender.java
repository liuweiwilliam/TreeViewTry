package com.xtl.dictree.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.spi.ErrorCode;

import com.codestudio.sql.PoolMan;

public class XtlJDBCAppender extends org.apache.log4j.jdbc.JDBCAppender {  
    /**通过 PoolMan 获取数据库连接对象的 jndiName 属性*/  
    protected String jndiName;
    /**数据库连接对象*/  
    protected Connection connection;  
    public XtlJDBCAppender() {  
        super();  
    }  
    @Override  
    protected void closeConnection(Connection con) {  
        try {  
            if (connection != null && !connection.isClosed())  
            	//System.out.println("close connect : " + connection.hashCode());
                connection.close();  
        } catch (SQLException e) {  
            errorHandler.error("Error closing connection", e, ErrorCode.GENERIC_FAILURE);  
        }  
    }  
    @Override  
    protected Connection getConnection() throws SQLException {  
        try {  
            //通过 PoolMan 获取数据库连接对象(http://nchc.dl.sourceforge.net/project/poolman/PoolMan/poolman-2.1-b1/poolman-2.1-b1.zip)  
            Class.forName("com.xtl.dictree.utils.XtlJDBCAppender");  
            connection= PoolMan.connect("jdbc:poolman://" + getJndiName());
            //System.out.println("get connect : " + connection.hashCode());
        } catch (Exception e) {  
            System.out.println(e.getMessage());
        }  
        return connection;  
    }  
    /** 
     * @return the jndiName 
     */  
    public String getJndiName() {  
        return jndiName;  
    }  
    /** 
     * @param jndiName the jndiName to set 
     */  
    public void setJndiName(String jndiName) {  
        this.jndiName = jndiName;  
    }  
} 
