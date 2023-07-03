package com.jalalelb.artist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "support_rep_id")
    private Employee employee;

}
