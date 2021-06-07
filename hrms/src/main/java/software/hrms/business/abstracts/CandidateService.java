package software.hrms.business.abstracts;

import java.util.List;

import software.hrms.core.utilities.results.DataResult;
import software.hrms.core.utilities.results.Result;
import software.hrms.entities.concretes.Candidate;

public interface CandidateService {

	Result add(Candidate candidate);
	Result delete(Candidate candidate);
	DataResult<List<Candidate>> getAll();
}
