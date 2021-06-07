package software.hrms.core.utilities.adapters;

import software.hrms.entities.concretes.Candidate;

public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean CheckIfRealPerson(Candidate candidate) {
		if (candidate.getIdentityNumber().length() == 11 && candidate.getBirthOfYear() > 1970) {
			return true;
		} else {
			return false;
		}
	}

}
