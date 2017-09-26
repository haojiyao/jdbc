package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

 

public class BaseDao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		init();
	}
	
	public static void init(){
		Properties params=new Properties();
		String configFile = "database.properties";
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver=params.getProperty("driver");
		url=params.getProperty("url");
		user=params.getProperty("username");
		password=params.getProperty("password");
	}   

	public Connection getConnection(){
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,user,password);
			return conn;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	
	private Connection conn=null;
	private PreparedStatement pstm=null;
	public ResultSet executeQuery(String sql,Object[] params){
		ResultSet rs=null;
		conn=getConnection();
		try {
			pstm = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				pstm.setObject(i+1, params[i]);
			}
			rs = pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	
	
	
	

public void closeAll(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
}
