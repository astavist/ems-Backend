package com.astavist.ems.business.abstracts;

import com.astavist.ems.business.dto.requests.CreateEmployeesRequest;
import com.astavist.ems.business.dto.requests.UpdateEmployeesRequest;
import com.astavist.ems.business.dto.responses.CreateEmployeesResponse;
import com.astavist.ems.business.dto.responses.GetAllEmployeesResponse;
import com.astavist.ems.business.dto.responses.GetEmployesResponse;
import com.astavist.ems.business.dto.responses.UpdateEmployeesResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<GetAllEmployeesResponse> getAll();

    GetEmployesResponse getById(UUID id);

    CreateEmployeesResponse add(CreateEmployeesRequest request);

    UpdateEmployeesResponse update(UUID id, UpdateEmployeesRequest request);

    void delete(UUID id);
}
