package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	Result add(JobTitle jobTitle);
	Result delete(JobTitle jobTitle);
	DataResult<List<JobTitle>> getAll();
}
