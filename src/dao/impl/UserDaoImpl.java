package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.SecurityUtils;


import dao.BaseDao;
import dao.UserDao;
import entity.News;
import entity.Product;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User getUserByName(String loginName, String password) {
		
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql=" select * from easybuy_user where 1=1";	 
		if(loginName!=null){
			sql+=" and loginName='"+loginName+"'";
		}
		if(password!=null){
			sql+=" and password='"+SecurityUtils.md5Hex(password)+"'";
		}
		try {
			User user=null;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){	
				user=new User();
				user.setId(rs.getInt(1));
				user.setLoginName(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setSex(rs.getInt(5));
				user.setIdentityCode(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setMobile(rs.getString(8));
				user.setType(rs.getInt(9));	 
			}
			System.out.println("userDao:"+user.getUserName());
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, rs);
		}
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		 
		String sql="insert into easybuy_user() values()";	 
		 
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){	 
				user.setId(rs.getInt(1));
				user.setLoginName(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setSex(rs.getInt(5));
				user.setIdentityCode(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setMobile(rs.getString(8));
				user.setType(rs.getInt(9));	 
			}
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, rs);
		}
		return false;
	}

	public boolean addUser(User user) throws SQLException{
		Connection conn=getConnection();
		//2sql
		String sql="insert into easybuy_user(loginName,userName,password) values(?,?,?)";
		PreparedStatement pstmt=null;
		int reuslt;
		//实例化PreparedStatement对象
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,user.getLoginName());
		pstmt.setString(2,user.getUserName());
		//执行
		reuslt=pstmt.executeUpdate();
		if(reuslt>0){
			return true;
		}
		return false;
		
	}
	
	
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
				//1.创建数据库链接
				Connection conn=getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				List<User> list=new ArrayList<User>();
				//2.sql语句
				String sql=" select * from easybuy_user";			 
				try {
					//3.执行sql语句
					pstmt=conn.prepareStatement(sql);
					//4.得到结果
					rs=pstmt.executeQuery();
					//5.把结果从resultset中拿出来，放到list集合中
					while(rs.next()){
						User user=new User();
						user.setId(rs.getInt(1));
						user.setLoginName(rs.getString(2));
						user.setUserName(rs.getString(3));
						user.setPassword(rs.getString(4));
						user.setSex(rs.getInt(5));
						user.setIdentityCode(rs.getString(6));
						user.setEmail(rs.getString(7));
						user.setMobile(rs.getString(8));
						user.setType(rs.getInt(9));	
						
						list.add(user);
					}
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					closeAll(conn, pstmt, rs);
				}
				return null; 
	}

	@Override
	public User getUserBy(String loginName) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql=" select * from easybuy_user where loginName='"+loginName+"'";	 
		
		try {
			User user=null;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){	
				user=new User();
				user.setId(rs.getInt(1));
				user.setLoginName(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setSex(rs.getInt(5));
				user.setIdentityCode(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setMobile(rs.getString(8));
				user.setType(rs.getInt(9));	 
			}
			System.out.println("userDao:"+user.getUserName());
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, rs);
		}
		return null;
	}

}
