package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
  @Id
  //@GeneratedValue
  private Long id;
  private String name;
  private String dept;
  private int salary;
    
}