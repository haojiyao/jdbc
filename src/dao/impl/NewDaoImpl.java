package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.NewDao;
import entity.News;
import entity.ProductCategory;

public class NewDaoImpl extends BaseDao implements NewDao {

	@Override
	public List<News> getNewsByTop5() {
		// TODO Auto-generated method stub
		//1.创建数据库链接
		Connection conn=getConnection();	
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<News> list=new ArrayList<News>();
		//2.sql语句
		String sql=" select * from easybuy_news order by createTime desc limit 0,5";		 
		try {
			//3.执行sql语句
			pstmt=conn.prepareStatement(sql);
			//4.得到结果
			rs=pstmt.executeQuery();
			//5.把结果从resultset中拿出来，放到list集合中
			while(rs.next()){
				News news=new News();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setContent(rs.getString(3));
				news.setCreateTime(rs.getDate(4));
				list.add(news);
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
	public List<News> getNews(String pageNo,String pageSize) {
		// TODO Auto-generated method stub
		//1.创建数据库链接
				Connection conn=getConnection();	
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				List<News> list=new ArrayList<News>();
				//2.sql语句
				String sql=" select * from easybuy_news ";	
				
				if(pageNo!=null&&pageSize!=null){
					int no=Integer.parseInt(pageNo);
					int size=Integer.parseInt(pageSize);
					sql+=" limit "+(no-1)*size+","+size+"";
				}
				try {
					//3.执行sql语句
					pstmt=conn.prepareStatement(sql);
					//4.得到结果
					rs=pstmt.executeQuery();
					//5.把结果从resultset中拿出来，放到list集合中
					while(rs.next()){
						News news=new News();
						news.setId(rs.getInt(1));
						news.setTitle(rs.getString(2));
						news.setContent(rs.getString(3));
						news.setCreateTime(rs.getDate(4));
						list.add(news);
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
