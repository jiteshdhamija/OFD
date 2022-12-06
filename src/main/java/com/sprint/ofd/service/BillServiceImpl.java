package com.sprint.ofd.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Bill;
import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.OrderDetails;
import com.sprint.ofd.exceptions.BillNotFoundException;
import com.sprint.ofd.exceptions.OrderNotFoundException;
import com.sprint.ofd.repository.IBillRepository;
import com.sprint.ofd.repository.IOrderRepository;

@Service
public class BillServiceImpl implements IBillService {
	
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	IBillRepository billRepo;
	@Autowired
	IOrderRepository orderRepo;
	
	//adding bill to db
	@Override
	public Bill addBill(int orderId) {
		Optional<OrderDetails> opt= orderRepo.findById(orderId);
		if(opt.isEmpty())
			throw new OrderNotFoundException("Order Not found");
		OrderDetails order=opt.get();
		Bill bill=new Bill();
		bill.setBillDate(order.getOrderDate().toLocalDate());
		bill.setOrder(order);
		bill.setTotalCost(this.totalCost(orderId));
		bill.setTotalItem(this.totalItem(orderId));
		Bill billl=billRepo.save(bill);
		return billl;
		
	}
	
	private int totalItem(int orderId) {
		Optional<OrderDetails> opt= orderRepo.findById(orderId);
		if(opt.isEmpty())
			throw new OrderNotFoundException("Order Not found");
		OrderDetails order=opt.get();
		FoodCart cart=order.getCart();
		List<Item> listItem=cart.getItemList();
		int totalItem=0;
		for(Item i:listItem) {
			totalItem+=1;
		}
		return totalItem;
	}

	private @NotNull double totalCost(int orderId) {
		Optional<OrderDetails> opt= orderRepo.findById(orderId);
		if(opt.isEmpty())
			throw new OrderNotFoundException("Order Not found");
		OrderDetails order=opt.get();
		FoodCart cart=order.getCart();
		List<Item> listItem=cart.getItemList();
		double totalCost=0;
		for(Item i:listItem) {
			totalCost+=i.getCost();
		}
		return totalCost;
	}

	//updating bill in db
	@Override
	public Bill updateBill(Bill bill) {
		Optional<Bill> bil=billRepo.findById(bill.getBillId());
		logger.info("Sending request to repo to find by ID");
		Bill billl=null;
		if(bil.isPresent())
			{billl=bil.get();
			logger.info("Got Bill By ID");}
		else	
			throw new BillNotFoundException("Bill Not Found");
		
		return billl;
	}
	
	
	//removing bill from db
	@Override
	public String removeBill(int billId) {
		Optional<Bill> bil= billRepo.findById(billId);
		logger.info("Sending Request to repository to find by id");
		Bill bill=null;
		if(bil.isPresent()) {
			bill=bil.get();
			billRepo.delete(bill);
			logger.info("bill deleted");
			return "Bill Deleted Successfully";
		}
		else
			throw new BillNotFoundException("Bill Not Found");
		
	}
	
	
	//Retrieving bill from db  
	@Override
	public Bill viewBill(int billId) {
		Optional<Bill> bil=billRepo.findById(billId);
		Bill billl=null;
		logger.info("Sending request to repository to find by id");
		if(bil.isPresent()) {
			billl=bil.get();
			logger.info("bill found");
		}
		else
			throw new BillNotFoundException("Bill Not Found");
		return billl;
	}
	
	
	//retrieving all bills from db that are in b/w startDate and endDate
	@Override
	public List<Bill> viewBills(LocalDate startDate,LocalDate endDate) {
		List<Bill> bil=billRepo.findAll();
		
		List<Bill> billl=null;
		for(Bill b:bil) {
			if((b.getBillDate().isAfter(startDate)&&b.getBillDate().isBefore(endDate))||b.getBillDate().isEqual(endDate)||b.getBillDate().isEqual(startDate))
				{	billl.add(b);
					
				}	
		}
		return billl;
	
	}
	
	//View all bills mapped to customer
	@Override
	public List<Bill> viewBills(Customer customer) {
		List<Bill> bil=billRepo.findByCustomer(customer);
		
		return bil;
	}

}
