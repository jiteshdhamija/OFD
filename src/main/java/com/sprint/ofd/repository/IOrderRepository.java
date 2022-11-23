package com.sprint.ofd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.OrderDetails;
import com.sprint.ofd.entity.Restaurant;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails,Integer> {

		
}
