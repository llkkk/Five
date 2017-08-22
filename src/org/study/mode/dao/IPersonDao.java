package org.study.mode.dao;

import java.util.List;
import org.study.mode.pojo.Person;

public interface IPersonDao {
	public Person login(String name,String pass);		//验证登录
	public int insertPerson(Person p);				    //注册新用户
	public int updatePerson(Person p);				    //更新用户数据
	public int updatePwd(String pid,String newPwd);
	public int deletePerson(String pid);				//删除用户
	public List<Person> selectAllUser();
	public List<Person> selectPagePerson(int page);	    //查询一页用户
	public int updateCount(int count);				    //更新用户访问次数
	public int selectCount();							//获得用户访问次数
	public boolean isUsed(String name);				//查询当前用户名是否已被使用
	public int getMaxPage();                        //获取分页数
	public int updateLimits(String pid,int limit);
	public int selectLimits(String pid);
}
