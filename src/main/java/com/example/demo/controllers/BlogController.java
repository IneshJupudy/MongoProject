package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Blog;
import com.example.demo.model.Comment;
import com.example.demo.repositories.BlogRepository;

@RestController
public class BlogController {
	
	@Autowired
	public BlogRepository blogrepository;
	
	@GetMapping(value = "/all")
	public List<Blog> getAllBlogs() {
		return blogrepository.findAll();
	}
	
	@PostMapping(value = "/all")
	public String addBlog(@RequestBody Blog blog) {	
		Blog insertedBlog = blogrepository.insert(blog); 
		return "Blog Successfully Created:" + insertedBlog.getName() + "!";
	}
	
	@GetMapping("/all/{id}")
    public Optional<Blog> getBlogByID(@PathVariable(value = "id") Long blogID)
	{
        return blogrepository.findById(blogID);
    }
	
	@DeleteMapping("/all/{id}")
    public Optional < Blog > deleteBlogByID(@PathVariable(value = "id") Long blogID)
    {
		Optional <Blog> deletedBlog= blogrepository.findById(blogID);
		blogrepository.deleteById(blogID);
		return deletedBlog;
    }
	
	@PutMapping("/all/{id}")
    public Blog updateBlogByID(@PathVariable(value = "id") Long blogID, @RequestBody String blogName)
    {
		 Optional<Blog> currentBlog= blogrepository.findById(blogID);
		 Blog currentBlogVal = currentBlog.get();
		 currentBlogVal.setName(blogName);
		 blogrepository.deleteById(blogID);
		 
		 Blog updatedBlog= blogrepository.save(currentBlogVal);

		 return updatedBlog;
		 
		
    }
	
	//Level 2
	
	@PostMapping(value = "/all/{id}/comments")
    public Blog addComment(@PathVariable(value = "id") Long blogID, @RequestBody Comment comment)
    {
		Optional<Blog> currentBlog= blogrepository.findById(blogID);
		Blog currentBlogVal = currentBlog.get();
		
		currentBlogVal.addComment(comment);
		Blog updatedBlog= blogrepository.save(currentBlogVal);
		
		return updatedBlog;

    }
	
	@GetMapping("/all/{id}/comments")
    public List<Comment> getAllComments(@PathVariable(value = "id") Long blogID)
	{
		
		Optional<Blog> currentBlog= blogrepository.findById(blogID);
		Blog currentBlogVal = currentBlog.get();
		
        return currentBlogVal.getComments();
    }
	
	
	
	//Level 3
	@PostMapping(value = "/all/{id}/comments/{commentId}")
    public Blog addReplyToComment(@PathVariable(value = "id") Long blogID, @RequestBody String reply, @PathVariable(value = "commentId") Long commentID)
    {
		Optional<Blog> currentBlog= blogrepository.findById(blogID);
		Blog currentBlogVal = currentBlog.get();
		
		Comment currentComment = currentBlogVal.findComment(commentID);
		
		currentComment.addReply(reply);
		
		Blog updatedBlog= blogrepository.save(currentBlogVal);
		
		return updatedBlog;

    }
	
	@GetMapping("/all/{id}/comments/{commentId}")
	public List<String> getAllReplies(@PathVariable(value = "id") Long blogID, @PathVariable(value = "commentId") Long commentID)
	{
		
		Optional<Blog> currentBlog= blogrepository.findById(blogID);
		Blog currentBlogVal = currentBlog.get();
		Comment currentComment = currentBlogVal.findComment(commentID);
		
        return currentComment.getReplies();
    }
	
	
	
	
	
	
	
	

}











