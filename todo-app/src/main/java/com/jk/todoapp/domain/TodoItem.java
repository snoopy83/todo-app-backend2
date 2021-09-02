package com.jk.todoapp.domain;

import java.time.LocalDate;

public class TodoItem {
	
	
	private Integer id;
	private String task;
	private Boolean isDone;
	private LocalDate dueDate;
	private Boolean isDue;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate date) {
		this.dueDate = date;
	}
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof TodoItem)) return false;
	    TodoItem o = (TodoItem) obj;
	    return o.getId() == this.getId();
	}
	public Boolean getIsDue() {
		return isDue;
	}
	public void setIsDue(Boolean isDue) {
		this.isDue = isDue;
	}
}
