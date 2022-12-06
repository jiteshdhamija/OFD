package com.sprint.ofd.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.OrderDetails;
import com.sprint.ofd.entity.Restaurant;



public interface IOrderService {

	public OrderDetails addOrder(int cartId);
	public OrderDetails updateOrder(OrderDetails order);
	public String removeOrder(int order);
	public OrderDetails viewOrder(int order);
}
