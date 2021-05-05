package de.andrej.restservice.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {
		
	@Id private Integer id;
	private String description;
	private Date duedate;
	private Boolean done ;
	private Integer priority;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
	public String getDescription() { 
		return description;
	}
	
	
	public void setDueDate(Date duedate) {
		this.duedate = duedate;
	}

	public Date getDueDate() {
		return duedate;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
	public Boolean getDone() {
		return done;
	}
	
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getPriority() {
		return priority;
	}


	@Override
	public String toString() {
		return "ToDo{" + "id='" + id + '\'' + ", description='" + description + '\'' + ", duedate='" + duedate + '\''
				+ ", done='" + done + '\'' +", priority='" + priority + '\'' + '}';
	}
}
