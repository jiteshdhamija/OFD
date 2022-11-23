package com.sprint.ofd.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Bill;
import com.sprint.ofd.entity.Customer;

@Repository
public interface IBillRepository extends JpaRepository<Bill,Integer>{

	
	//find all bills mapped to customer
	public List<Bill> findByCustomer(Customer customer);
	
}
