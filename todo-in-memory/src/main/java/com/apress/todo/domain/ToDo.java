package com.apress.todo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ToDo {

	@NotNull
	private String id;

	@NotNull
	@NotBlank
	private String description;
	private LocalDateTime created;
	private LocalDateTime modified;
	private boolean completed;

	public ToDo() {
		LocalDateTime date = LocalDateTime.now();
		this.id = UUID.randomUUID().toString();
		this.created = date;
		this.modified = date;
	}

	public ToDo(String description) {
		this();
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + ", created=" + created + ", modified=" + modified
				+ ", completed=" + completed + "]";
	}

}