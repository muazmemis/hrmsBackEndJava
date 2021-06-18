package software.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User getByEmailEquals(String email); 
}

