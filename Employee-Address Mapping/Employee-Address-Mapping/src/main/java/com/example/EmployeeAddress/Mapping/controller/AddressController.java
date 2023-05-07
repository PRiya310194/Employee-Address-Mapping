package com.example.EmployeeAddress.Mapping.controller;

import com.example.EmployeeAddress.Mapping.dao.AddressRepository;
import com.example.EmployeeAddress.Mapping.model.Address;
import com.example.EmployeeAddress.Mapping.model.Employee;
import com.example.EmployeeAddress.Mapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
@PostMapping(value="/saveAddress")
    public ResponseEntity<String>saveAddress(@RequestBody Address address){
        Integer addressId=addressService.saveAddress(address);
        return new ResponseEntity<>("address saved with id ->"+addressId, HttpStatus.CREATED);
    }
    @GetMapping(value="/findAllAdd")
    public ResponseEntity<List<Address>>FindAllAdd(){
        List<Address>addList=addressService.findAllAddress();
        return new ResponseEntity<>(addList,HttpStatus.FOUND);

    }
    @GetMapping(value="/findById/{addressId}")
    public ResponseEntity<String>findAddById(@PathVariable Integer addressId){
        if(addressId!=null){
            String address=addressService.findAddById(addressId);
            return new ResponseEntity<>(address,HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>("please enter valid id ",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value="/deleteAdd/{addressId}")
    public void deleteAddById(@PathVariable Integer addressId){
        addressService.deleteAddressById(addressId);
    }
    @PutMapping(value="/updateAdd/{addressId}")
    public ResponseEntity<String>updateEmployee(@PathVariable Integer addressId,@RequestBody Address address){
        Address ans=addressService.updateAddress(addressId,address);
        if(addressId!=null){
            return new ResponseEntity<>("Employee updated successfully"+address,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("please enter valid addressId",HttpStatus.BAD_REQUEST);
        }
    }
}



