package dao;

import java.util.List;

import entity.User;

public interface UserDao {
		//根据登录名和密码查询
		public User getUserByName(String loginName,String pssword);
		
		//新增用户
		public boolean insertUser(User user);
		
		public List<User> getUser();
		//根据账号查找用户信息
		public User getUserBy(String loginName);
		
		
		
}
