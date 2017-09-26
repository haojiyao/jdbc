package dao.impl;

import java.awt.print.Pageable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ProductDao;
import entity.Product;
import entity.ProductCategory;

public class ProductDaoImpl extends BaseDao implements ProductDao{

	@Override
	public List<Product> getProByL1orL2orL3(String level1, String level2,
			String level3) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		String sql=" select * from easybuy_product where 1=1";
		if(level1!=null){
			sql+=" and categoryLevel1Id="+level1;
		}
		if(level2!=null){
			sql+=" and  categoryLevel2Id="+level2;
		}
		if(level3!=null){
			sql+=" and  categoryLevel3Id="+level3;
		}
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setDescription(rs.getString(3));
				pro.setPrice(rs.getFloat(4));
				pro.setStock(rs.getInt(5));
				pro.setCategoryLevel1Id(rs.getInt(6));
				pro.setCategoryLevel2Id(rs.getInt(7));
				pro.setCategoryLevel3Id(rs.getInt(8));
				pro.setFileName(rs.getString(9));
				list.add(pro);
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
	public Product getProById(int id) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		 Product pro=new Product();
		String sql=" select * from easybuy_product where id="+id;	 
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){	 
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setDescription(rs.getString(3));
				pro.setPrice(rs.getFloat(4));
				pro.setStock(rs.getInt(5));
				pro.setCategoryLevel1Id(rs.getInt(6));
				pro.setCategoryLevel2Id(rs.getInt(7));
				pro.setCategoryLevel3Id(rs.getInt(8));
				pro.setFileName(rs.getString(9));	 
			}
			return pro;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, rs);
		}
		return null;
	}

	@Override
	public List<Product> getProBy(String level1, String level2, String level3,String pageNo,String pageSize) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		String sql=" select * from easybuy_product where 1=1";
		if(level1!=null){
			sql+=" and categoryLevel1Id="+level1;
		}
		if(level2!=null){
			sql+=" and  categoryLevel2Id="+level2;
		}
		if(level3!=null){
			sql+=" and  categoryLevel3Id="+level3;
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
				Product pro=new Product();
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setDescription(rs.getString(3));
				pro.setPrice(rs.getFloat(4));
				pro.setStock(rs.getInt(5));
				pro.setCategoryLevel1Id(rs.getInt(6));
				pro.setCategoryLevel2Id(rs.getInt(7));
				pro.setCategoryLevel3Id(rs.getInt(8));
				pro.setFileName(rs.getString(9));
				list.add(pro);
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
	public boolean delectProduct(int id) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		String sql="delete from easybuy_product where id="+id;
		try {
			pstmt=conn.prepareStatement(sql);
			int fanh=pstmt.executeUpdate();
			if(fanh>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, null);
		}
		return false;
	}

	@Override
	public boolean add(Product pro) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into easybuy_product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName) values(?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pro.getName());
			pstmt.setString(2, pro.getDescription());
			pstmt.setFloat(3, pro.getPrice());
			pstmt.setInt(4, pro.getStock());
			pstmt.setInt(5, pro.getCategoryLevel1Id());
			pstmt.setInt(6, pro.getCategoryLevel2Id());
			pstmt.setInt(7, pro.getCategoryLevel3Id());
			pstmt.setString(8, pro.getFileName());
			int fanh=pstmt.executeUpdate();
			if(fanh>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, null);
		}
		
		
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		String sql="update set easybuy_product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName) values(?,?,?,?,?,?,?,?) where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getDescription());
			pstmt.setFloat(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			pstmt.setInt(5, product.getCategoryLevel1Id());
			pstmt.setInt(6, product.getCategoryLevel2Id());
			pstmt.setInt(7, product.getCategoryLevel3Id());
			pstmt.setString(8, product.getFileName());
			pstmt.setInt(9, product.getId());
			int fanh=pstmt.executeUpdate();
			if(fanh>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, null);
		}
		
		return false;
	}

	 

}
