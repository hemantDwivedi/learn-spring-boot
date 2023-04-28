//package com.project.todo.controller;
//
//import com.project.todo.dto.TodoDto;
//import com.project.todo.entity.Todo;
//import com.project.todo.service.TodoService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class TodoControllerTest {
//    @Autowired
//    private TodoService todoService;
//
//    @Test
//    void addTodoTest(){
//        TodoDto todoDto = new TodoDto(
//                2L,
//                "spring security",
//                "spring security lecture class at 2 o clock",
//                true
//        );
//        todoService.addTodo(todoDto);
//    }
//
//    @Test
//    void updateTodoTest(){
//        TodoDto todoDto = new TodoDto(
//                1L,
//                "spring lecture 3",
//                "spring boot lecture class at 8 o clock",
//                true
//        );
//        todoService.updateTodo(todoDto, 1L);
//    }
//
//    @Test
//    void getTodoTest(){
//        TodoDto todo = todoService.getTodo(1L);
//        System.out.println(todo.getTitle());
//    }
//
//    @Test
//    void getTodosTest(){
//        List<TodoDto> todos = todoService.getTodos();
//        System.out.println(todos);
//    }
//
//    @Test
//    void deleteTodoTest(){
//        todoService.deleteTodo(1L);
//    }
//}