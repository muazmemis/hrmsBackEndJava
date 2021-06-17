package software.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import software.hrms.business.abstracts.EmployerService;
import software.hrms.business.constants.Messages;
import software.hrms.core.utilities.business.BusinessRules;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.ErrorResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.core.utilities.verificationCode.VerificationCodeService;
import software.hrms.dataAccess.abstracts.EmployerDao;
import software.hrms.core.abstracts.UserDao;
import software.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private final EmployerDao employerDao;
	private final UserDao userDao;
	private final VerificationCodeService verificationCodeService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao, VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
		
	}

	@Override
	public Result register(Employer employer) {
		Result result = BusinessRules.run(existEmail(employer.getEmail()),
				checkWebAddress(employer.getWebSiteAdress(),employer.getEmail()));

		if (result != null) {
			return result;
		}

		this.verificationCodeService.sendVerificationCode(employer.getEmail());
		this.employerDao.save(employer);
		return new SuccessResult(Messages.employerAdded);
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.employersListed);
	}
		
	private Result checkWebAddress(String website, String email) {
		
		String domain = email.split("@")[1];
		
		if(!website.contains(domain)) {
			return new ErrorResult("Email adresi website domaini ile örtüşmüyor");
		}
		
		return new SuccessResult();
	}
	
	private Result existEmail(String email) {
		if (this.userDao.getByEmailEquals(email)!=null) {
			return new ErrorResult("Email adresi ile daha önce kayıt oluşturulmuştur");
		}
		
		return new SuccessResult();
	}
}
