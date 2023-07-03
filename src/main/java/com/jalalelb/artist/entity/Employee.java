package com.jalalelb.artist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String lastName;
    private String firstName;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reports_to")
    private  Employee reportsTo;
    private LocalDate birthDay;
    private LocalDate hireDate;
    private String address;
    private String Date;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;

}
