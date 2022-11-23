package com.sprint.ofd.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Bill;
import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.exceptions.BillNotFoundException;
import com.sprint.ofd.repository.IBillRepository;

@Service
public class BillServiceImpl implements IBillService {
	
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	IBillRepository billRepo;
	
	//adding bill to db
	@Override
	public Bill addBill(Bill bill) {
		
		Bill billl=billRepo.save(bill);
		return billl;
		
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
	public Bill removeBill(Bill bill) {
		Optional<Bill> bil= billRepo.findById(bill.getBillId());
		logger.info("Sending Request to repository to find by id");
		Bill billl=null;
		if(bil.isPresent()) {
			billl=bil.get();
			billRepo.delete(billl);
			logger.info("bill deleted");
		}
		else
			throw new BillNotFoundException("Bill Not Found");
		return bill;
	}
	
	
	//Retrieving bill from db  
	@Override
	public Bill viewBill(Bill bill) {
		Optional<Bill> bil=billRepo.findById(bill.getBillId());
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
