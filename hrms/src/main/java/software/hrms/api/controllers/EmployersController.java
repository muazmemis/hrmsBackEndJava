package software.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.hrms.business.abstracts.EmployerService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("add")
    private Result add(Employer employer) {
        return this.employerService.add(employer);
    }

    @PostMapping("delete")
    private Result delete(Employer employer) {
        return this.employerService.delete(employer);
    }

    @GetMapping("getall")
    private DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

}
