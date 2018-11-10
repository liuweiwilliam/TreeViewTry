
/*
 * created by zhongyao on 2017/07/06
 */

package com.xtl.dictree.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class XtlFileInfoUtil {
	private final static XtlFileInfoUtil singleton = new XtlFileInfoUtil();
	
	public static XtlFileInfoUtil self() { return singleton; }
	public XtlFileInfoUtil getSelf() { return self(); }
	private XtlFileInfoUtil() { }
	
	// get file type of a file
	public String typeOf(String name) {
		List<String> imgs = new ArrayList<String>();
		imgs.add(".png");
		imgs.add(".PNG");
		imgs.add(".jpg");
		imgs.add(".JPG");
		imgs.add(".jpeg");
		imgs.add(".JPEG");
		imgs.add(".gif");
		imgs.add(".GIF");
		imgs.add(".bmp");
		imgs.add(".BMP");
		List<String> auds = new ArrayList<String>();
		imgs.add(".mp3");
		imgs.add(".MP3");
		imgs.add(".wav");
		imgs.add(".WAV");
		imgs.add(".wma");
		imgs.add(".WMA");
		imgs.add(".aac");
		imgs.add(".AAC");
		List<String> vids = new ArrayList<String>();
		imgs.add(".mpeg-1");
		imgs.add(".MPEG-1");
		imgs.add(".mpeg-2");
		imgs.add(".MPEG-2");
		imgs.add(".mpeg-4");
		imgs.add(".MPEG-4");
		imgs.add(".avi");
		imgs.add(".AVI");
		imgs.add(".wmv");
		imgs.add(".WMV");
		imgs.add(".mov");
		imgs.add(".MOV");
		imgs.add(".rmvb");
		imgs.add(".RMVB");
		for (String e: imgs) {
			if (name.contains(e)) return XtlConstString.sm_FILE_TYPE_IMAGE;
		}
		for (String e: auds) {
			if (name.contains(e)) return XtlConstString.sm_FILE_TYPE_AUDIO;
		}
		for (String e: vids) {
			if (name.contains(e)) return XtlConstString.sm_FILE_TYPE_VIDEO;
		}
		return XtlConstString.sm_FILE_TYPE_NORMAL;
	}
	
	// a file whether exist
	public boolean exists(String name) {
		return (new File(name)).exists();
	}
}
