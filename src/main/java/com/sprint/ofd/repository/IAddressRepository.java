package com.sprint.ofd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer> {

}
