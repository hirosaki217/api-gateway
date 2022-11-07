package spring.redis.crud.app.repository;
import org.springframework.data.repository.CrudRepository;

import spring.redis.crud.app.model.Employee;
public interface EmployeeRepository extends CrudRepository<Employee, String>{

}
