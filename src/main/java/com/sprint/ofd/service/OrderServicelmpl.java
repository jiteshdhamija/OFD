package com.sprint.ofd.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.OrderDetails;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.exceptions.OrderNotFoundException;
import com.sprint.ofd.repository.IOrderRepository;


@Service
public class OrderServicelmpl implements IOrderService {
	
	@Autowired
	IOrderRepository orderRepo;
	
	private Logger logger= LogManager.getLogger();
	
	
	//add order in db
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		OrderDetails details=orderRepo.save(order);
		logger.info("order added successfully");
		return details;
	}
	
	//update order 
	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		Optional<OrderDetails> details=orderRepo.findById(order.getOrderId());
		OrderDetails deta =null;
		if(details.isPresent()) {
			deta=details.get();
			orderRepo.save(deta);
			logger.info("Order Updated");
		}
		else 
			throw new OrderNotFoundException("Order Not Found");
		
		return deta;
	}
	
	//remove order on orderDetails
	@Override
	public OrderDetails removeOrder(OrderDetails order) {
		
		Optional<OrderDetails> details=orderRepo.findById(order.getOrderId());
		OrderDetails deta= null;
		
		if(details.isPresent()) {
			deta=details.get();
			orderRepo.delete(deta);
			logger.info("Order Removed");
		}
		else
			throw new OrderNotFoundException("Order Not Found");
			
		return deta;
	}
	
	//view order based on OrderDetails
	@Override
	public OrderDetails viewOrder(OrderDetails order) {
		Optional<OrderDetails> details=orderRepo.findById(order.getOrderId());
		OrderDetails deta=null;
		if(details.isPresent()) {
			deta=details.get();
			logger.info("Order found in db");
		}
		else
			throw new OrderNotFoundException("Order Not Found");
		return deta;
	}
	
	
	//view all orders from a restaurant
	@Override
	public List<OrderDetails> viewAllOrders(Restaurant resName) {
		
		List<OrderDetails> listOrder=orderRepo.findAll();
		logger.info("Orders Retrieved from db");
		return listOrder;
	}
	
	//view all orders placed by a customer
	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) {
		List<OrderDetails> listOrder=orderRepo.findAll();
		logger.info("Orders Retrieved from db");

		return listOrder;
	}

}
