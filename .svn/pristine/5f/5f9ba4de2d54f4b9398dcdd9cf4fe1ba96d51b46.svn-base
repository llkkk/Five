package org.study.mode.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cmt {
	private String cmtId;
	private String blogId;
	private String userId;
	private String userName;
	private String cmtContent;
	private Date dayOfCmt;
	public Cmt(String cmtId, String blogId, String userId, String cmtContent, Date dayOfCmt,String userName) {
		super();
		this.cmtId = cmtId;
		this.blogId = blogId;
		this.userId = userId;
		this.cmtContent = cmtContent;
		this.dayOfCmt = dayOfCmt;
		this.userName=userName;
	}
	public String getCmtId() {
		return cmtId;
	}
	public String getBlogId() {
		return blogId;
	}
	public String getUserId() {
		return userId;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public String getDayOfCmt() {
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dayOfCmt);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setCmtId(String cmtId) {
		this.cmtId = cmtId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public void setDayOfCmt(Date dayOfCmt) {
		this.dayOfCmt = dayOfCmt;
	}
}
