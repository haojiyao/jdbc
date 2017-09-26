package service.impl;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao=new UserDaoImpl();
	@Override
	public User getUserByName(String loginName, String pssword) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(loginName, pssword);
	}
	@Override
	public User getUserBy(String loginName) {
		// TODO Auto-generated method stub
		return userDao.getUserBy(loginName);
	}
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}

}
