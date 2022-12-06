package com.sprint.ofd.service;

import java.util.List;

import com.sprint.ofd.entity.Address;

public interface IAddressService {
	public Address addAddress(Address add);
	public Address updateAddress(Address add);
	public List<Address> viewAll();
	public Address viewById(int adId);
	public Address removeAddress(int adId);
}
