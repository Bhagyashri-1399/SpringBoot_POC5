package com.neosoft.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "neo_user")
// Causes Lombok to generate toString(), equals(), hashCode(), getter() & setter(), and Required arguments constructor in one go.
@Data
// Causes Lombok to implement the Builder design pattern for the Pojo class.
// Usage can be seen in DefaultResidentsLoader.java -> createNewResident() method.
@Builder
// Causes Lombok to generate a constructor with no parameters.
@NoArgsConstructor
// Causes Lombok to generate a constructor with 1 parameter for each field in your class.
@AllArgsConstructor
@Component
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "firstName", nullable = false)
    String FirstName;
    @Column(name = "lastName", nullable = false)
    String LastName;
    @Column(name = "contact", nullable = false)
    Long contact;
    @Column(name = "email_address", nullable = false, unique = true)
    String email;
    @Column(name = "City")
    String city;
    @Column(name = "Country")
    String country;
   
 
}