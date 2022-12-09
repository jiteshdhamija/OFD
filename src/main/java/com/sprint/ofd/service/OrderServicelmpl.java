package com.sprint.ofd.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.OrderDetails;
import com.sprint.ofd.exceptions.CartNotFoundException;
import com.sprint.ofd.exceptions.OrderNotFoundException;
import com.sprint.ofd.repository.ICartRepository;
import com.sprint.ofd.repository.IOrderRepository;


@Service
public class OrderServicelmpl implements IOrderService {
	
	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	ICartRepository cartRepo;
	
	private Logger logger= LogManager.getLogger();
	
	
	//add order in db
	@Override
	public OrderDetails addOrder(int cartId) {
		Optional<FoodCart> cart= cartRepo.findById(cartId);
		if(cart.isEmpty())
			throw new CartNotFoundException("Cart not found");
		FoodCart car=cart.get();
		OrderDetails order=new OrderDetails();
		order.setOrderDate(LocalDateTime.now());
		order.setCart(car);
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
	public String removeOrder(int order) {
		
		Optional<OrderDetails> details=orderRepo.findById(order);
		OrderDetails deta= null;
		
		if(details.isPresent()) {
			deta=details.get();
			orderRepo.delete(deta);
			logger.info("Order Removed");
			return "Order Deleted";
		}
		else
			throw new OrderNotFoundException("Order Not Found");
			
		
	}
	
	//view order based on OrderDetails
	@Override
	public OrderDetails viewOrder(int order) {
		Optional<OrderDetails> details=orderRepo.findById(order);
		OrderDetails deta=null;
		if(details.isPresent()) {
			deta=details.get();
			logger.info("Order found in db");
			return deta;
		}
		else
			throw new OrderNotFoundException("Order Not Found");
		
	}

	@Override
	public double viewTotalCost(Integer orderId) {
		Optional<OrderDetails> opt=orderRepo.findById(orderId);
		if(opt.isEmpty())
			throw new OrderNotFoundException("Order Not Found");
		OrderDetails order=opt.get();
		double totalCost=0;
		for(Item item:order.getCart().getItemList()) {
			totalCost+=item.getCost();
		}
		return totalCost;
			
	}
	
	
	

}
