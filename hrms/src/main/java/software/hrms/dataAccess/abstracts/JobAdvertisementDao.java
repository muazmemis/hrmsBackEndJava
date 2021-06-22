package software.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import software.hrms.entities.concretes.JobAdvertisement;
import software.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	String query="Select new software.hrms.entities.dtos.JobAdvertisementDto"
			+ "(j.id,  j.numberOfAvailablePosition, j.createdDate, j.deadline, e.companyName, jt.title)"
			+ " From Employer e Inner Join e.jobAdvertisements j "
			+ "Inner Join j.jobTitle jt"
			+ " where j.isActive = true";
	
	List<JobAdvertisement> getByJobTitle(int jobTitleId);

	List<JobAdvertisement> getByCity_CityId(int cityId);

	List<JobAdvertisement> getByJobTitle_JobTitleId(int jobTitleId);	
	
	@Query(query)
	List<JobAdvertisementDto> getByIsActiveTrue();

	@Query(query)
	List<JobAdvertisementDto> getByIsActiveTrueOrderByDeadlineDesc();

	@Query(query)
	List<JobAdvertisementDto> getByIsActiveTrueAndEmployer_Id(int employerId);

}
