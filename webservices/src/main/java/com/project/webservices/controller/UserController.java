package com.project.webservices.controller;

import com.project.webservices.dto.UserDto;
import com.project.webservices.exception.ErrorDetails;
import com.project.webservices.exception.ResourceNotFoundException;
import com.project.webservices.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for User resource",
        description = "Operations: create, update, get user, get all user and delete user"
)
public class UserController {

    private UserService userService;

    /**
     * Create user entity.
     *
     * @return the response entity of user
     */
    @Operation(
            summary = "create user REST API",
            description = "This API is used to save a user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

    /**
     * Update user existing entity.
     *
     * @return the response user entity
     */
    @Operation(
            summary = "update user REST API",
            description = "This API is used to update or save a user in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 201 OK"
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto){
        userDto.setId(id);
        return new ResponseEntity<>(userService.update(userDto), HttpStatus.OK);
    }

    /**
     * Get user entity by id.
     *
     * @param id the id
     * @return the user response entity
     */
    @Operation(
            summary = "get user by id REST API",
            description = "This API is used to get a user by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    /**
     * Get all user entities.
     *
     * @return the response user entities
     */
    @Operation(
            summary = "get all users REST API",
            description = "This API is used to fetch all users0from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getById(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    /**
     * Delete user entity.
     *
     * @param id the id
     * @return the response "user deleted"
     */
    @Operation(
            summary = "delete user by id REST API",
            description = "This API is used to delete a user by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
