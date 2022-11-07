package spring.redis.crud.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@RedisHash("employee")
@Data
public class Employee {
	@Id
	private String id;
	private String name;
}
