package com.jk.todoapp.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jk.todoapp.domain.TodoItem;
import com.jk.todoapp.domain.TodoList;

@Repository
public class TodoRepository {
	
	private Integer idCounter=0;
	private List<TodoItem> todoItems = new ArrayList<>();
	
	
	public TodoItem save(TodoItem todoItem, int listId) {
		
		for(TodoList todoList:todoLists) {
			if(todoList.getId()==listId) {
				todoItems = todoList.getTodoList();
			}
		}
		int count = todoItems.size();
		todoItem.setId(++count);
		todoItems.add(todoItem);
		
		return todoItem;
	}


	public void deleteItem(int listId,int itemId) {
		
		for(TodoList todoList:todoLists) {
			if(todoList.getId()==listId) {
				todoItems = todoList.getTodoList();
			}
		}
		TodoItem todoItemToDelete=null;
		for(TodoItem todoItem: todoItems) {
			if(todoItem.getId()==itemId) {
				todoItemToDelete=todoItem;
			}
		}
		todoItems.remove(todoItemToDelete);
		
	}
	
	private Integer listCounter=0;
	private List<TodoList> todoLists = new ArrayList<>();
	
	public List<TodoList> fetchAllTodoLists(){
		
		return todoLists;
	}
	
	
	public TodoList saveList(TodoList todoList) {
		todoList.setId(++listCounter);
		todoLists.add(todoList);
		
		return todoList;
	}


	public void deleteList(Integer id) {
		
		todoLists = todoLists.stream().filter(todoList-> !todoList.getId().equals(id)).collect(Collectors.toList());
		
	}
	
	public List<TodoItem> fetchAllTodoItems(int todoListId){
		
		for(TodoList todoList:todoLists) {
			if(todoList.getId()==todoListId) {
				todoItems = todoList.getTodoList();
			}
		}
		for(TodoItem todoItem: todoItems) {
			if(todoItem.getDueDate().compareTo(LocalDate.now())<=0) {
				todoItem.setIsDue(true);
			}else {
				todoItem.setIsDue(false);
			}
		}
		return todoItems;
	}
	
}
