package com.sprint.ofd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.ofd.entity.Address;

public interface IAddressRepository extends JpaRepository<Address,Integer> {

}
