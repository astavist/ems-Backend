package com.astavist.ems.api.controllers;

import com.astavist.ems.business.abstracts.EmployeeService;
import com.astavist.ems.business.dto.requests.CreateEmployeesRequest;
import com.astavist.ems.business.dto.requests.UpdateEmployeesRequest;
import com.astavist.ems.business.dto.responses.CreateEmployeesResponse;
import com.astavist.ems.business.dto.responses.GetAllEmployeesResponse;
import com.astavist.ems.business.dto.responses.GetEmployesResponse;
import com.astavist.ems.business.dto.responses.UpdateEmployeesResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public List<GetAllEmployeesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetEmployesResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeesResponse add(@Valid @RequestBody CreateEmployeesRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateEmployeesResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateEmployeesRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
