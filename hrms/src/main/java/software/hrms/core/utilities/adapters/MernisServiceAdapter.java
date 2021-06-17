package software.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import software.hrms.entities.concretes.Candidate;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		if (candidate.getIdentityNumber().length() == 11 && candidate.getBirthOfYear() > 1970) {
			return true;
		} else {
			return false;
		}
	}

}
