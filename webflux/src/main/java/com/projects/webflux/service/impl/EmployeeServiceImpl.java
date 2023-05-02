package com.projects.webflux.service.impl;

import com.projects.webflux.dto.EmployeeDto;
import com.projects.webflux.entity.Employee;
import com.projects.webflux.mapper.EmployeeMapper;
import com.projects.webflux.repository.EmployeeRepository;
import com.projects.webflux.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee
                .map(
                        (em) -> EmployeeMapper.mapToEmployeeDto(em)
                );
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String id) {
        Mono<Employee> employee = employeeRepository.findById(id);
        return employee
                .map(
                        (em) -> EmployeeMapper.mapToEmployeeDto(em)
                );
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employees = employeeRepository.findAll();
        return employees
                .map(
                        (employee) -> EmployeeMapper.mapToEmployeeDto(employee)
                )
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String id) {
        Mono<Employee> employeeMono = employeeRepository.findById(id);
        Mono<Employee> updateEmployee = employeeMono.flatMap(
                employee -> {
                    employee.setId(employeeDto.getId());
                    employee.setFirstName(employeeDto.getFirstName());
                    employee.setLastName(employeeDto.getLastName());
                    employee.setEmail(employeeDto.getEmail());
                    return employeeRepository.save(employee);
                }
        );
        return updateEmployee
                .map(
                        employee -> EmployeeMapper.mapToEmployeeDto(employee)
                );
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);
    }
}
