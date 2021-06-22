package software.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import software.hrms.business.abstracts.JobAdvertisementService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.ErrorResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.core.utilities.results.SuccessDataResult;
import software.hrms.core.utilities.results.SuccessResult;
import software.hrms.dataAccess.abstracts.JobAdvertisementDao;
import software.hrms.entities.concretes.JobAdvertisement;
import software.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setCreatedDate(LocalDate.now());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public Result changeToActive(int id) {

		if (getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı yok!");
		}
		if (getById(id).getData().isActive() == false) {
			return new SuccessResult("İş ilani zaten kapalı!");
		}
		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarılı şekilde kapatıldı!");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent(),
				"Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActive() {

		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActiveTrueOrderByDeadlineDesc() {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getByIsActiveTrueOrderByDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActiveTrueAndEmployer_Id(int employerId) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_Id(employerId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCity_CityId(int cityId) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCity_CityId(cityId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobTitle_JobTitleId(int jobTitleId) {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByJobTitle_JobTitleId(jobTitleId));
	}

}
