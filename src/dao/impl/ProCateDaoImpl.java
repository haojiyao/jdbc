package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ProductCategoryDao;
import entity.ProductCategory;

public class ProCateDaoImpl extends BaseDao implements ProductCategoryDao{

	@Override
	public List<ProductCategory> getProductCategory(int parentId, int type) {
		// TODO Auto-generated method stub
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductCategory> list=new ArrayList<ProductCategory>();
		String sql=" select * from easybuy_product_category where 1=1";
		if(parentId!=0){
			sql+=" and parentId="+parentId;
		}
		if(type!=0){
			sql+=" and  type="+type;
		}
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ProductCategory pro=new ProductCategory();
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setParentId(rs.getInt(3));
				pro.setType(rs.getInt(4));
				pro.setIconClass(rs.getString(5));//图片路径
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
	public boolean add(ProductCategory procate) {
		// TODO Auto-generated method stub
	
		return false;
	}

	@Override
	public boolean update(ProductCategory procate) {
		// TODO Auto-generated method stub
		return false;
	}

}
