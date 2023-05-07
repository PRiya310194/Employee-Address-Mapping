package com.example.EmployeeAddress.Mapping.service;

import com.example.EmployeeAddress.Mapping.dao.AddressRepository;
import com.example.EmployeeAddress.Mapping.model.Address;
import com.example.EmployeeAddress.Mapping.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Integer saveAddress(Address address) {
        Address addressData=addressRepository.save(address);
        return address.getAddressId();

    }

    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    public String findAddById(Integer addressId) {
        if(addressRepository.findById(addressId).isPresent()){
            Address address=addressRepository.findById(addressId).get();
            return address.toString();
        }
        else{
            return "please enter valid addressId";
        }
    }

    public void deleteAddressById(Integer addressId) {
        addressRepository.deleteById(addressId);
    }

    public Address updateAddress(Integer addressId, Address address) {
    Address addData=addressRepository.findById(addressId).get();
             addData.setCity(address.getCity());
             addData.setState(address.getState());
             addData.setZipcode(address.getZipcode());
             return addData;
}
}

