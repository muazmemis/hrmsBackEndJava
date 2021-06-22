package software.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.JobAdvertisementService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.ErrorDataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.JobAdvertisement;
import software.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements/")
public class JobAdvertisementsController {

	private final JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping(value = "add")
	private ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}

	@PostMapping("changeToActive")
	public Result changeToActive(@RequestParam int id) {
		return this.jobAdvertisementService.changeToActive(id);
	}

	@GetMapping("getAll")
	private DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("getAllByPage")
	private DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		return this.jobAdvertisementService.getAll(pageNo, pageSize);
	}

	@GetMapping("getActive")
	public DataResult<List<JobAdvertisementDto>> getActive() {
		return this.jobAdvertisementService.getByIsActive();
	}

	@GetMapping("getActiveOrderByDeadline")
	public DataResult<List<JobAdvertisementDto>> getOrderByApplicationDeadline() {
		return this.jobAdvertisementService.getByIsActiveTrueOrderByDeadlineDesc();
	}

	@GetMapping("getActiveEmployer")
	public DataResult<List<JobAdvertisementDto>> getActiveEmployer(@RequestParam int employerId) {
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_Id(employerId);
	}

	@GetMapping("getByCityId")
	public DataResult<List<JobAdvertisement>> getByCity_CityId(@RequestParam int cityId) {
		return this.jobAdvertisementService.getByCity_CityId(cityId);
	}

	@GetMapping("getByJobTitleId")
	public DataResult<List<JobAdvertisement>> JobTitleId(@RequestParam int jobTitleId) {
		return this.jobAdvertisementService.getByJobTitle_JobTitleId(jobTitleId);
	}

}
