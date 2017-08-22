package org.study.mode.service.impl;

import java.util.List;
import java.util.UUID;
import org.study.mode.dao.IPersonDao;
import org.study.mode.dao.impl.PersonDao;
import org.study.mode.pojo.Person;
import org.study.mode.service.IPersonService;
import org.study.util.EncryptionByPass;

public class PersonService implements IPersonService{
	IPersonDao idao = new PersonDao();
	@Override
	public Person login(String userName, String userPass) {
		return idao.login(userName,EncryptionByPass.getBase64(userPass));
	}
	
	public int insertPerson (Person p){
		p.setUserId(UUID.randomUUID().toString());
		p.setUserPass(EncryptionByPass.getBase64(p.getUserPass()));
		return idao.insertPerson(p);
	}
	@Override
	public int updatePerson(Person p) {
		return idao.updatePerson(p);
	}
	@Override
	public int deletePerson(String pid) {
		return idao.deletePerson(pid);
	}

	@Override
	public List<Person> selectPage(int page) {
		// TODO Auto-generated method stub
		return idao.selectPagePerson(page);
	}

	@Override
	public int updateCount(int count) {
		// TODO Auto-generated method stub
		return idao.updateCount(count);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return idao.selectCount();
	}

	@Override
	public boolean isUsed(String name) {
		// TODO Auto-generated method stub
		return idao.isUsed(name);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return idao.getMaxPage();
	}

	@Override
	public List<Person> selectAllUser() {
		// TODO Auto-generated method stub
		return idao.selectAllUser();
	}

	@Override
	public int updatePwd(String pid, String newPwd) {
		// TODO Auto-generated method stub
		newPwd=EncryptionByPass.getBase64(newPwd);
		return idao.updatePwd(pid, newPwd);
	}

	@Override
	public int updateLimits(String pid, int limit) {
		// TODO Auto-generated method stub
		return idao.updateLimits(pid, limit);
	}

	@Override
	public int selectLimits(String pid) {
		// TODO Auto-generated method stub
		return idao.selectLimits(pid);
	}
}
