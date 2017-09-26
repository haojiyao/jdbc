package service.impl;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.OrderDao;
import dao.OrderDetailDao;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderDatailDaoImpl;

import entity.Order;
import entity.OrderDetail;
import service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao=new OrderDaoImpl();
	private OrderDetailDao detailDao=new OrderDatailDaoImpl();
	
	@Override
	public List<Order> getOrder(String loginName, String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		List<Order> orders=orderDao.getOrder(loginName, pageNo, pageSize);
		for (Order order :orders) {
			order.setOrderDetailList(detailDao.getOrderDetails(order.getId()));
		}

		return orders;
	}
	@Override
	public List<Order> getquan(String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		List<Order> orders=orderDao.getquan(pageNo, pageSize);
		for (Order order :orders) {
			order.setOrderDetailList(detailDao.getOrderDetails(order.getId()));
		}

		return orders;
	}

}
