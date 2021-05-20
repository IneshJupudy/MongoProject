package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {

	@Id
	public long commentID;
	public String comment;
	public List<String> replies;
	
	public Comment(long commentID, String comment, List<String> replies) {
		super();
		this.commentID = commentID;
		this.comment = comment;
		this.replies = replies;
	}

	public long getCommentID() {
		return commentID;
	}

	public void setCommentID(long commentID) {
		this.commentID = commentID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<String> getReplies() {
		return replies;
	}

	public void setReplies(List<String> replies) {
		this.replies = replies;
	}
	
	public void addReply(String reply) {
		this.replies.add(reply);
	} 

	
}
