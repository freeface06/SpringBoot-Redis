package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.redis.repository.RedisRepository;
import com.redis.vo.TodoVO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class RedisController {

	@Autowired
	private RedisRepository redisRepository;

	@PostMapping("/save_todo")
	public boolean save_todo(@RequestBody TodoVO todo) {
		System.out.println(todo);
		try {
			redisRepository.save_todo(todo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("/get_todo/{id}")
	public TodoVO get_todo(@PathVariable int id) {
		return redisRepository.get_todo(id);
	}
	
	@GetMapping("/get_todos")
	public List<Object> get_todos() {
		return redisRepository.get_todos();
	}
	
	@DeleteMapping("/delete_todo/{id}")
	public boolean delete_todo(@PathVariable int id) {
		try {
			redisRepository.delete_todo(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
