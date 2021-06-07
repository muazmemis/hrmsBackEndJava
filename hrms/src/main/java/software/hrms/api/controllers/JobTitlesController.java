package software.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.hrms.business.abstracts.JobTitleService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles/")
public class JobTitlesController {
	
	private final JobTitleService jobTitleService;
	
	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@PostMapping("add")
	public Result Add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}	
	
	@GetMapping("getall")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobTitleService.getAll();
	}
}
