package com.astavist.ems.business.concretes;

import com.astavist.ems.business.abstracts.EmployeeService;
import com.astavist.ems.business.dto.requests.CreateEmployeesRequest;
import com.astavist.ems.business.dto.requests.UpdateEmployeesRequest;
import com.astavist.ems.business.dto.responses.CreateEmployeesResponse;
import com.astavist.ems.business.dto.responses.GetAllEmployeesResponse;
import com.astavist.ems.business.dto.responses.GetEmployesResponse;
import com.astavist.ems.business.dto.responses.UpdateEmployeesResponse;
import com.astavist.ems.entity.Employee;
import com.astavist.ems.repository.EmployeeRepository;
import com.netflix.discovery.provider.Serializer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<GetAllEmployeesResponse> getAll() {
        List<Employee> employees = repository.findAll();
        List<GetAllEmployeesResponse> response = employees
                .stream()
                .map(employee -> mapper.map(employee, GetAllEmployeesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetEmployesResponse getById(UUID id) {
        Employee employee = repository.findById(id).orElseThrow();
        GetEmployesResponse response = mapper.map(employee,GetEmployesResponse.class);
        return response;
    }

    @Override
    public CreateEmployeesResponse add(CreateEmployeesRequest request) {
        Employee employee = mapper.map(request,Employee.class);
        employee.setEmployeeID(UUID.randomUUID());
        repository.save(employee);
        CreateEmployeesResponse response = mapper.map(employee,CreateEmployeesResponse.class);
        return response;
    }

    @Override
    public UpdateEmployeesResponse update(UUID id, UpdateEmployeesRequest request) {
        Employee employee = mapper.map(request,Employee.class);
        employee.setEmployeeID(request.getEmployeeID());
        repository.save(employee);
        UpdateEmployeesResponse response = mapper.map(employee,UpdateEmployeesResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
