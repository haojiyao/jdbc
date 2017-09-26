package dao;

import java.util.List;

import entity.OrderDetail;

public interface OrderDetailDao {
	/**
	 * 查订单详情
	 * @param id
	 * @return
	 */
	public List<OrderDetail> getOrderDetails(int id);
}
