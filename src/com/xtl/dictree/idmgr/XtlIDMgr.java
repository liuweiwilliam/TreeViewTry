package com.xtl.dictree.idmgr;

import java.util.List;

import org.hibernate.Transaction;

import com.xtl.dictree.pojo.XtlID;
import com.xtl.dictree.service.XtlIDService;

public class XtlIDMgr {
	private static XtlIDMgr mSelf;
	
	private static Long smCurID = 0l;
	private static int smCurRestID = 0;
	private static int smBlockSize = 10000;
	private static int smInitStartID = 100000;
	
	public static XtlIDMgr self(){
		if(null==mSelf){
			mSelf = new XtlIDMgr();
		}
		
		return mSelf;
	}
	
	public String getID(){
		return getIDLong()+"";
	}
	
	private static Long getIDLong(){
		synchronized(smCurID){
			if(smCurRestID==0){
				getNewIDBlock();
			}

			smCurRestID--;
			return smCurID++;
		}
	}

	private static void getNewIDBlock() {
		// TODO Auto-generated method stub
		XtlID id = getXtlID();
		
		smCurID = Long.parseLong(id.getNextid());
		smCurRestID = smBlockSize;
		Long next_id = smCurID + smBlockSize;
		id.setNextid(next_id+"");
		XtlIDService.self().updateXtlID(id);
	}
	
	private static XtlID getXtlID(){
		List<XtlID> ids = XtlIDService.self().getAllXtlID();
		
		if(ids.size()>0) return ids.get(0);
		
		XtlID id = new XtlID();
		id.setId("1");
		id.setNextid(""+smInitStartID);
		id.setDr("0");
		XtlIDService.self().saveXtlID(id);
		
		return id.clone();
	}
}
