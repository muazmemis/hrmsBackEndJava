package software.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.hrms.business.abstracts.CandidateService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Candidate;

import java.util.List;

@RestController
@RequestMapping("/api/candidates/")
public class CandidatesController {

    private final CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }

    @PostMapping("add")
    private Result add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }

    @PostMapping("delete")
    private Result delete(@RequestBody Candidate candidate){
        return this.candidateService.delete(candidate);
    }

    @GetMapping("getall")
    private DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }
}
