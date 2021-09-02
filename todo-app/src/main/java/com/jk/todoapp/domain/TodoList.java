package com.jk.todoapp.domain;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
	private Integer id;
	private String title;
	private List<TodoItem> todoList;
	private Boolean isDone;
	
	public TodoList() {
		todoList = new ArrayList<>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<TodoItem> getTodoList() {
		return todoList;
	}
	public void setTodoList(List<TodoItem> todoList) {
		this.todoList = todoList;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
