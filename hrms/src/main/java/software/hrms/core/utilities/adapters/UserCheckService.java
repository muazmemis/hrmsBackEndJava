package software.hrms.core.utilities.adapters;

import software.hrms.entities.concretes.Candidate;

public interface UserCheckService {
	boolean CheckIfRealPerson(Candidate candidate);
}
