package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.concretes.User;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	Result delete(User user);
	DataResult<List<User>> getAll();
}
