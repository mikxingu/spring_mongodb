package com.mikxingu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mikxingu.controllers.util.URL;
import com.mikxingu.domain.Post;
import com.mikxingu.services.PostService;

@RestController()
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {

		Post obj = postService.findById(id);

		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findPostByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		
		text = URL.decodeParam(text);
		
		List<Post> posts = postService.findByTitle(text);

		return ResponseEntity.ok().body(posts);
	}
}