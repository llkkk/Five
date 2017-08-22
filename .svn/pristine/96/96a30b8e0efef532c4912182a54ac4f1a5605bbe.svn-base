package org.study.mode.service;

import java.util.List;

import org.study.mode.pojo.Person;

public interface IPersonService {
	public Person login (String userName,String userPass);
	public int insertPerson (Person p);
	public int updatePerson (Person p);//修改非密码属性
	public int updatePwd(String pid,String newPwd);
	public int deletePerson (String pid);
	public List<Person> selectAllUser();
	public List<Person> selectPage(int page);
	public int updateCount(int count);
	public int selectCount();
	public boolean isUsed(String name);
	public int getMaxPage(); 
	public int updateLimits(String pid,int limit);
	public int selectLimits(String pid);
}
