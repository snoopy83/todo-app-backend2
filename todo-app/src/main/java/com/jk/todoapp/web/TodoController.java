package com.jk.todoapp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jk.todoapp.domain.TodoItem;
import com.jk.todoapp.domain.TodoList;
import com.jk.todoapp.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
	
	@Autowired
	private TodoService todoServcie;
	
//	@GetMapping("/api/todoItems")
//	public ResponseEntity<?> fetchAllTodoItems(){
//		
//		List<TodoItem> todoItems = todoServcie.fetchAllTodoItems();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(todoItems);
//	}
	
	@PutMapping("/api/todoItems/{listId}/{itemId}")
	public ResponseEntity<?> updateTodoItem(@PathVariable Integer listId,@PathVariable Integer itemId, @RequestBody TodoItem todoItem){
		
		TodoItem udpatedTodoItem = todoServcie.updateTodoItem(listId, itemId, todoItem);
		
		return ResponseEntity.status(HttpStatus.OK).body(udpatedTodoItem);
	}
	
	@PostMapping("/api/todoItems/{listId}")
	public ResponseEntity<?> createNewTodoItems(@PathVariable Integer listId){
		
		TodoItem todoItem = todoServcie.createTodoItem(listId);

		return ResponseEntity.status(HttpStatus.OK).body(todoItem);
	}
	
	@DeleteMapping("/api/todoItems/{listId}/{itemId}")
	public ResponseEntity<?> deleteTodoItems(@PathVariable Integer listId,@PathVariable Integer itemId){
		
		todoServcie.deleteTodoItem(listId,itemId);
		TodoItem deletedItem=new TodoItem();
		deletedItem.setId(itemId);
		return ResponseEntity.status(HttpStatus.OK).body(deletedItem);
	}
	

	@GetMapping("/api/todoLists")
	public ResponseEntity<?> fetchAllTodoLists(){
		
		List<TodoList> todoLists = todoServcie.fetchAllTodoLists();
		
		return ResponseEntity.status(HttpStatus.OK).body(todoLists);
	}
	
	@PutMapping("/api/todoLists/{id}")
	public ResponseEntity<?> updateTodoList(@PathVariable Integer id, @RequestBody TodoList todoList){
		
		TodoList udpatedTodoList = todoServcie.updateTodoList(id, todoList);
		
		return ResponseEntity.status(HttpStatus.OK).body(udpatedTodoList);
	}
	
	@PostMapping("/api/todoLists")
	public ResponseEntity<?> createNewTodoLists(){
		
		TodoList todoList = todoServcie.createTodoList();

		return ResponseEntity.status(HttpStatus.OK).body(todoList);
	}
	
	@DeleteMapping("/api/todoLists/{id}")
	public ResponseEntity<?> deleteTodoLists(@PathVariable Integer id){
		
		todoServcie.deleteTodoList(id);
		TodoList deletedList=new TodoList();
		deletedList.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(deletedList);
	}
	
	@GetMapping("/api/todoItems/{listId}")
	public ResponseEntity<?> fetchAllTodoItems(@PathVariable Integer listId){

		List<TodoItem> todoItems = todoServcie.fetchAllTodoItems(listId);
		
		return ResponseEntity.status(HttpStatus.OK).body(todoItems);
	}
	
}
