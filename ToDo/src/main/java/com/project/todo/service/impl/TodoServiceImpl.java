package com.project.todo.service.impl;

import com.project.todo.dto.TodoDto;
import com.project.todo.entity.Todo;
import com.project.todo.exception.ResourceNotFoundException;
import com.project.todo.repository.TodoRepository;
import com.project.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // convert TodoDto into Todo Jpa entity
//         Todo todo = new Todo();
//         todo.setTitle(todoDto.getTitle());
//         todo.setDescription(todoDto.getDescription());
//         todo.setCompleted(todoDto.isCompleted());

        Todo todo = modelMapper.map(todoDto, Todo.class);

        // save Todo Jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // convert TodoDto into Todo Jpa entity
//        TodoDto savedTodoDto = new TodoDto();
//        savedTodoDto.setTitle(todoDto.getTitle());
//        savedTodoDto.setDescription(todoDto.getDescription());
//        savedTodoDto.setCompleted(todoDto.isCompleted());
        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Todo not found with id : " + id)
                );
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos
                .stream()
                .map(
                        todo -> modelMapper.map(todo, TodoDto.class)
                ).collect(Collectors.toList());
    }

    @Override
    public void deleteTodo(Long id) {
        // todoRepository.deleteById(id);
        Todo todo = todoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Todo not found with id : " + id)
                );
        todoRepository.delete(todo);
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Todo not found with id : " + id)
                );
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        todoRepository.save(todo);
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Todo not found with id : " + id)
                );
        todo.setCompleted(Boolean.TRUE);
        todoRepository.save(todo);
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Todo not found with id : " + id)
                );
        todo.setCompleted(Boolean.FALSE);
        todoRepository.save(todo);
        return modelMapper.map(todo, TodoDto.class);
    }
}
