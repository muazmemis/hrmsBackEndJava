package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import software.hrms.business.abstracts.EmployerService;
import software.hrms.business.constants.Messages;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAccess.abstracts.EmployerDao;
import software.hrms.dataAccess.abstracts.UserDao;
import software.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private final EmployerDao employerDao;
	private final UserDao userDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}
	
	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult(Messages.employerAdded);
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult(Messages.employerDeleted);
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.employersListed);
	}
}
