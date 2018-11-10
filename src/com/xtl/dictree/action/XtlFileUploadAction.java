package com.xtl.dictree.action;

import java.awt.image.BufferedImage;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.InputStream;  
import java.io.OutputStream;  

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;  
  
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;  
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;  
import com.xtl.dictree.factory.XtlFactory;
import com.xtl.dictree.idmgr.XtlIDMgr;
import com.xtl.dictree.pojo.XtlFileInfo;
import com.xtl.dictree.service.XtlFileInfoService;
import com.xtl.dictree.utils.XtlConstString;
import com.xtl.dictree.utils.XtlFileInfoUtil;
import com.xtl.dictree.utils.XtlProperties;
/**
 * 文件上传下载类
 * @author 	LiuWei
 * @date	2017-8-9
 */
public class XtlFileUploadAction extends XtlBaseAction{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;  
    //封装上传文件域的属性  
    private File file;  
    //封装上传文件类型的属性  
    private String fileContentType;  
    //封装上传文件名的属性  
    private String fileFileName;  
    //提示信息  
    private String json_message;  
	
    private String type;
    
	public String upload() throws Exception{
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		String save_path = ServletActionContext.getServletContext().getRealPath(XtlProperties.getFILE_UPLOAD_PATH());
		JSONObject re_rslt = new JSONObject();
		
		File saveFile=new File(save_path);
		if(!saveFile.exists()){
            saveFile.mkdirs();
        }
		InputStream is = new FileInputStream(file);
		
		int width = 0;
		int height = 20;
		
		int base_width = 250;
		
		BufferedImage bi = null;
		
		String file_type = XtlFileInfoUtil.self().typeOf(fileFileName);
		
		if(file_type.equals(XtlConstString.sm_FILE_TYPE_IMAGE)){
			try {
				bi = ImageIO.read(file);
				width = bi.getWidth();
				height = bi.getHeight();
				height = height * base_width / width;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		re_rslt.put("width", width);
		re_rslt.put("height", height);

		System.out.println("fileFileName: " + fileFileName);
		System.out.println("type: " + type);
		//获取文件后缀  
		String fileSuffix=fileFileName.substring(fileFileName.lastIndexOf("."));
		String fileId = XtlIDMgr.self().getID();
		
		String new_name = fileId + fileSuffix;
		
		OutputStream os = new FileOutputStream(new File(save_path, new_name));

        byte[] buffer = new byte[2000];
        int length = 0;
        
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        
        os.close();
        is.close();

        //TODO remove default userid
        
        Transaction ts = XtlFactory.currentSession().beginTransaction();
        try{
        	re_rslt.put("id", fileId);
    		re_rslt.put("filename", fileFileName);
    		
    		int index = (save_path + "\\" + new_name).indexOf(XtlProperties.getProjectName());
			String path_tmp = (save_path + "\\" + new_name).substring(index + XtlProperties.getProjectName().length() + 1);
			if(path_tmp.contains("\\")){
				path_tmp = path_tmp.replace("\\", "/");
			}
			
			String url_path = XtlProperties.getDOMAIN_NAME() + path_tmp;
    		re_rslt.put("path", url_path);
    		re_rslt.put("type", file_type);
    		
        	XtlFileInfoService.self().addFileInfo(fileId, fileFileName, save_path + "\\" + new_name, url_path);
        	
        	ts.commit();
        }catch(Exception e){
        	e.printStackTrace();
        	ts.rollback();
        }finally{
        	XtlFactory.closeSession();
        }

        HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().append(re_rslt.toString());
			response.getWriter().close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private InputStream downloadFile;
	private String fileName;
	private String fileId;
	public InputStream getDownloadFile() throws FileNotFoundException
    {
		XtlFileInfo file_info = XtlFileInfoService.self().getXtlFileInfoById(fileId);
		fileName = file_info.getFname();
		String path = file_info.getSavepath();
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
        return inputStream;
    }

	public String download(){
		return SUCCESS;
	}
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public File getFile() {  
        return file;  
    }  
  
    public void setFile(File file) {  
        this.file = file;  
    }  
  
    public String getFileContentType() {  
        return fileContentType;  
    }  
  
    public String getJson_message() {  
        return json_message;  
    }  
    public void setJson_message(String jsonMessage) {  
        json_message = jsonMessage;  
    }  
    public void setFileContentType(String fileContentType) {  
        this.fileContentType = fileContentType;  
    }  
  
    public String getFileFileName() {  
        return fileFileName;  
    }  
  
    public void setFileFileName(String fileFileName) {  
        this.fileFileName = fileFileName;  
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}  
}  