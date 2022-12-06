package com.sprint.ofd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.Address;
import com.sprint.ofd.repository.IAddressRepository;
import com.sprint.ofd.service.IAddressService;

@RestController
public class AddressController {
	@Autowired
	IAddressService adServ;
	
	@PostMapping("/address/add/")
	ResponseEntity<Address> addAddress(Address add){
		Address address=adServ.addAddress(add);
		ResponseEntity<Address> response= new ResponseEntity<>(address,HttpStatus.OK);
		return response;
	}
	@PutMapping("/address/update/{add}/")
	ResponseEntity<Address> updateAddress(@PathVariable Address add){
		Address address=adServ.updateAddress(add);
		ResponseEntity<Address> response= new ResponseEntity<>(address,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/address/view/all/")
	ResponseEntity<List<Address>> viewAllAddress(){
		List<Address> address=adServ.viewAll();
		ResponseEntity<List<Address>> response= new ResponseEntity<>(address,HttpStatus.OK);
		return response;
	}
	@GetMapping("/address/view/id/{id}/")
	ResponseEntity<Address> viewById(@PathVariable int id){
		Address address=adServ.viewById(id);
		ResponseEntity<Address> response= new ResponseEntity<>(address,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/address/remove/{addId}")
	ResponseEntity<Address> DeleteAddress(@PathVariable int addId){
		Address address=adServ.removeAddress(addId);
		ResponseEntity<Address> response= new ResponseEntity<>(address,HttpStatus.OK);
		return response;
	}

}
