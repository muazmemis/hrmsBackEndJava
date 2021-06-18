package software.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByJobTitle(int jobTitleId);

	List<JobAdvertisement> getByCity_CityId(int cityId);

	List<JobAdvertisement> getByJobTitle_JobTitleId(int jobTitleId);

	// @Query("From JobAdvertisement where isActive = true")
	 List<JobAdvertisement> getByIsActiveTrue();

	// @Query("From JobAdvertisement where isActive = true Order By deadline Desc")
	 List<JobAdvertisement> getByIsActiveTrueOrderByDeadlineDesc();

	// @Query("From JobAdvertisement where isActive = true and employer.id =:id")
	 List<JobAdvertisement> getByIsActiveTrueAndEmployer_Id(int employerId);
	
	/*
	@Query("Select new software.hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, jt.title, j.numberOfAvailablePosition, j.createdDate, j.deadline)"
			+ " From JobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle jt" + " where isActive = true")
	List<JobAdvertisementDto> getByIsActiveTrue();

	List<JobAdvertisementDto> getByIsActiveTrueOrderByDeadlineDesc();

	List<JobAdvertisementDto> getByIsActiveTrueAndEmployer_Id(int employerId);
*/

}
