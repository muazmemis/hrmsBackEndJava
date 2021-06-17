package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import software.hrms.business.abstracts.UserService;
import software.hrms.business.constants.Messages;
import software.hrms.core.concretes.User;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.core.abstracts.UserDao;

public class UserManager implements UserService{

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.userAdded);
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult(Messages.userDeleted);
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.usersListed);
	}

}
