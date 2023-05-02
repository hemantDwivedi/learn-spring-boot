package com.projects.webflux.controller;

import com.projects.webflux.dto.EmployeeDto;
import com.projects.webflux.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // Reactive REST API for save employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);
    }

    // Reactive REST API for GET Employee
    @GetMapping("/{id}")
    public Mono<EmployeeDto> getEmployee(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    // Reactive REST API for GET all employees
    @GetMapping
    public Flux<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // Reactive REST API for update employee
    @PutMapping("{id}")
    public Mono<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable String id){
        return employeeService.updateEmployee(employeeDto, id);
    }

    // Reactive REST API for delete employee
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }
}
