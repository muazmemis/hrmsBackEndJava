package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	Result changeToActive(int id);
	
	DataResult<JobAdvertisement>getById(int id);

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
	
	DataResult<List<JobAdvertisement>> getByIsActive();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByDeadlineDesc();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_Id(int employerId);

	DataResult<List<JobAdvertisement>> getByCity_CityId(int cityId);

	DataResult<List<JobAdvertisement>> getByJobTitle_JobTitleId(int jobTitleId);
}
