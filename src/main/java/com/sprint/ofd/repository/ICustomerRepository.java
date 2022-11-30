package com.sprint.ofd.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByFirstName(String name);

}