package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	Result delete(Employer employer);
	DataResult<List<Employer>> getAll();
}
