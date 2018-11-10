
package com.xtl.dictree.pojo;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/*
id     主键

uid     上传人ID

fname     文件名

ftype     文件类型

savepath     文件存放路径

urlpath     文件网络可访问路径

create_time     创建时间

hdef1     备用字段1-10

hdef2      

hdef3      

hdef4      

hdef5      

hdef6      

hdef7      

hdef8      

hdef9      

hdef10      

dr     删除标志

*/
public class XtlFileInfo {

	private String id;

	private String uid;

	private String fname;

	private String ftype;

	private String savepath;

	private String urlpath;

	private String create_time;

	private String hdef1;

	private String hdef2;

	private String hdef3;

	private String hdef4;

	private String hdef5;

	private String hdef6;

	private String hdef7;

	private String hdef8;

	private String hdef9;

	private String hdef10;

	private String dr;

	
	public XtlFileInfo(){};
	
	public XtlFileInfo(XtlFileInfo obj){
	    id = obj.getId();

	    uid = obj.getUid();

	    fname = obj.getFname();

	    ftype = obj.getFtype();

	    savepath = obj.getSavepath();

	    urlpath = obj.getUrlpath();

	    create_time = obj.getCreate_time();

	    hdef1 = obj.getHdef1();

	    hdef2 = obj.getHdef2();

	    hdef3 = obj.getHdef3();

	    hdef4 = obj.getHdef4();

	    hdef5 = obj.getHdef5();

	    hdef6 = obj.getHdef6();

	    hdef7 = obj.getHdef7();

	    hdef8 = obj.getHdef8();

	    hdef9 = obj.getHdef9();

	    hdef10 = obj.getHdef10();

	    dr = obj.getDr();

	}

	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}

	public String getUid() {
	    return uid;
	}
	public void setUid(String uid) {
	    this.uid = uid;
	}

	public String getFname() {
	    return fname;
	}
	public void setFname(String fname) {
	    this.fname = fname;
	}

	public String getFtype() {
	    return ftype;
	}
	public void setFtype(String ftype) {
	    this.ftype = ftype;
	}

	public String getSavepath() {
	    return savepath;
	}
	public void setSavepath(String savepath) {
	    this.savepath = savepath;
	}

	public String getUrlpath() {
	    return urlpath;
	}
	public void setUrlpath(String urlpath) {
	    this.urlpath = urlpath;
	}

	public String getCreate_time() {
	    return create_time;
	}
	public void setCreate_time(String create_time) {
	    this.create_time = create_time;
	}

	public String getHdef1() {
	    return hdef1;
	}
	public void setHdef1(String hdef1) {
	    this.hdef1 = hdef1;
	}

	public String getHdef2() {
	    return hdef2;
	}
	public void setHdef2(String hdef2) {
	    this.hdef2 = hdef2;
	}

	public String getHdef3() {
	    return hdef3;
	}
	public void setHdef3(String hdef3) {
	    this.hdef3 = hdef3;
	}

	public String getHdef4() {
	    return hdef4;
	}
	public void setHdef4(String hdef4) {
	    this.hdef4 = hdef4;
	}

	public String getHdef5() {
	    return hdef5;
	}
	public void setHdef5(String hdef5) {
	    this.hdef5 = hdef5;
	}

	public String getHdef6() {
	    return hdef6;
	}
	public void setHdef6(String hdef6) {
	    this.hdef6 = hdef6;
	}

	public String getHdef7() {
	    return hdef7;
	}
	public void setHdef7(String hdef7) {
	    this.hdef7 = hdef7;
	}

	public String getHdef8() {
	    return hdef8;
	}
	public void setHdef8(String hdef8) {
	    this.hdef8 = hdef8;
	}

	public String getHdef9() {
	    return hdef9;
	}
	public void setHdef9(String hdef9) {
	    this.hdef9 = hdef9;
	}

	public String getHdef10() {
	    return hdef10;
	}
	public void setHdef10(String hdef10) {
	    this.hdef10 = hdef10;
	}

	public String getDr() {
	    return dr;
	}
	public void setDr(String dr) {
	    this.dr = dr;
	}


	public XtlFileInfo clone(){
		XtlFileInfo rslt = new XtlFileInfo();
		rslt.id = this.getId();

		rslt.uid = this.getUid();

		rslt.fname = this.getFname();

		rslt.ftype = this.getFtype();

		rslt.savepath = this.getSavepath();

		rslt.urlpath = this.getUrlpath();

		rslt.create_time = this.getCreate_time();

		rslt.hdef1 = this.getHdef1();

		rslt.hdef2 = this.getHdef2();

		rslt.hdef3 = this.getHdef3();

		rslt.hdef4 = this.getHdef4();

		rslt.hdef5 = this.getHdef5();

		rslt.hdef6 = this.getHdef6();

		rslt.hdef7 = this.getHdef7();

		rslt.hdef8 = this.getHdef8();

		rslt.hdef9 = this.getHdef9();

		rslt.hdef10 = this.getHdef10();

		rslt.dr = this.getDr();

		return rslt;
	}
	public void constructWith(XtlFileInfo pro) {
		// TODO Auto-generated method stub
		this.id   = pro.getId ();

		this.uid   = pro.getUid ();

		this.fname   = pro.getFname ();

		this.ftype   = pro.getFtype ();

		this.savepath   = pro.getSavepath ();

		this.urlpath   = pro.getUrlpath ();

		this.create_time   = pro.getCreate_time ();

		this.hdef1   = pro.getHdef1 ();

		this.hdef2   = pro.getHdef2 ();

		this.hdef3   = pro.getHdef3 ();

		this.hdef4   = pro.getHdef4 ();

		this.hdef5   = pro.getHdef5 ();

		this.hdef6   = pro.getHdef6 ();

		this.hdef7   = pro.getHdef7 ();

		this.hdef8   = pro.getHdef8 ();

		this.hdef9   = pro.getHdef9 ();

		this.hdef10   = pro.getHdef10 ();

		this.dr   = pro.getDr ();

	}
}
