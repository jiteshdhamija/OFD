package com.sprint.ofd.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Bill;
import com.sprint.ofd.entity.Customer;


public interface IBillService {

	public Bill addBill(int orderId);
	public Bill updateBill(Bill bill);
	public String removeBill(int billId);
	public Bill viewBill(int billId);
	public List<Bill> viewBills(LocalDate startDate,LocalDate endDate);
	public List<Bill> viewBills(Customer customer);
}
