package com.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.PostDAOImpl;
import dao.springConnection;
import model.Post;

@Configuration
public class BeanRepos {
	@Bean
	public springConnection getConnection() {
		return new springConnection();
	}
	
	@Bean("postdaoimpl")
	public PostDAOImpl getPostDAOImpl() {
		return new PostDAOImpl();
	}
	
	@Bean("post")
	public Post getPost() {
		return new Post();
	}
}
