package com.jk.todoapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.todoapp.domain.TodoItem;
import com.jk.todoapp.domain.TodoList;
import com.jk.todoapp.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepo;
	
	public TodoItem updateTodoItem(Integer listId,Integer itemId, TodoItem todoItem) {
		Optional<TodoItem> todoOpt = todoRepo.fetchAllTodoItems(listId)
		.stream().filter(item->item.getId().equals(itemId))
		.findAny();
		
		if(todoOpt.isPresent()) {
			TodoItem item = todoOpt.get();
			item.setIsDone(todoItem.getIsDone());
			item.setTask(todoItem.getTask());
			item.setDueDate(todoItem.getDueDate());
			return item;
		}
		
		return null;
	}

	public TodoItem createTodoItem(int listId) {
		
		TodoItem todoItem = new TodoItem();
		
		todoItem.setIsDone(false);
		todoItem.setDueDate(LocalDate.now());
		todoItem.setIsDue(false);
		todoItem = todoRepo.save(todoItem, listId);
		
		todoItem.setTask("Task #"+todoItem.getId());
		
		return todoItem;
	}

	public void deleteTodoItem(int listId, int itemId) {
		
		todoRepo.deleteItem(listId, itemId);
	}

	
	public List<TodoList> fetchAllTodoLists(){
		return todoRepo.fetchAllTodoLists();
	}

	public TodoList updateTodoList(Integer id, TodoList todoList) {
		Optional<TodoList> todolistOpt = todoRepo.fetchAllTodoLists()
		.stream().filter(list->list.getId().equals(id))
		.findAny();
		
		if(todolistOpt.isPresent()) {
			TodoList list = todolistOpt.get();
			list.setIsDone(todoList.getIsDone());
			list.setTitle(todoList.getTitle());
			
			return list;
		}
		
		return null;
	}

	public TodoList createTodoList() {
		
		TodoList todoList = new TodoList();
		
		todoList.setIsDone(false);
		
		todoList = todoRepo.saveList(todoList);
		
		todoList.setTitle("List #"+todoList.getId());
		
		return todoList;
	}

	public void deleteTodoList(Integer id) {
		
		todoRepo.deleteList(id);
	}
	
	public List<TodoItem> fetchAllTodoItems(int todoListId){
		return todoRepo.fetchAllTodoItems(todoListId);
		
		
	}
}
