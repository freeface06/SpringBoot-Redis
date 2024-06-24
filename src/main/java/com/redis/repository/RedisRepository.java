package com.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.vo.TodoVO;

@Repository
public class RedisRepository {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static final String KEY = "TODO";

	// Todo 저장
	public void save_todo(TodoVO todo) {
		redisTemplate.opsForHash().put(KEY, todo.getId(), todo);
		;
	}

	// Todo 한건 가져오기
	public TodoVO get_todo(int id) {
		return (TodoVO) redisTemplate.opsForHash().get(KEY, id);
	}

	// Todo 여러건 가져오기
	public List<Object> get_todos() {
		return redisTemplate.opsForHash().values(KEY);
	}

	// Todo 삭제
	public Long delete_todo(int id) {
		return redisTemplate.opsForHash().delete(KEY, id);
	}
}
