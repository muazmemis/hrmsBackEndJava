package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
