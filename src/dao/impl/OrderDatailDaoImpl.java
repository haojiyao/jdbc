package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;



import dao.BaseDao;
import dao.OrderDetailDao;
import entity.OrderDetail;
import entity.Product;

public class OrderDatailDaoImpl extends BaseDao implements OrderDetailDao{

	@Override
	public List<OrderDetail> getOrderDetails(int id) {
		// TODO Auto-generated method stub
		/**
		 * SELECT easybuy_order_detail.*,easybuy_product.name,easybuy_product.fileName
			FROM easybuy_order_detail,easybuy_product
			WHERE easybuy_order_detail.productId=easybuy_product.id
		 */
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT easybuy_order_detail.*,easybuy_product.name,easybuy_product.fileName"
			+" FROM easybuy_order_detail,easybuy_product"
			+" WHERE easybuy_order_detail.productId=easybuy_product.id"
			+" and orderId="+id;
		List<OrderDetail> orders=new ArrayList<OrderDetail>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				OrderDetail detail=new OrderDetail();
				detail.setId(rs.getInt(1));
				detail.setOrderId(rs.getInt(2));
				detail.setQuantity(rs.getInt(3));
				detail.setCost(rs.getFloat(4));
				detail.setProductId(rs.getInt(5));
				Product pro=new Product();
				pro.setName(rs.getString(6));
				pro.setFileName(rs.getString(7));
				detail.setProduct(pro);
				orders.add(detail);
				
			}
			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
