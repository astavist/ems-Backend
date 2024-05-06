package com.astavist.ems.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEmployeesResponse {
    private UUID employeeID;
    private String name;
    private String mail;
    private int salary;
}


