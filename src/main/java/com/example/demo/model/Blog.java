package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Blog")
public class Blog {
	
	
	@Id
	private long id;
	private String name;
	
	private List<Comment> comments;

	public Blog() {
		super();	
	}

	public Blog(long id, String name, long commentID, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		for(int i = 0; i < comments.size(); i++) {
			 this.comments.add(new Comment(comments.get(i).commentID, comments.get(i).comment,new ArrayList<String>()));
			}
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		this.comments.add(new Comment(comment.commentID, comment.comment,new ArrayList<String>()));
	}

	public Comment findComment(long commentID) {
		for(int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getCommentID() == commentID) {
				return comments.get(i);
			}
			} 
		return null;
	}
	
	
	
	
	
	
}
