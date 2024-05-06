package com.astavist.ems.repository;

import com.astavist.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
