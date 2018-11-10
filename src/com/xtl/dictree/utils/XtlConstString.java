package com.xtl.dictree.utils;

/**
 * @author	LiuWei
 * @date	2071-07-10
 * @describe	用于存放常量字符串
 */
public class XtlConstString {
	/**
	 * 1、变量命名以"sm" 打头(static member)
	 * 2、变量命中尽量包含模块以及变量含义（Test 模块中的 Example 含义的变量，命名为  "smTestExample"）
	 * 		并标明变量含义
	 * 3、添加新变量时请搜索此类中是否已存在相同的字符串，并判断应用场景是否相同
	 * 		如果相同，则可直接使用；
	 * 		若不相同，可以直接新建（不推荐），和历史存在的作者进行沟通
	 */
	
	//LiuWei zone begin
	// Test模块 示例
	public final static String smTestExample = "测试示例字符串";
	public final static String smTagName_System = "系统标签";
	public final static String smTagName_Private = "私有标签";
	
	//文件类型
	public final static String sm_FILE_TYPE_IMAGE = "file_type_image";
	public final static String sm_FILE_TYPE_AUDIO = "file_type_audio";
	public final static String sm_FILE_TYPE_VIDEO = "file_type_video";
	public final static String sm_FILE_TYPE_NORMAL = "file_type_normal";
	//LiuWei zone end
}
