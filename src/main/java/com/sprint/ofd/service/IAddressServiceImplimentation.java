package com.sprint.ofd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Address;
import com.sprint.ofd.exceptions.AddressNotFoundException;
import com.sprint.ofd.repository.IAddressRepository;

@Service
public class IAddressServiceImplimentation implements IAddressService{

	@Autowired 
	IAddressRepository adRepo;
	
	@Override
	public Address addAddress(Address add) {
		Address output=adRepo.save(add);
		return output;
	}

	@Override
	public Address updateAddress(Address add) {
		int id=add.getAddressId();
		Optional<Address> ad=adRepo.findById(id);
		Address address=new Address();
		if(ad.isPresent()) {
			address=ad.get();
			adRepo.delete(add);
			adRepo.save(address);
			return address;
		}
		else
			throw new AddressNotFoundException("Address Not Found");
	}

	@Override
	public List<Address> viewAll() {
		List<Address> list=adRepo.findAll();
		if(list.isEmpty())
			throw new AddressNotFoundException("No Adresses Found");
		return list;
	}

	@Override
	public Address viewById(int adId) {
		Optional<Address> opt=adRepo.findById(adId);
		Address address=new Address();
		if(opt.isPresent()) {
			address=opt.get();
			return address;
		}
		else
			throw new AddressNotFoundException("Adresses Not Found By given Id");
			
	}

	@Override
	public Address removeAddress(int adId) {
		Optional<Address> opt= adRepo.findById(adId);
		if(opt.isEmpty())
			throw new AddressNotFoundException("No Adresses Found");
		else
		{
			Address ad=new Address();
			ad=opt.get();
			adRepo.delete(ad);
			return ad;
		}
	}
		
	
}
