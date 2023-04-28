package com.project.todo.service;

import com.project.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
    List<TodoDto> getTodos();
    void deleteTodo(Long id);
    TodoDto updateTodo(TodoDto todoDto, Long id);
    TodoDto completeTodo(Long id);
    TodoDto inCompleteTodo(Long id);
}
