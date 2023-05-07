package com.example.EmployeeAddress.Mapping.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Tbl_Address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer addressId;
    private String city;
    private String state;
    private String zipcode;


}
