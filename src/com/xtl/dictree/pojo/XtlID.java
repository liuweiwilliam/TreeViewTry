
package com.xtl.dictree.pojo;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/*
id     id

nextid     下次开始ID

dr     删除标志

*/
public class XtlID {

	private String id;

	private String nextid;

	private String dr;

	
	public XtlID(){};
	
	public XtlID(XtlID obj){
	    id = obj.getId();

	    nextid = obj.getNextid();

	    dr = obj.getDr();

	}

	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}

	public String getNextid() {
	    return nextid;
	}
	public void setNextid(String nextid) {
	    this.nextid = nextid;
	}

	public String getDr() {
	    return dr;
	}
	public void setDr(String dr) {
	    this.dr = dr;
	}


	public XtlID clone(){
		XtlID rslt = new XtlID();
		rslt.id = this.getId();

		rslt.nextid = this.getNextid();

		rslt.dr = this.getDr();

		return rslt;
	}
	public void constructWith(XtlID pro) {
		// TODO Auto-generated method stub
		this.id   = pro.getId ();

		this.nextid   = pro.getNextid ();

		this.dr   = pro.getDr ();

	}
}
