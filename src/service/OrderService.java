package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	public List<Order> getOrder(String loginName,String pageNo,String pageSize);
	public List<Order> getquan(String pageNo,String pageSize);

}
