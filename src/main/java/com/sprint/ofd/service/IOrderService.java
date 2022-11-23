package com.sprint.ofd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.OrderDetails;
import com.sprint.ofd.entity.Restaurant;


@Service
public interface IOrderService {

	public OrderDetails addOrder(OrderDetails order);
	public OrderDetails updateOrder(OrderDetails order);
	public OrderDetails removeOrder(OrderDetails order);
	public OrderDetails viewOrder(OrderDetails order);
	public List<OrderDetails> viewAllOrders(Restaurant resName);
	public List<OrderDetails> viewAllOrders(Customer customer);
}
