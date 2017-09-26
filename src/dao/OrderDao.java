package dao;

import java.util.List;

import entity.Order;

public interface OrderDao {
	
	public List<Order> getOrder(String loginName,String pageNo,String pageSize);
	
	public List<Order> getquan(String pageNo,String pageSize);

	
}
