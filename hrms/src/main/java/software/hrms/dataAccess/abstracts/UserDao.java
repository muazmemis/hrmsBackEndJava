package software.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.core.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
