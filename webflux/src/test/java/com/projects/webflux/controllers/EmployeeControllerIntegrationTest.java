package com.projects.webflux.controllers;

import com.projects.webflux.dto.EmployeeDto;
import com.projects.webflux.repository.EmployeeRepository;
import com.projects.webflux.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private EmployeeRepository employeeRepository;
    @BeforeEach
    public void before(){
        System.out.println("Before each test");
        employeeRepository.deleteAll().subscribe();
    }
    @Test
    void saveEmployeeTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Employee");
        employeeDto.setLastName("1");
        employeeDto.setEmail("employee1@gmail.com");
        webTestClient.post().uri("/api/employees").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(employeeDto), EmployeeDto.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(employeeDto.getEmail());
    }

    @Test
    void getSingleEmployeeTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Employee");
        employeeDto.setLastName("4");
        employeeDto.setEmail("employee4@gmail.com");
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();
        webTestClient
                .get()
                .uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.id").isEqualTo(savedEmployee.getId())
                .jsonPath("$.firstName").isEqualTo(savedEmployee.getFirstName())
                .jsonPath("$.lastName").isEqualTo(savedEmployee.getLastName())
                .jsonPath("$.email").isEqualTo(savedEmployee.getEmail());
    }

    @Test
    void getAllEmployeeTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Employee");
        employeeDto.setLastName("3");
        employeeDto.setEmail("employee3@gmail.com");
        employeeService.saveEmployee(employeeDto).block();
        EmployeeDto employee1 = new EmployeeDto();
        employee1.setFirstName("Employee");
        employee1.setLastName("2");
        employee1.setEmail("employee2@gmail.com");
        employeeService.saveEmployee(employee1).block();
        webTestClient.get()
                .uri("/api/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(EmployeeDto.class)
                .consumeWith(System.out::println);
    }

    @Test
    void updateEmployeeTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Employee");
        employeeDto.setLastName("100");
        employeeDto.setEmail("employee001@gmail.com");

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        EmployeeDto updatedEmployee = new EmployeeDto();
        updatedEmployee.setFirstName("Employee");
        updatedEmployee.setLastName("200");
        updatedEmployee.setEmail("employee200@gmail.com");

        webTestClient.put()
                .uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedEmployee), EmployeeDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(updatedEmployee.getFirstName())
                .jsonPath("$.lastName").isEqualTo(updatedEmployee.getLastName())
                .jsonPath("$.email").isEqualTo(updatedEmployee.getEmail());
    }

    @Test
    void testDeleteEmployee(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Employee");
        employeeDto.setLastName("1");
        employeeDto.setEmail("employee1@gmail.com");
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        webTestClient.delete().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .exchange()
                .expectStatus().isNoContent()
                .expectBody()
                .consumeWith(System.out::println);
    }
}