package com.example.EmployeeAddress.Mapping.model;


import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@Entity
@Table(name="Tbl_employee")

public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer employeeId;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name="addressId")
    private Address address;
}
