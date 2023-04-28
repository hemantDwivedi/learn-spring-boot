package com.project.webservices.service.impl;

import com.project.webservices.dto.UserDto;
import com.project.webservices.entity.User;
import com.project.webservices.exception.EmailAlreadyExistsException;
import com.project.webservices.exception.ErrorDetails;
import com.project.webservices.exception.ResourceNotFoundException;
import com.project.webservices.mapper.AutoMapper;
import com.project.webservices.mapper.UserMapper;
import com.project.webservices.repository.UserRepository;
import com.project.webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private ModelMapper modelMapper;
    @Override
    public UserDto create(UserDto userDto) {
        //        User user = UserMapper.mapToUser(userDto);
        //        User savedUser = userRepository.save(user);
        //        return UserMapper.mapToUserDto(savedUser);
        //        User user = modelMapper.map(userDto, User.class);
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user = AutoMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        //        return modelMapper.map(savedUser, UserDto.class);
        return AutoMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)
        );
        // return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", userDto.getId())
        );
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        userRepository.save(existingUser);
        // return UserMapper.mapToUserDto(existingUser);
        return modelMapper.map(existingUser, UserDto.class);
    }

    @Override
    public void delete(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)
        );
        userRepository.deleteById(id);
    }
}
