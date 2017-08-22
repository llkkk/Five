package org.study.mode.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Blog {
	private String blogId;
	private String userId;
	private String blogName;
	private String blogContent;
	private Date blogDate;
	private int cmtNum;
	private String userName;
	public Blog(String blogId, String userId, String blogName, 
				 String blogContent, Date blogDate, int cmtNum,String userName) {
		super();
		this.blogId = blogId;
		this.userId = userId;
		this.blogName = blogName;
		this.blogContent = blogContent;
		this.blogDate = blogDate;
		this.cmtNum = cmtNum;
		this.userName=userName;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogDate() {
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(blogDate);
	}

	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}

	public int getCmtNum() {
		return cmtNum;
	}

	public void setCmtNum(int cmtNum) {
		this.cmtNum = cmtNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", userId=" + userId + ", blogName=" + blogName + ", blogContent="
				+ blogContent + ", blogDate=" + blogDate + ", cmtNum=" + cmtNum + ", userName=" + userName + "]";
	}

	
}
