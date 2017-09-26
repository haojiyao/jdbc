package service;

import java.util.List;

import entity.User;

public interface UserService {
			//根据登录名和密码查询
			public User getUserByName(String loginName,String pssword);
			//根据用户名查询信息
			public User getUserBy(String loginName);
			//查询所有用户信息
			public List<User> getUser();
			
}
