package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import dao.BaseDao;
import dao.OrderDao;
import entity.Order;
import entity.Product;

public class OrderDaoImpl extends BaseDao implements OrderDao{

	public List<Order> getOrder(String loginName, String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Order> list=new ArrayList<Order>();
		String sql=" select * from easybuy_order where 1=1";
		if(loginName!=null){
			sql+=" and loginName='"+loginName+"'";
		}
		
		if(pageNo!=null&&pageSize!=null){
			int no=Integer.parseInt(pageNo);
			int size=Integer.parseInt(pageSize);
			sql+=" limit "+(no-1)*size+","+size+"";
		}
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setSerialNumber(rs.getString(7));
				order.setLoginName(rs.getString(3));
				order.setUserAddress(rs.getString(4));
				order.setCreateTime(rs.getDate(5));
				order.setCost(rs.getFloat(6));
				list.add(order);
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
	public List<Order> getquan(String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Order> list=new ArrayList<Order>();
		String sql=" select * from easybuy_order where 1=1";
	
		if(pageNo!=null&&pageSize!=null){
			int no=Integer.parseInt(pageNo);
			int size=Integer.parseInt(pageSize);
			sql+=" limit "+(no-1)*size+","+size+"";
		}
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setSerialNumber(rs.getString(7));
				order.setLoginName(rs.getString(3));
				order.setUserAddress(rs.getString(4));
				order.setCreateTime(rs.getDate(5));
				order.setCost(rs.getFloat(6));
				list.add(order);
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

}
