package com.sprint.ofd.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Bill;
import com.sprint.ofd.entity.Customer;

@Service
public interface IBillService {

	public Bill addBill(Bill bill);
	public Bill updateBill(Bill bill);
	public Bill removeBill(Bill bill);
	public Bill viewBill(Bill bill);
	public List<Bill> viewBills(LocalDate startDate,LocalDate endDate);
	public List<Bill> viewBills(Customer customer);
}
