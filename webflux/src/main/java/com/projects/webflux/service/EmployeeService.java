package com.projects.webflux.service;

import com.projects.webflux.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
    Mono<EmployeeDto> getEmployee(String id);
    Flux<EmployeeDto> getAllEmployees();
    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String id);
    Mono<Void> deleteEmployee(String id);
}
