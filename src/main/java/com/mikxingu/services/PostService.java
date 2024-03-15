package com.mikxingu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikxingu.domain.Post;
import com.mikxingu.repositores.PostRepository;
import com.mikxingu.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {

		Optional<Post> post = postRepository.findById(id);
		if (post == null) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return post.get();
	}
}