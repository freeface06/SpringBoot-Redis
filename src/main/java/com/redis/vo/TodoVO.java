package com.redis.vo;

import java.io.Serializable;

public class TodoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
