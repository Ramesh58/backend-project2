package com.niit.dao;

import java.util.List;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;

public interface BlogPostDao {
	void saveBlogPost(BlogPost blogPost);
	List<BlogPost> getAllBlogs(int approved);
	void updateBlogPost(BlogPost blogPost);
	BlogPost getBlogById(int id);
	void addBlogComment(BlogComment blogComment);
	
	List<BlogComment> getBlogComments(int blogId);
}
