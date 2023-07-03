package org.edupoll.model;

import java.util.Date;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Todo {

	private String id; // 고유 식별자
	private String owner; // 목표 설정자

	@NotBlank
	private String description; // 목표 내용

	@Future
	@NotNull
	private Date targetDate; // 달성할 날짜

	private String done; // 달성 여부
	private boolean warning;

	// 기본 생성자
	public Todo() {
	}

	// 전체 생성자
	public Todo(String id, String owner, String description, Date targetDate, String done) {
		this.id = id;
		this.owner = owner;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	// setter & getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	// toString()
	@Override
	public String toString() {
		return "Todo [id=" + id + ", owner=" + owner + ", description=" + description + ", targetDate=" + targetDate
				+ ", done=" + done + ", warning=" + warning + "]";
	}

}
