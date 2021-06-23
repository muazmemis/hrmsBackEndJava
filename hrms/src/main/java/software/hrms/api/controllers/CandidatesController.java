package software.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import software.hrms.core.utilities.results.ErrorDataResult;
import software.hrms.business.abstracts.CandidateService;
import software.hrms.core.utilities.results.DataResult;
import software.hrms.entities.concretes.Candidate;

import java.util.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidates/")
public class CandidatesController {

    private final CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }

    @PostMapping(value = "register")
    private ResponseEntity<?> register(@Valid @RequestBody Candidate candidate){
        return ResponseEntity.ok(this.candidateService.register(candidate));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}

    @GetMapping("getall")
    private DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }
}
